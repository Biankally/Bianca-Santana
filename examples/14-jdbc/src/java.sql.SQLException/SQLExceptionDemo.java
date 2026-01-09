import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExceptionDemo {

    public static void main(String[] args){
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "erro", "erro")) {
            System.out.println("Conexão estabelecida com sucesso!");
            System.out.println(conexao.getClientInfo());
            System.out.println(conexao.getSchema());
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
            System.err.println("Código: " + e.getErrorCode());
            System.err.println("Estado: " + e.getSQLState());
        }

    
    }

}
