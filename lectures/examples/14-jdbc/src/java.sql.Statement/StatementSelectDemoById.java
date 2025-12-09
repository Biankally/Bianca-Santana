import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class StatementSelectDemoById {

    private static String DATABASE_URL;
    private static String USER;
    private static String PASSWORD;

    private static String SQL_SELECT = """
                                            SELECT  actor_id,
                                                    first_name,
                                                    last_name
                                            FROM    actor
                                            WHERE   actor_id = %s;
                                        """;

    public static void main(String[] args) {

        loadDatabaseProperties();

        buildSQLCommand();
        try (
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT)
        ) {

            while (resultSet.next()) {
                System.out.printf("ID: %-3d | Nome: %-20s | Sobrenome: %s%n",
                        resultSet.getInt("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
            }

        } catch (SQLException sqlex) {
            System.out.printf("Erro: %s%n", sqlex);
        }
    }

    private static void buildSQLCommand() {

        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Selecionar por ID");

            System.out.print("- ID do Ator: ");
            int actor_id = input.nextInt();
           
            SQL_SELECT = SQL_SELECT.formatted(actor_id);

        } catch (Exception ex) {
            System.out.printf("Erro 1: %s%n", ex);
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
