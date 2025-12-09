package com.dvdrental.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {

    private static final String LOG_FILE = "audit.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String operation) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("[%s] %s%n", timestamp, operation);

        try {
            Files.write(
                Paths.get(LOG_FILE), 
                logMessage.getBytes(), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Erro ao escrever no log de auditoria: " + e.getMessage());
        }
    }
}
