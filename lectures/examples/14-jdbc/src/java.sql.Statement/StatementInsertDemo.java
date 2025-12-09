import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class StatementInsertDemo {

    private static String DATABASE_URL;
    private static String USER;
    private static String PASSWORD;

    private static String SQL_INSERT = """
            INSERT INTO actor (
                first_name,
                last_name,
                last_update
            )
            VALUES (
                '%s',
                '%s',
                NOW()
            );
            """;
    public static void main(String[] args) {

        loadDatabaseProperties();
        buildSQLCommand();

        try (
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement()
        ) {

            int rowsAffected = statement.executeUpdate(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            System.out.printf("Linhas inseridas: %d%n", rowsAffected);

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    System.out.printf("ID gerado: %d%n", id);
                }
            }

        } catch (SQLException sqlex) {
            System.out.printf("Erro: %s%n", sqlex);
        }
    }

    private static void buildSQLCommand() {

        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Inserção de dados");

            System.out.print("- Primeiro Nome: ");
            String firstName = input.nextLine().trim();

            System.out.print("- Último Nome: ");
            String lastName = input.nextLine().trim();

            SQL_INSERT = SQL_INSERT.formatted(firstName, lastName);

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
