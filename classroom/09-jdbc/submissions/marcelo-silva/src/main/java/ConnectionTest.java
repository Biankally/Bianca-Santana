
package com.jdbc09;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        String url = DBConfig.getUrl();

        try (Connection conn = DriverManager.getConnection(
                url, DBConfig.getUser(), DBConfig.getPassword())) {
            
            System.out.println("✅ Conexão bem-sucedida! O banco de dados está acessível.");
            // conn.close() é chamado automaticamente pelo try-with-resources
            
        } catch (SQLException e) {
            System.err.println("❌ ERRO DE CONEXÃO. Verifique o Docker e a senha no db.properties.");
            e.printStackTrace();
        }
    }
}