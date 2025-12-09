import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {
    private static final String QUERY = """
            SELECT  c.first_name as "Nome",
                    c.last_name as "Sobrenome",
                    c.email as "Email",
                    SUM(p.amount) as "Valor Gasto"
            FROM 
                rental r JOIN 
                customer c ON c.customer_id = r.customer_id JOIN
                payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id
            GROUP BY c.first_name, c.last_name, c.email
            HAVING SUM(p.amount) > ?
            ORDER BY SUM(p.amount) desc;
            """;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java -cp bin RentalReportApp <valorMinimoGasto>");
            return;
        }

        double minimoGasto;
        try {
            minimoGasto = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Valor mínimo inválido: " + args[0]);
            return;
        }

        Properties props = new Properties();
        Path propertiesPath = Path.of("db.properties");
        if (!Files.exists(propertiesPath)) {
            System.err.println("Arquivo db.properties não encontrado no diretório atual.");
            return;
        }

        try (InputStream input = Files.newInputStream(propertiesPath)) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        if (url == null || user == null || password == null || csvPath == null) {
            System.err.println("Verifique se db.url, db.user, db.password e csv.path estão definidos em db.properties.");
            return;
        }

        List<RentalSummary> summaries = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(QUERY)) {

            statement.setDouble(1, minimoGasto);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    summaries.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao executar consulta no banco: " + e.getMessage());
            return;
        }

        Path csvFile = Path.of(csvPath);
        try (var writer = Files.newBufferedWriter(csvFile)) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();
            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
            System.out.println("Relatório gerado em: " + csvFile.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }

}
