import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RentalReportApp {
    private static final String SQL_QUERY = "SELECT c.first_name as \"Nome\", c.last_name as \"Sobrenome\", c.email as \"Email\", SUM(p.amount) as \"Valor Gasto\" FROM rental r JOIN customer c ON c.customer_id = r.customer_id JOIN payment p ON p.customer_id = c.customer_id and p.rental_id = r.rental_id GROUP BY c.first_name, c.last_name, c.email HAVING SUM(p.amount) > ? ORDER BY SUM(p.amount) desc;";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java -cp ... RentalReportApp <valor_minimo>");
            return;
        }

        double minAmount;
        try {
            minAmount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("O valor mínimo deve ser um número válido.");
            return;
        }

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            
            try (FileInputStream fis = new FileInputStream("../db.properties")) {
                 props.load(fis);
            } catch (IOException ex) {
                System.err.println("Não foi possível encontrar db.properties.");
                return;
            }
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path", "rentals.csv");

        List<RentalSummary> summaries = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(SQL_QUERY)) {

            System.out.println("Conectado ao banco de dados.");
            stmt.setDouble(1, minAmount);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("Nome");
                    String lastName = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");
                    summaries.add(new RentalSummary(firstName, lastName, email, amount));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvPath))) {
            for (RentalSummary summary : summaries) {
                writer.println(summary);
            }
            System.out.println("Relatório gerado com sucesso em: " + csvPath);
            System.out.println("Total de registros: " + summaries.size());
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo CSV: " + e.getMessage());
        }
    }
}
