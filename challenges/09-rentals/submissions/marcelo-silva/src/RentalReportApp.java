

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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

    private static final String PROPERTIES_FILE = "db.properties";
    private static final String CSV_HEADER = "Nome,Sobrenome,Email,Valor Gasto";
    
    
    private static final String SQL_QUERY = 
        "SELECT  c.first_name as \"Nome\"," +
        "        c.last_name as \"Sobrenome\"," +
        "        c.email as \"Email\"," +
        "        SUM(p.amount) as \"Valor Gasto\"" +
        "FROM " +
        "    rental r JOIN " +
        "    customer c ON c.customer_id = r.customer_id JOIN" +
        "    payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) desc";

    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.err.println("❌ Uso: java RentalReportApp <valor_minimo_gasto>");
            System.err.println("Exemplo: java RentalReportApp 100.00");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("❌ O argumento deve ser um número válido: " + args[0]);
            return;
        }
        
        System.out.printf("✅ Mínimo gasto estabelecido: %.2f%n", minAmount);

        
        Properties props = loadProperties(PROPERTIES_FILE);
        if (props == null) {
            return;
        }

        
        try {
            List<RentalSummary> summaries = generateReport(props, minAmount);
            writeCsvFile(props.getProperty("csv.path"), summaries);
            System.out.println("✅ Relatório de gastos gerado com sucesso em: " + props.getProperty("csv.path"));
            System.out.printf("   Total de %d clientes com gastos superiores a %.2f.%n", summaries.size(), minAmount);
        } catch (SQLException e) {
            System.err.println("❌ Erro de banco de dados (SQL): " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Erro de I/O ao gravar o arquivo CSV: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Erro inesperado durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    private static Properties loadProperties(String filename) {
        Properties props = new Properties();
        Path propPath = Paths.get(filename);
        try (InputStream input = Files.newInputStream(propPath)) {
            props.load(input);
     
            String[] requiredKeys = {"db.url", "db.user", "db.password", "csv.path"};
            for (String key : requiredKeys) {
                if (!props.containsKey(key)) {
                    throw new IllegalArgumentException("Chave obrigatória ausente em db.properties: " + key);
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Erro ao carregar o arquivo de propriedades '" + filename + "': " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Erro de configuração: " + e.getMessage());
            return null;
        }
        return props;
    }

    
    private static List<RentalSummary> generateReport(Properties props, double minAmount) throws SQLException {
        List<RentalSummary> summaries = new ArrayList<>();
        
        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPassword = props.getProperty("db.password");
        
    
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {
            
            System.out.println("🔗 Conexão com o banco de dados estabelecida.");

    
            stmt.setDouble(1, minAmount);
            
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("🔎 Consulta SQL executada. Processando resultados...");
                
    
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
    
                    double amount = rs.getDouble("Valor Gasto"); 
                    
                    RentalSummary summary = new RentalSummary(firstName, lastName, email, amount);
                    summaries.add(summary);
                }
            }
        } 
        
        return summaries;
    }

    
    private static void writeCsvFile(String path, List<RentalSummary> summaries) throws IOException {
        Path csvPath = Paths.get(path);
        
        
        try (BufferedWriter writer = Files.newBufferedWriter(csvPath)) {
        
            writer.write(CSV_HEADER);
            writer.newLine();

        
            for (RentalSummary summary : summaries) {
                // Utiliza o método toString() do RentalSummary que já retorna o formato CSV
                writer.write(summary.toString());
                writer.newLine();
            }
        } 
    }
}