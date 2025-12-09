import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java RentalReportApp <valorMinimoGasto>");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Valor mínimo inválido: " + args[0]);
            return;
        }

        Properties props = new Properties();
        Path propsPath = Paths.get("db.properties");

        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPathStr = props.getProperty("csv.path");

        if (url == null || user == null || password == null || csvPathStr == null
                || url.isBlank() || user.isBlank() || password.isBlank() || csvPathStr.isBlank()) {
            System.err.println("Configuração inválida em db.properties");
            return;
        }

        List<RentalSummary> resultados = new ArrayList<>();

        String sql =
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
                "ORDER BY SUM(p.amount) desc";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, minAmount);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    resultados.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de banco: " + e.getMessage());
            return;
        }

        Path csvPath = Paths.get(csvPathStr);

        try (BufferedWriter writer = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8)) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();
            for (RentalSummary r : resultados) {
                writer.write(r.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever CSV: " + e.getMessage());
        }
    }
}