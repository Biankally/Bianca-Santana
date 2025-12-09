import java.sql.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;

public class RentalReportApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso correto: java RentalReportApp <valor-minimo>");
            return;
        }

        double minAmount = Double.parseDouble(args[0]);

        Properties props = new Properties();

    
        try (InputStream in = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Erro ao carregar db.properties: " + e.getMessage());
            return;
        }

        // 2. Validar chaves obrigatórias
        for (String key : new String[]{"db.url", "db.user", "db.password", "csv.path"}) {
            if (!props.containsKey(key)) {
                System.err.println("Chave ausente no db.properties: " + key);
                return;
            }
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        ArrayList<RentalSummary> summaries = new ArrayList<>();

        String sql = """
            SELECT  
                c.first_name AS "Nome",
                c.last_name AS "Sobrenome",
                c.email AS "Email",
                SUM(p.amount) AS "Valor Gasto"
            FROM rental r 
            JOIN customer c ON c.customer_id = r.customer_id 
            JOIN payment p ON p.customer_id = c.customer_id 
                AND p.rental_id = r.rental_id
            GROUP BY c.first_name, c.last_name, c.email
            HAVING SUM(p.amount) > ?
            ORDER BY SUM(p.amount) DESC;
        """;

        // 3. Conectar e executar consulta
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, minAmount);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    summaries.add(
                        new RentalSummary(
                            rs.getString("Nome"),
                            rs.getString("Sobrenome"),
                            rs.getString("Email"),
                            rs.getDouble("Valor Gasto")
                        )
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco: " + e.getMessage());
            return;
        }

        // 4. Gerar CSV
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Nome,Sobrenome,Email,Valor Gasto\n");

            for (RentalSummary rs : summaries) {
                writer.write(rs.toString());
                writer.newLine();
            }

            System.out.println("CSV gerado com sucesso em: " + csvPath);

        } catch (IOException e) {
            System.err.println("Erro ao gerar CSV: " + e.getMessage());
        }
    }
}
