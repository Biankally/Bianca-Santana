import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {

    private static final String QUERY =
        "SELECT c.first_name as \"Nome\", " +
        "       c.last_name  as \"Sobrenome\", " +
        "       c.email      as \"Email\", " +
        "       SUM(p.amount) as \"Valor Gasto\" " +
        "FROM rental r " +
        "JOIN customer c ON c.customer_id = r.customer_id " +
        "JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id " +
        "GROUP BY c.first_name, c.last_name, c.email " +
        "HAVING SUM(p.amount) > ? " +
        "ORDER BY SUM(p.amount) DESC;";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java -cp \"bin:lib/postgresql-42.7.8.jar\" RentalReportApp <valor_minimo>\nEx.: java -cp \"bin:lib/postgresql-42.7.8.jar\" RentalReportApp 200");
            System.exit(1);
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("O argumento <valor_minimo> deve ser numérico. Ex.: 150 ou 200.50");
            System.exit(1);
            return;
        }

        Properties props = new Properties();
        Path propsPath = Path.of("db.properties");
        if (!Files.exists(propsPath)) {
            System.err.println("Arquivo db.properties não encontrado na raiz da submissão.");
            System.exit(1);
        }

        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            System.exit(1);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        if (url == null || user == null || password == null || csvPath == null) {
            System.err.println("db.properties deve conter: db.url, db.user, db.password, csv.path");
            System.exit(1);
        }

        List<RentalSummary> summaries = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setDouble(1, minAmount);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName  = rs.getString("Sobrenome");
                    String email     = rs.getString("Email");
                    double amount    = rs.getDouble("Valor Gasto");

                    summaries.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao executar consulta: " + e.getMessage());
            System.exit(1);
        }

        Path out = Path.of(csvPath);
        try (BufferedWriter bw = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write("Nome,Sobrenome,Email,Valor Gasto");
            bw.newLine();
            for (RentalSummary s : summaries) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("CSV gerado em: " + out.toAbsolutePath());
        System.out.println("Registros: " + summaries.size());
    }
}
