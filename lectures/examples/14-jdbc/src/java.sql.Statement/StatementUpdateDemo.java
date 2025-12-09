import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class StatementUpdateDemo {

    private static String DATABASE_URL;
    private static String USER;
    private static String PASSWORD;

    private static String SQL_UPDATE = """  
                                        UPDATE actor 
                                        SET first_name = '%s', 
                                            last_name = '%s', 
                                            last_update = NOW() 
                                        WHERE actor_id = %s;
                                    """;

    public static void main(String[] args) {

            loadDatabaseProperties();

            buildSQLCommand();

            try (
                Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
            ) {

                int rowsAffected = statement.executeUpdate(SQL_UPDATE);

                System.out.printf("Linhas atualizadas: %d%n", rowsAffected);

            } catch (SQLException sqlex) {
                System.out.printf("Erro: %s%n", sqlex);
            }
    }

    private static void loadDatabaseProperties() {
      
        try(var inputStream = Files.newInputStream(Paths.get("db.properties"))){

            Properties props = new Properties();

            props.load(inputStream);

            DATABASE_URL = props.getProperty("url");
            USER = props.getProperty("user");
            PASSWORD = props.getProperty("password");
        } catch (IOException ex){
            System.out.printf("Erro %s%n", ex);
        }
    }

    private static void buildSQLCommand(){

        try (Scanner input = new Scanner(System.in)){
                System.out.println("Atualização de dados");

                System.out.print("- ID do Ator: ");
                int actorID = input.nextInt();

                System.out.print("- Primeiro Nome: ");
                String frist_Name = input.next();

                System.out.print("- Último Nome: ");
                String last_Name = input.next();

                SQL_UPDATE = SQL_UPDATE.formatted(frist_Name, last_Name, actorID);
    
        } catch (Exception ex) {
            System.out.printf("Erro: %s%n", ex);
        }
    }
}
