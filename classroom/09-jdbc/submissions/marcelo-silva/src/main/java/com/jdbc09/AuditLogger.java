package com.jdbc09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final Path LOG_FILE = Paths.get("audit.log");

    public static void log(String action, String details) {
        String logEntry = String.format("[%s] - Ação: %s - Detalhes: %s%n",
                                        LocalDateTime.now(), action, details);
        try {
            // Cria o arquivo se não existir e adiciona a linha no final (APPEND)
            Files.write(LOG_FILE, logEntry.getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}