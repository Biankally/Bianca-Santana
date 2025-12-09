import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("db.properties"));

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso ao PostgreSQL!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
