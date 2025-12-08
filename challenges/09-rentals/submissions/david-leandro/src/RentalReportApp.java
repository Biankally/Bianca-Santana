
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
public class RentalReportApp {
    
    public static void main(String[] args) {
        // Validar argumento de linha de comando
        if (args.length == 0) {
            System.err.println("Erro: Forneça o valor mínimo gasto como argumento.");
            System.err.println("Uso: java RentalReportApp <valor_minimo>");
            System.exit(1);
        }
        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O valor fornecido não é um número válido: " + args[0]);
            System.exit(1);
            return;
        }
        Properties props = loadDatabaseProperties();
        
        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPassword = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");
        // ArrayList para armazenar os resultados
        ArrayList<RentalSummary> summaries = new ArrayList<>();
        // Consulta SQL predefinida
        String query = "SELECT c.first_name as \"Nome\", " +
                "c.last_name as \"Sobrenome\", " +
                "c.email as \"Email\", " +
                "SUM(p.amount) as \"Valor Gasto\" " +
                "FROM rental r JOIN customer c ON c.customer_id = r.customer_id " +
                "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
                "GROUP BY c.first_name, c.last_name, c.email " +
                "HAVING SUM(p.amount) > ? " +
                "ORDER BY SUM(p.amount) desc";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setDouble(1, minAmount);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    
                    RentalSummary summary = new RentalSummary(firstName, lastName, email, amount);
                    summaries.add(summary);
                }
            }
            
            System.out.println("✓ Consulta executada com sucesso!");
            System.out.println("✓ " + summaries.size() + " cliente(s) encontrado(s) com gasto > " + minAmount);
            
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        try {
            writeCSV(csvPath, summaries);
            System.out.println("✓ Arquivo CSV gerado com sucesso em: " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo CSV: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    private static Properties loadDatabaseProperties() {
        Properties props = new Properties();
        
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            System.exit(1);
        }
        // Validar chaves obrigatórias
        String[] requiredKeys = {"db.url", "db.user", "db.password", "csv.path"};
        for (String key : requiredKeys) {
            if (!props.containsKey(key)) {
                System.err.println("Erro: Chave obrigatória ausente em db.properties: " + key);
                System.exit(1);
            }
        }
        return props;
    }
    private static void writeCSV(String csvPath, ArrayList<RentalSummary> summaries) throws IOException {
        try (var writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            // Escrever cabeçalho
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();
            
            // Escrever dados
            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
        }
    }
}