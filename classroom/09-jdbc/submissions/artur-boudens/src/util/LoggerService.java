package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LoggerService {
    private static final String LOG_FILE = "audit.log";

    public static void log(String operation, String details) {
        String logEntry = String.format("[%s] OPERACAO: %s | DETALHES: %s%n",
                LocalDateTime.now(), operation, details);

        try {
            Files.write(
                Paths.get(LOG_FILE), 
                logEntry.getBytes(), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}