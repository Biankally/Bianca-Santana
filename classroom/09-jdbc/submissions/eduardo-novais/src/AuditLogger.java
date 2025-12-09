import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {
    
    private static final String LOG_FILE = "src/audit.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void log(String operation, String details) {
        try {
            Path logPath = Paths.get(LOG_FILE);
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String logEntry = String.format("[%s] %s: %s%n", timestamp, operation, details);
            
            Files.write(logPath, logEntry.getBytes(), 
                       StandardOpenOption.CREATE, 
                       StandardOpenOption.APPEND, 
                       StandardOpenOption.WRITE);
        } catch (java.io.IOException e) {
            System.err.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}

