import java.io.BufferedWriter;
import java.io.IOException;
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

    private static final String[] REQUIRED_KEYS = {
            "db.url",
            "db.user",
            "db.password",
            "csv.path"
    };

    private static final String SQL_QUERY =
            "SELECT  c.first_name as \"Nome\", " +
            "        c.last_name as \"Sobrenome\", " +
            "        c.email as \"Email\", " +
            "        SUM(p.amount) as \"Valor Gasto\" " +
            "FROM " +
            "    rental r JOIN " +
            "    customer c ON c.customer_id = r.customer_id JOIN " +
            "    payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
            "GROUP BY c.first_name, c.last_name, c.email " +
            "HAVING SUM(p.amount) > ? " +
            "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Uso: java RentalReportApp <valor-minimo-gasto>");
            System.exit(1);
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: o valor mínimo deve ser numérico.");
            System.exit(1);
            return;
        }

        Properties dbProps = new Properties();
        Path propsPath = Paths.get("db.properties");

        if (!Files.exists(propsPath)) {
            System.err.println("Erro: arquivo db.properties não encontrado.");
            System.exit(1);
        }

        try {
            dbProps.load(Files.newInputStream(propsPath));
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            System.exit(1);
        }

        for (String key : REQUIRED_KEYS) {
            if (dbProps.getProperty(key) == null || dbProps.getProperty(key).trim().isEmpty()) {
                System.err.println("Erro: chave obrigatória faltando em db.properties: " + key);
                System.exit(1);
            }
        }

        String url = dbProps.getProperty("db.url");
        String user = dbProps.getProperty("db.user");
        String password = dbProps.getProperty("db.password");
        String csvPath = dbProps.getProperty("csv.path");

        List<RentalSummary> summaries = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {

            stmt.setDouble(1, minAmount);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");

                    summaries.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco: " + e.getMessage());
            System.exit(1);
        }

        Path csvFile = Paths.get(csvPath);

        try (BufferedWriter writer = Files.newBufferedWriter(csvFile)) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }

            System.out.println("CSV gerado: " + csvFile.toAbsolutePath());
            System.out.println("Registros: " + summaries.size());

        } catch (IOException e) {
            System.err.println("Erro ao escrever CSV: " + e.getMessage());
            System.exit(1);
        }
    }
}
