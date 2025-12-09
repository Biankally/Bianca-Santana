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
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;

public class RentalReportApp {
    private static final String[] REQUIRED_KEYS = {
        "db.url",
        "db.user",
        "db.password",
        "csv.path"
    };

    private static final String QUERY = String.join(
        " ",
        "SELECT c.first_name as \"Nome\",",
        "c.last_name as \"Sobrenome\",",
        "c.email as \"Email\",",
        "SUM(p.amount) as \"Valor Gasto\"",
        "FROM rental r",
        "JOIN customer c ON c.customer_id = r.customer_id",
        "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id",
        "GROUP BY c.first_name, c.last_name, c.email",
        "HAVING SUM(p.amount) > ?",
        "ORDER BY SUM(p.amount) DESC"
    );

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: informe o valor mínimo gasto como argumento.");
            System.exit(1);
        }

        double minimumAmount;
        try {
            minimumAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: o valor mínimo precisa ser numérico.");
            System.exit(1);
            return;
        }

        try {
            Properties properties = loadProperties();
            List<RentalSummary> summaries = fetchSummaries(properties, minimumAmount);
            writeCsv(Paths.get(properties.getProperty("csv.path")), summaries);
            System.out.printf(
                Locale.US,
                "Relatório gerado com %d registros em %s%n",
                summaries.size(),
                properties.getProperty("csv.path")
            );
        } catch (IOException | SQLException ex) {
            System.err.println("Falha ao gerar relatório: " + ex.getMessage());
            System.exit(1);
        }
    }

    private static Properties loadProperties() throws IOException {
        Path propertiesPath = resolvePropertiesPath();
        Properties properties = new Properties();

        try (InputStream input = Files.newInputStream(propertiesPath)) {
            properties.load(input);
        }

        for (String key : REQUIRED_KEYS) {
            if (Objects.isNull(properties.getProperty(key)) || properties.getProperty(key).isBlank()) {
                throw new IOException("Chave obrigatória ausente em db.properties: " + key);
            }
        }

        return properties;
    }

    private static Path resolvePropertiesPath() throws IOException {
        Path rootFile = Paths.get("db.properties");
        if (Files.exists(rootFile)) {
            return rootFile;
        }

        Path nestedFile = Paths.get("db", "db.properties");
        if (Files.exists(nestedFile)) {
            return nestedFile;
        }

        Path srcNestedFile = Paths.get("src", "db", "db.properties");
        if (Files.exists(srcNestedFile)) {
            return srcNestedFile;
        }

        throw new IOException("Arquivo db.properties não encontrado.");
    }

    private static List<RentalSummary> fetchSummaries(Properties properties, double minimumAmount)
        throws SQLException {
        List<RentalSummary> summaries = new ArrayList<>();

        try (
            Connection connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
            );
            PreparedStatement statement = connection.prepareStatement(QUERY)
        ) {
            statement.setDouble(1, minimumAmount);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    summaries.add(
                        new RentalSummary(
                            resultSet.getString("Nome"),
                            resultSet.getString("Sobrenome"),
                            resultSet.getString("Email"),
                            resultSet.getDouble("Valor Gasto")
                        )
                    );
                }
            }
        }

        return summaries;
    }

    private static void writeCsv(Path csvPath, List<RentalSummary> summaries) throws IOException {
        Path parent = csvPath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(csvPath, StandardCharsets.UTF_8)) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();
            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
        }
    }
}

