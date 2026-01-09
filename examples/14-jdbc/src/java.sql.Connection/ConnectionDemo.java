import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) {

        try{
            Properties props = new Properties();
            
            try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {
                props.load(inputStream);
            }

            String url = props.getProperty("url"); //"jdbc:postgresql://localhost:5432/postgres";
            String usuario = props.getProperty("user"); // "postgres";
            String senha = props.getProperty("password"); // *****;

            connectToDatabase(url, usuario, senha);

        } catch(IOException ioex){
            System.err.println("Erro ao ler arquivo de configuração: " + ioex.getMessage());
        }
    }
    private static void connectToDatabase(String url, String usuario, String senha) {
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            
            System.out.println("Conexão estabelecida com sucesso!");
                                    
            System.out.printf("- Servidor: %s%n", conexao.getMetaData().getURL());
            System.out.printf("- Usuário: %s%n", conexao.getMetaData().getUserName());
            System.out.printf("- Banco de dados: %s%n", conexao.getCatalog());            
            System.out.printf("- Schema: %s%n", conexao.getSchema());
            System.out.printf("- Driver: %s%n", conexao.getMetaData().getDriverName());
            System.out.printf("- Versão do driver: %s%n", conexao.getMetaData().getDriverVersion());
            System.out.printf("- Banco: %s%n", conexao.getMetaData().getDatabaseProductName());
            System.out.printf("- Versão: %s%n", conexao.getMetaData().getDatabaseProductVersion());
            
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }
}