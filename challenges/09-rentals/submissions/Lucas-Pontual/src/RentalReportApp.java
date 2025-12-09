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
import java.util.Properties;

public class RentalReportApp {
    
    private static final String QUERY = 
        "SELECT c.first_name as \"Nome\", " +
        "       c.last_name as \"Sobrenome\", " +
        "       c.email as \"Email\", " +
        "       SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r " +
        "JOIN customer c ON c.customer_id = r.customer_id " +
        "JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) DESC";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Erro: É necessário fornecer o valor mínimo gasto como argumento.");
            System.err.println("Uso: java RentalReportApp <valor_minimo>");
            System.exit(1);
        }

        double minimumAmount;
        try {
            minimumAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um número válido.");
            System.exit(1);
            return;
        }

        Properties properties = new Properties();
        Path propertiesPath = Paths.get("db.properties");
        
        try (InputStream input = Files.newInputStream(propertiesPath)) {
            properties.load(input);
            
            String[] requiredKeys = {"db.url", "db.user", "db.password", "csv.path"};
            for (String key : requiredKeys) {
                if (!properties.containsKey(key)) {
                    System.err.println("Erro: Chave obrigatória '" + key + "' não encontrada em db.properties");
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo db.properties: " + e.getMessage());
            System.exit(1);
            return;
        }

        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");
        String csvPath = properties.getProperty("csv.path");

        ArrayList<RentalSummary> rentals = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement(QUERY)) {
            
            statement.setDouble(1, minimumAmount);
            
            System.out.println("Executando consulta com valor mínimo: " + minimumAmount);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("Nome");
                    String lastName = resultSet.getString("Sobrenome");
                    String email = resultSet.getString("Email");
                    double amount = resultSet.getDouble("Valor Gasto");
                    
                    RentalSummary rental = new RentalSummary(firstName, lastName, email, amount);
                    rentals.add(rental);
                }
            }
            
            System.out.println("Total de registros encontrados: " + rentals.size());
            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou executar consulta no banco de dados: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();
            
            for (RentalSummary rental : rentals) {
                writer.write(rental.toString());
                writer.newLine();
            }
            
            System.out.println("Arquivo CSV gerado com sucesso: " + csvPath);
            
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo CSV: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
