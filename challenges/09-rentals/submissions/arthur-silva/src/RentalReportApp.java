import java.io.IOException;     
import java.io.InputStream;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
    
public class RentalReportApp {

    // Consulta SQL fornecida no README
    private static final String SQL_QUERY = 
        "SELECT c.first_name as \"Nome\", " +
        "       c.last_name as \"Sobrenome\", " +
        "       c.email as \"Email\", " +
        "       SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r " +
        "JOIN customer c ON c.customer_id = r.customer_id " +
        "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        
        // 1. Validar argumento de linha de comando
        if (args.length < 1) {
            System.err.println("Erro: Informe o valor mínimo de gastos como argumento.");
            return;
        }

        double minValue;
        try {
            minValue = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um número válido.");
            return;
        }

        Properties props = new Properties();
        List<RentalSummary> results = new ArrayList<>();

        // 2. Carregar db.properties e Conectar ao Banco
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);

            // Validar chaves obrigatórias (opcional, mas boa prática)
            if (!props.containsKey("db.url") || !props.containsKey("db.user")) {
                throw new RuntimeException("Arquivo db.properties incompleto.");
            }

            // Estabelecer Conexão
            try (Connection conn = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password"));
                 PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {

                System.out.println("Conectado ao banco de dados com sucesso!");

                // 3. Executar Consulta
                stmt.setDouble(1, minValue); // Substitui o ? pelo valor do argumento

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String fName = rs.getString("Nome");
                        String lName = rs.getString("Sobrenome");
                        String email = rs.getString("Email");
                        double total = rs.getDouble("Valor Gasto");

                        // 4. Armazenar em coleção em memória
                        results.add(new RentalSummary(fName, lName, email, total));
                    }
                }
            }

        } catch (IOException ex) {
            System.err.println("Erro ao ler arquivo de propriedades: " + ex.getMessage());
            return;
        } catch (SQLException ex) {
            System.err.println("Erro de banco de dados: " + ex.getMessage());
            return;
        }

        // 5. Gerar arquivo CSV
        String csvPath = props.getProperty("csv.path", "rentals.csv");
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath), 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            
            // Escrever cabeçalho
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            // Escrever dados da lista
            for (RentalSummary summary : results) {
                writer.write(summary.toString());
                writer.newLine();
            }

            System.out.println("Relatório gerado com sucesso em: " + csvPath);
            System.out.println("Total de registros encontrados: " + results.size());

        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo CSV: " + e.getMessage());
        }
    }
}