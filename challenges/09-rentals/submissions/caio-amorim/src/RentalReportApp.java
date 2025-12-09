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

    private static final String[] REQUIRED_PROPS = {"db.url", "db.user", "db.password", "csv.path"};
    private static final String QUERY =
        "SELECT  c.first_name as \"Nome\",\n" +
        "        c.last_name as \"Sobrenome\",\n" +
        "        c.email as \"Email\",\n" +
        "        SUM(p.amount) as \"Valor Gasto\"\n" +
        "FROM \n" +
        "    rental r JOIN \n" +
        "    customer c ON c.customer_id = r.customer_id JOIN\n" +
        "    payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id\n" +
        "GROUP BY c.first_name, c.last_name, c.email\n" +
        "HAVING SUM(p.amount) > ?\n" +
        "ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        // 1) Validar argumento de linha de comando
        if (args.length < 1) {
            System.err.println("Uso: java RentalReportApp <valor_minimo_gasto>");
            System.exit(1);
        }

        double minSpent;
        try {
            minSpent = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argumento invalido. Passe um número para o valor mínimo gasto (ex: 200)");
            System.exit(1);
            return;
        }

        // 2) Carregar propriedades do arquivo db.properties (na raiz da submissão)
        Properties props = new Properties();
        Path propsPath = Paths.get("db.properties");
        if (!Files.exists(propsPath)) {
            System.err.println("Arquivo db.properties não encontrado em: " + propsPath.toAbsolutePath());
            System.exit(1);
        }

        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        // 3) Validar chaves obrigatórias
        for (String key : REQUIRED_PROPS) {
            if (!props.containsKey(key) || props.getProperty(key).trim().isEmpty()) {
                System.err.println("Propriedade obrigatória ausente ou vazia: " + key);
                System.exit(1);
            }
        }

        String dbUrl = props.getProperty("db.url").trim();
        String dbUser = props.getProperty("db.user").trim();
        String dbPassword = props.getProperty("db.password").trim();
        String csvPath = props.getProperty("csv.path").trim();

        // 4) Conectar, executar consulta e popular lista
        List<RentalSummary> summaries = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(QUERY)) {

            ps.setDouble(1, minSpent);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    RentalSummary r = new RentalSummary(firstName, lastName, email, amount);
                    summaries.add(r);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro SQL/Conexão: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        // 5) Escrever CSV
        Path outCsv = Paths.get(csvPath);
        try {
            // Cria diretório pai se necessário
            if (outCsv.getParent() != null && !Files.exists(outCsv.getParent())) {
                Files.createDirectories(outCsv.getParent());
            }

            try (BufferedWriter writer = Files.newBufferedWriter(outCsv)) {
                // Cabeçalho
                writer.write("Nome,Sobrenome,Email,Valor Gasto");
                writer.newLine();

                // Linhas
                for (RentalSummary rs : summaries) {
                    writer.write(rs.toString());
                    writer.newLine();
                }
            }

            System.out.println("CSV gerado com sucesso em: " + outCsv.toAbsolutePath());
            System.out.println("Total de registros: " + summaries.size());
        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
