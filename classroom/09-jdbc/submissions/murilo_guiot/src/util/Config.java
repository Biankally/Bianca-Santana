package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException; 
import java.time.LocalDateTime; 

public class Config {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/dvdrental";
        String user = "postgres";
        String password = "325100"; 

        return DriverManager.getConnection(url, user, password);
    }

    public static void logAudit(String operacao, String detalhes) {
        String logMessage = String.format("[%s] - %s: %s%n", 
                LocalDateTime.now().toString(),
                operacao,
                detalhes
        );

        try {
            Path logFile = Paths.get("audit.log");

            Files.writeString(logFile, logMessage,
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Falha ao escrever no 'audit.log': " + e.getMessage());
        }
    }
}