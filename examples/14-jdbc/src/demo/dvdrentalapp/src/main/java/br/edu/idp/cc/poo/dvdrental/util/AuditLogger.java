package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final Path LOG_PATH = Paths.get("audit.log");

    public static void log(String action, String details) {
        String logEntry = String.format("[%s] %s - %s%n", LocalDateTime.now(), action, details);
        try {
            Files.writeString(LOG_PATH, logEntry, StandardCharsets.UTF_8,
                              StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo de log: " + e.getMessage());
        }
    }
}
