import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementSelectDemo {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)){
            System.out.print("Informe o nome do ator: ");
            String nome = input.nextLine();

            try {
                Properties props = new Properties();
                props.load(Files.newInputStream(Paths.get("db.properties")));

                String url = props.getProperty("url"); //"jdbc:postgresql://localhost:5432/postgres";
                String usuario = props.getProperty("user"); // "postgres";
                String senha = props.getProperty("password"); // *****;

                String sql = "SELECT first_name, last_name FROM actor WHERE first_name = ?";

            try (Connection conn = DriverManager.getConnection(url, usuario, senha);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("First: " + rs.getString("first_name") + ", Last Name: " + rs.getString("last_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo de configuração: " + e.getMessage());
            }
        }
    }
}
