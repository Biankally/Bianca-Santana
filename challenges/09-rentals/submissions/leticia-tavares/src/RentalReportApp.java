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

    private static final String PROPERTIES_FILE = "db.properties";
    private static final String CSV_HEADER = "Nome,Sobrenome,Email,Valor Gasto";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: O valor mínimo gasto é obrigatório como argumento (ex: java RentalReportApp 100).");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um valor numérico válido.");
            return;
        }

        Properties props = loadProperties();
        if (props == null) return;
        
        List<RentalSummary> rentals = executeQuery(props, minAmount);

        if (rentals != null) {
            saveToCsv(rentals, props.getProperty("csv.path"));
        }
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        Path propPath = Paths.get(PROPERTIES_FILE);
        
        try (InputStream input = Files.newInputStream(propPath)) {
            props.load(input);

            if (!props.containsKey("db.url") || !props.containsKey("db.user") || !props.containsKey("db.password") || !props.containsKey("csv.path")) {
                System.err.println("Erro: O arquivo db.properties está incompleto. Verifique as chaves db.url, db.user, db.password e csv.path.");
                return null;
            }
            return props;
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo db.properties. Certifique-se de que ele está na pasta raiz da submissão.");
            e.printStackTrace();
            return null;
        }
    }

    private static List<RentalSummary> executeQuery(Properties props, double minAmount) {
        List<RentalSummary> rentals = new ArrayList<>();
        String sql = """
            SELECT c.first_name as "Nome",
                   c.last_name as "Sobrenome",
                   c.email as "Email",
                   SUM(p.amount) as "Valor Gasto"
            FROM rental r JOIN customer c ON c.customer_id = r.customer_id
                          JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id
            GROUP BY c.first_name, c.last_name, c.email
            HAVING SUM(p.amount) > ?
            ORDER BY SUM(p.amount) DESC;
            """;

        try (Connection conn = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, minAmount);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");

                    RentalSummary summary = new RentalSummary(firstName, lastName, email, amount);
                    rentals.add(summary);
                }
                System.out.println("✅ Consulta executada com sucesso. Encontrados " + rentals.size() + " registros.");
            }

        } catch (SQLException e) {
            System.err.println("Erro de conexão ou execução da consulta SQL.");
            e.printStackTrace();
            return null;
        }
        return rentals;
    }

    private static void saveToCsv(List<RentalSummary> rentals, String csvPath) {
        Path path = Paths.get(csvPath);
        
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(CSV_HEADER);
            writer.newLine();

            for (RentalSummary rental : rentals) {
                writer.write(rental.toString());
                writer.newLine();
            }
            System.out.println("✅ Relatório salvo com sucesso em: " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV.");
            e.printStackTrace();
        }
    }
}