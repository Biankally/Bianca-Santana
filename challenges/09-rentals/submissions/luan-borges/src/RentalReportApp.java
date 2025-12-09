import java.io.BufferedWriter;
import java.nio.file.Files;
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

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: Informe o valor mínimo gasto como argumento.");
            return;
        }

        double valorMinimo;
        try {
            valorMinimo = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento deve ser um número válido.");
            return;
        }

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Paths.get("db.properties")));
            
            if (!props.containsKey("db.url") || !props.containsKey("db.user") || 
                !props.containsKey("db.password") || !props.containsKey("csv.path")) {
                throw new RuntimeException("Arquivo db.properties incompleto.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        List<RentalSummary> relatorio = new ArrayList<>();

        String sql = "SELECT c.first_name as \"Nome\", " +
                     "       c.last_name as \"Sobrenome\", " +
                     "       c.email as \"Email\", " +
                     "       SUM(p.amount) as \"Valor Gasto\" " +
                     "FROM rental r " +
                     "JOIN customer c ON c.customer_id = r.customer_id " +
                     "JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id " +
                     "GROUP BY c.first_name, c.last_name, c.email " +
                     "HAVING SUM(p.amount) > ? " +
                     "ORDER BY SUM(p.amount) desc;";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, valorMinimo);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("Nome");
                    String sobrenome = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double valor = rs.getDouble("Valor Gasto");

                    relatorio.add(new RentalSummary(nome, sobrenome, email, valor));
                }
            }
            System.out.println("Registros encontrados: " + relatorio.size());

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath), 
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary item : relatorio) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Arquivo CSV gerado com sucesso em: " + csvPath);

        } catch (Exception e) {
            System.err.println("Erro ao gravar CSV: " + e.getMessage());
        }
    }
}
