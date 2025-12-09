import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLog {
    public static void log(String operation, String details) {
        String line = String.format("[%s] %s: %s%n", LocalDateTime.now(), operation, details);
        try {
            Files.write(Paths.get("audit.log"), line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro de Log: " + e.getMessage());
        }
    }
}