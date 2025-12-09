import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final Path LOG_PATH = Paths.get("audit.log");

    public static void log(String message) {
        String logEntry = LocalDateTime.now() + " - " + message + System.lineSeparator();
        try {
            Files.write(LOG_PATH, logEntry.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
