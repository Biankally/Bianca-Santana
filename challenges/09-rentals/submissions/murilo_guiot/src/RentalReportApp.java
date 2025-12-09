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

    private static final String DB_PROPERTIES_PATH = "db.properties";
    private static final String SQL_QUERY = """
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
            System.err.println("Erro");
            System.exit(1);
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("O argumento tem que ser um valor numerico correto");
            System.exit(1);
            return;
        }

        Properties dbProps = loadProperties(DB_PROPERTIES_PATH);
        if (dbProps == null) {
            System.exit(1);
            return;
        }

        List<RentalSummary> summaries = fetchRentalSummaries(dbProps, minAmount);
        if (summaries != null) {
            writeCsvReport(dbProps, summaries);
        }
    }

    private static Properties loadProperties(String path) {
        Properties props = new Properties();
        Path propPath = Paths.get(path);
        String[] requiredKeys = {"db.url", "db.user", "db.password", "csv.path"};

        try (InputStream input = Files.newInputStream(propPath)) {
            props.load(input);
            
            for (String key : requiredKeys) {
                if (!props.containsKey(key)) {
                    System.err.println("Erro por conta do path: " + path);
                    return null;
                }
            }
            
            System.out.println("Configuracoes carregadas com sucesso de " + path);
            return props;
        } catch (IOException ex) {
            System.err.println("Erro ao carregar o arquivo de propriedades " + path + ": " + ex.getMessage());
            return null;
        }
    }

    private static List<RentalSummary> fetchRentalSummaries(Properties props, double minAmount) {
        List<RentalSummary> summaries = new ArrayList<>();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        System.out.println("Conectando ao banco de dados...");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {

            stmt.setDouble(1, minAmount);
            
            System.out.println("Executando consulta SQL com valor minimo de " + minAmount + " reais");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    
                    RentalSummary summary = new RentalSummary(firstName, lastName, email, amount);
                    summaries.add(summary);
                }
            }
            
            System.out.println("Consulta concluida. " + summaries.size() + " registros encontrados.");

        } catch (SQLException ex) {
            System.err.println("Erro de banco de dados: " + ex.getMessage());
            return null;
        }
        return summaries;
    }

    private static void writeCsvReport(Properties props, List<RentalSummary> summaries) {
        String csvPath = props.getProperty("csv.path");
        Path outputPath = Paths.get(csvPath);
        String header = "Nome,Sobrenome,Email,Valor Gasto";

        System.out.println("Gerando relatorio CSV em " + csvPath + "...");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write(header);
            writer.newLine();
            
            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
            
            System.out.println("Relatorio CSV gerado com sucesso.");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever o arquivo CSV: " + ex.getMessage());
        }
    }
}
