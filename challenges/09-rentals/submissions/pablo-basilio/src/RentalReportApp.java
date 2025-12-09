import java.io.BufferedReader;
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

    private static final String QUERY = 
        "SELECT c.first_name as \"Nome\", " +
        "c.last_name as \"Sobrenome\", " +
        "c.email as \"Email\", " +
        "SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r " +
        "JOIN customer c ON c.customer_id = r.customer_id " +
        "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Por favor, forneça o valor mínimo como argumento.");
            System.exit(1);
        }

        double minimumValue = 0;
        try {
            minimumValue = Double.parseDouble(args[0]);
        } catch (NumberFormatException ex) {
            System.err.println("O argumento deve ser um número válido.");
            System.exit(1);
        }

        Properties config = new Properties();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("db.properties"))) {
            config.load(reader);
        } catch (IOException e) {
            System.err.println("Falha ao ler db.properties: " + e.getMessage());
            // Tentativa de fallback
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("../db.properties"))) {
                config.load(reader);
            } catch (IOException ex) {
                System.err.println("db.properties não encontrado.");
                System.exit(1);
            }
        }

        String dbUrl = config.getProperty("db.url");
        String dbUser = config.getProperty("db.user");
        String dbPass = config.getProperty("db.password");
        String outputCsv = config.getProperty("csv.path", "rentals.csv");

        List<RentalSummary> reportData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(QUERY)) {

            System.out.println("Conexão estabelecida. Executando consulta...");
            statement.setDouble(1, minimumValue);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    reportData.add(new RentalSummary(
                        resultSet.getString("Nome"),
                        resultSet.getString("Sobrenome"),
                        resultSet.getString("Email"),
                        resultSet.getDouble("Valor Gasto")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro na comunicação com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputCsv))) {
            for (RentalSummary item : reportData) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Arquivo CSV gerado com sucesso: " + outputCsv);
            System.out.println("Registros exportados: " + reportData.size());
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }
    }
}
