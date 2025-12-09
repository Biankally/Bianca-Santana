import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class RentalReportApp {
    private static final String SQL = """
        SELECT  c.first_name as "Nome",
                c.last_name  as "Sobrenome",
                c.email      as "Email",
                SUM(p.amount) as "Valor Gasto"
        FROM rental r
        JOIN customer c ON c.customer_id = r.customer_id
        JOIN payment  p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id
        GROUP BY c.first_name, c.last_name, c.email
        HAVING SUM(p.amount) > ?
        ORDER BY SUM(p.amount) DESC
        """;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java RentalReportApp <valorMinimoGasto>");
            System.exit(1);
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0].replace(',', '.'));
        } catch (NumberFormatException e) {
            System.err.println("Erro: valor mínimo inválido: " + args[0]);
            System.exit(2);
            return;
        }

        Properties props = new Properties();
        Path propsPath = Paths.get("db.properties");
        if (!Files.exists(propsPath)) {
            System.err.println("Erro: arquivo db.properties não encontrado em " + propsPath.toAbsolutePath());
            System.exit(3);
        }
        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Erro lendo db.properties: " + e.getMessage());
            System.exit(4);
        }

        String url  = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        String csvPathStr = props.getProperty("csv.path", "rentals.csv");

        if (isBlank(url) || isBlank(user) || isBlank(pass) || isBlank(csvPathStr)) {
            System.err.println("Erro: db.properties deve conter db.url, db.user, db.password e csv.path.");
            System.exit(5);
        }

        List<RentalSummary> summaries = new ArrayList<>();

        try {
            try { Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException ignore) {}

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement ps = conn.prepareStatement(SQL)) {

                ps.setDouble(1, minAmount);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String first = rs.getString("Nome");
                        String last  = rs.getString("Sobrenome");
                        String email = rs.getString("Email");
                        double amt   = rs.getDouble("Valor Gasto");

                        summaries.add(new RentalSummary(first, last, email, amt));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de banco: " + e.getMessage());
            System.exit(6);
        }

        Path csvPath = Paths.get(csvPathStr);
        try {
            if (csvPath.getParent() != null) Files.createDirectories(csvPath.getParent());
            try (BufferedWriter w = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                w.write("Nome,Sobrenome,Email,Valor Gasto");
                w.newLine();
                for (RentalSummary s : summaries) {
                    w.write(s.toString());
                    w.newLine();
                }
            }
            System.out.println("Relatório gerado: " + csvPath.toAbsolutePath());
            System.out.printf(Locale.US, "Total de linhas: %d (filtro > %.2f)%n", summaries.size(), minAmount);
        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
            System.exit(7);
        }
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
