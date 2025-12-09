import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {
    private static final Logger LOGGER = System.getLogger(AuditLogger.class.getName());

    private static final Path LOG_PATH = Paths.get("audit.log");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String operation, String details) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = String.format("[%s] OP: %s | DETALHES: %s%n", timestamp, operation, details);

        try {
            Files.writeString(
                    LOG_PATH,
                    logEntry,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Falha crítica ao escrever no log de auditoria de negócios.", e);
        }
    }
}