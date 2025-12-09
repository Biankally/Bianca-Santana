import java.io.BufferedWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {

    private static final String[] REQUIRED_KEYS = {"db.url", "db.user", "db.password", "csv.path"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Uso: java RentalReportApp <valor_minimo_gasto>");
            System.exit(1);
        }

        double minSpent;
        try {
            minSpent = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Valor inválido para valor mínimo: " + args[0]);
            System.exit(1);
            return;
        }

        Path propsPath = Paths.get("db.properties");
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (Exception e) {
            System.err.println("Erro ao ler db.properties em " + propsPath.toAbsolutePath());
            e.printStackTrace();
            System.exit(1);
        }

        for (String k : REQUIRED_KEYS) {
            if (!props.containsKey(k) || props.getProperty(k).trim().isEmpty()) {
                System.err.println("Propriedade obrigatória ausente ou vazia: " + k);
                System.exit(1);
            }
        }

        String url = props.getProperty("db.url").trim();
        String user = props.getProperty("db.user").trim();
        String password = props.getProperty("db.password").trim();
        String csvPath = props.getProperty("csv.path").trim();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC PostgreSQL não encontrado no classpath.");
            e.printStackTrace();
            System.exit(1);
        }

        String sql =
            "SELECT  c.first_name as \"Nome\",\n" +
            "        c.last_name as \"Sobrenome\",\n" +
            "        c.email as \"Email\",\n" +
            "        SUM(p.amount) as \"Valor Gasto\"\n" +
            "FROM rental r\n" +
            "JOIN customer c ON c.customer_id = r.customer_id\n" +
            "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id\n" +
            "GROUP BY c.first_name, c.last_name, c.email\n" +
            "HAVING SUM(p.amount) > ?\n" +
            "ORDER BY SUM(p.amount) desc;";

        List<RentalSummary> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, minSpent);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String first = rs.getString("Nome");
                    String last = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    list.add(new RentalSummary(first, last, email, amount));
                }
            }

        } catch (Exception e) {
            System.err.println("Erro durante operação no banco:");
            e.printStackTrace();
            System.exit(1);
        }

        Path out = Paths.get(csvPath);
        try (BufferedWriter bw = Files.newBufferedWriter(out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write("Nome,Sobrenome,Email,Valor Gasto");
            bw.newLine();
            for (RentalSummary r : list) {
                bw.write(r.toString());
                bw.newLine();
            }
            System.out.println("CSV gravado em: " + out.toAbsolutePath() + " (" + list.size() + " registros)");
        } catch (Exception e) {
            System.err.println("Erro escrevendo CSV:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
