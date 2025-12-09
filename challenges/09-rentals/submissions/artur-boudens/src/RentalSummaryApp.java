import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalSummaryApp {
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Erro: Forneça um valor válido para a quantia gasta.");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erro: O argumento fornecido não é válido.");
            return;
        }

        List<RentalSummary> summaries = new ArrayList<>();
        Properties props = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
            
            if (!props.containsKey("db.url") || !props.containsKey("db.user") || 
                !props.containsKey("db.password") || !props.containsKey("csv.path")) {
                throw new RuntimeException("Erro: O arquivo db.properties está incompleto.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo db.properties: " + e.getMessage());
            return;
        }

        String sql = """
                SELECT c.first_name as "Nome",
                       c.last_name as "Sobrenome",
                       c.email as "Email",
                       SUM(p.amount) as "Valor Gasto"
                FROM rental r 
                JOIN customer c ON c.customer_id = r.customer_id 
                JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id
                GROUP BY c.first_name, c.last_name, c.email
                HAVING SUM(p.amount) > ?
                ORDER BY SUM(p.amount) DESC;
                """;

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password"));
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, minAmount);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");

                    summaries.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }
            
            System.out.println("Registros encontrados: " + summaries.size());

        } catch (SQLException e) {
            System.err.println("Erro de Banco de Dados: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        String csvPath = props.getProperty("csv.path");
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary summary : summaries) {
                writer.write(summary.toString());
                writer.newLine();
            }
            
            System.out.println("Relatório gerado em: " + csvPath);

        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}


