import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalReportApp {
    private static final String QUERY =
            "SELECT c.first_name, c.last_name, c.email, SUM(p.amount) as amount " +
                    "FROM rental r " +
                    "JOIN customer c ON c.customer_id = r.customer_id " +
                    "JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id " +
                    "GROUP BY c.first_name, c.last_name, c.email " +
                    "HAVING SUM(p.amount) > ? " +
                    "ORDER BY SUM(p.amount) DESC";

    static void main(String[] args) {
        List<RentalSummary> summaries = new ArrayList<>();
        double value = args.length == 0 ? 100 : Double.parseDouble(args[0]);
        if (args.length == 0) System.out.println("Uilizando arg default: 100");

        try {
            Config config = new Config();
            DataSource datasource = new DataSource(config.getUrl(), config.getUser(), config.getPassword());
            Connection connection = datasource.getConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY);

            statement.setDouble(1, value);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                summaries.add(new RentalSummary(
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getDouble("amount")
                ));
            }

            datasource.close();

            new Report(config.getPath(), summaries).generateCSV();
        } catch (IOException e) {
            System.out.printf("Ocorreu um erro ao ler o arquivo: %s", e.getMessage());
        } catch (SQLException e) {
            System.out.printf("Ocorreu no banco de dados: %s", e.getMessage());
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}
