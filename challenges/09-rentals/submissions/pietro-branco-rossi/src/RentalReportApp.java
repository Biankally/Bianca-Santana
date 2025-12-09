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
import java.util.Properties;

public class RentalReportApp {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Erro: Informe o valor mínimo de gasto como argumento.");
            System.exit(1);
        }

        double minAmount = 0;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um número válido.");
            System.exit(1);
        }

        Properties props = new Properties();
        Path propertiesPath = Paths.get("db.properties"); 

        try (InputStream in = Files.newInputStream(propertiesPath)) {
            props.load(in);
            
            // Valida chaves para conexão
            if (!props.containsKey("db.url") || !props.containsKey("db.user") || 
                !props.containsKey("db.password") || !props.containsKey("csv.path")) {
                throw new IOException("O arquivo db.properties está incompleto.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        String sql = "SELECT c.first_name as \"Nome\", " +
                     "       c.last_name as \"Sobrenome\", " +
                     "       c.email as \"Email\", " +
                     "       SUM(p.amount) as \"Valor Gasto\" " +
                     "FROM rental r " +
                     "JOIN customer c ON c.customer_id = r.customer_id " +
                     "JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id " +
                     "GROUP BY c.first_name, c.last_name, c.email " +
                     "HAVING SUM(p.amount) > ? " +
                     "ORDER BY SUM(p.amount) DESC";

        ArrayList<RentalSummary> summaries = new ArrayList<>();

        System.out.println("Conectando ao banco e buscando clientes com gastos acima de " + minAmount + "...");

        // conexão
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, minAmount); 

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String fName = rs.getString("Nome");
                    String lName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double val = rs.getDouble("Valor Gasto");

                    summaries.add(new RentalSummary(fName, lName, email, val));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de Banco de Dados: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Foram encontrados " + summaries.size() + " registros.");

        // Gera CSV
        Path pathCsv = Paths.get(csvPath);
        try (BufferedWriter writer = Files.newBufferedWriter(pathCsv)) {
            
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
            System.out.println("Arquivo CSV gerado com sucesso em: " + pathCsv.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }
}