import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class RentalReportApp {

    private static final String QUERY = 

        "SELECT c.first_name AS \"Nome\", " +
            "       c.last_name AS \"Sobrenome\", " +
            "       c.email AS \"Email\", " +
            "       SUM(p.amount) AS \"Valor Gasto\" " +
            "FROM rental r " +
            "JOIN customer c ON c.customer_id = r.customer_id " +
            "JOIN payment p ON p.customer_id = c.customer_id AND p.rental_id = r.rental_id " +
            "GROUP BY c.first_name, c.last_name, c.email " +
            "HAVING SUM(p.amount) > ? " +
            "ORDER BY SUM(p.amount) DESC";

    public static void main(String[] args) {

        //1. Validar argumento minimo 
        if (args.length == 0) {
            System.err.println("Uso: java RentalReportApp <valor-minimo>");
            System.exit(1);
        }
        double minValue = Double.parseDouble(args[0]);

//-----------------------------------------------------------------------------
        // 2. Carregar properties
        Properties props = new Properties();
        try (InputStream is = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(is);
        } catch (IOException e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

//-----------------------------------------------------------------------------

        // 3. Validar chaves obrigatórias
        if (url == null || user == null || password == null || csvPath == null) {
            System.err.println("db.properties está incompleto.");
            return;
        }

//-----------------------------------------------------------------------------

        // 4. Lista para armazenar resultados
        List<RentalSummary> summaries = new ArrayList<>();

//-----------------------------------------------------------------------------

        // 5. Conexão JDBC
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(QUERY)) {

            stmt.setDouble(1, minValue);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String fn = rs.getString("Nome");
                    String ln = rs.getString("Sobrenome");
                    String email = rs.getString("Email");
                    double amount = rs.getDouble("Valor Gasto");

                    summaries.add(new RentalSummary(fn, ln, email, amount));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro na consulta: " + e.getMessage());
            return;
        }

//-----------------------------------------------------------------------------

        // 6. Gerar CSV
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto");
            writer.newLine();

            for (RentalSummary s : summaries) {
                writer.write(s.toString());
                writer.newLine();
            }

            System.out.println("CSV gerado com sucesso: " + csvPath);

        } catch (IOException e) {
            System.err.println("Erro ao gerar CSV: " + e.getMessage());
        }

        
    }
}