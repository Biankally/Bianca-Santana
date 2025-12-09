import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {

    public static void main(String[] args) {
        // 1. Validação do argumento
        if (args.length == 0) {
            System.err.println("Erro: Forneça o valor mínimo (ex: java RentalReportApp 100)");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
            // MENSAGEM 1: Confirmação do valor (%.2f garante 2 casas decimais)
            System.out.printf("✅ Mínimo gasto estabelecido: %.2f%n", minAmount);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um número válido.");
            return;
        }

        Properties props = new Properties();
        List<RentalSummary> summaries = new ArrayList<>();

        // 2. Carregar db.properties
        try {
            if (!Files.exists(Paths.get("db.properties"))) {
                System.err.println("Erro: Arquivo db.properties não encontrado.");
                return;
            }
            props.load(Files.newInputStream(Paths.get("db.properties")));
        } catch (IOException e) {
            System.err.println("Erro ao ler configurações: " + e.getMessage());
            return;
        }

        String sql = "SELECT c.first_name as \"Nome\", " +
                     "       c.last_name as \"Sobrenome\", " +
                     "       c.email as \"Email\", " +
                     "       SUM(p.amount) as \"Valor Gasto\" " +
                     "FROM rental r " +
                     "JOIN customer c ON c.customer_id = r.customer_id " +
                     "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
                     "GROUP BY c.first_name, c.last_name, c.email " +
                     "HAVING SUM(p.amount) > ? " +
                     "ORDER BY SUM(p.amount) desc;";

        // 3. Conexão e Execução
        try (Connection conn = DriverManager.getConnection(
                props.getProperty("db.url"), 
                props.getProperty("db.user"), 
                props.getProperty("db.password"));
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // MENSAGEM 2: Conexão
            System.out.println("🔗 Conexão com o banco de dados estabelecida.");
            
            stmt.setDouble(1, minAmount);

            // MENSAGEM 3: Execução
            System.out.println("🔎 Consulta SQL executada. Processando resultados...");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    summaries.add(new RentalSummary(
                        rs.getString("Nome"), 
                        rs.getString("Sobrenome"), 
                        rs.getString("Email"), 
                        rs.getDouble("Valor Gasto")
                    ));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
            return;
        }

        // 4. Gerar CSV
        String csvPath = props.getProperty("csv.path");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }

            // MENSAGENS FINAIS: Resumo
            System.out.println("✅ Relatório de gastos gerado com sucesso em: " + csvPath);
            System.out.printf("   Total de %d clientes com gastos superiores a %.2f.%n", summaries.size(), minAmount);

        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }
}