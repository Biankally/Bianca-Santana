import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class StatementDeleteDemo {

    private static String DATABASE_URL;
    private static String USER;
    private static String PASSWORD;

    private static String SQL_DELETE = """
            DELETE FROM actor
            WHERE actor_id = %s;
            """;

    public static void main(String[] args) {

        loadDatabaseProperties();
        buildSQLCommand();

        try (
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement()
        ) {

            int rowsAffected = statement.executeUpdate(SQL_DELETE);

            System.out.printf("Linhas removidas: %d%n", rowsAffected);

        } catch (SQLException sqlex) {
            System.out.printf("Erro: %s%n", sqlex);
        }
    }

    private static void buildSQLCommand() {

        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Remoção de dados");

            System.out.print("- ID do Ator: ");
            int actor_id = input.nextInt();
           
            SQL_DELETE = SQL_DELETE.formatted(actor_id);

        } catch (Exception ex) {
            System.out.printf("Erro: %s%n", ex);
        }
    }

    private static void loadDatabaseProperties() {

        try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {

            Properties props = new Properties();

            props.load(inputStream);

            DATABASE_URL = props.getProperty("url");
            USER = props.getProperty("user");
            PASSWORD = props.getProperty("password");
        } catch (Exception ex) {
            System.out.printf("Erro: %s%n", ex);
        }
    }
}
