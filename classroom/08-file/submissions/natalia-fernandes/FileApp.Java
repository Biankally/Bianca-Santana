import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.BasicFileAttributes;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitResult.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitResult.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitResult.*;
import java.nio.file.FileVisitResult;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        // Diretórios e arquivos base
        Path dataDir = Paths.get("data");
        Path backupDir = Paths.get("backup");
        Path clientsFile = dataDir.resolve("clients.txt");
        Path clientsNewFile = dataDir.resolve("clients_new.txt");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

        // 1) List Files in Directory
        System.out.println("=== List Files in Directory (data) ===");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {
            boolean any = false;
            for (Path p : stream) {
                System.out.println(p.getFileName().toString());
                any = true;
            }
            if (!any) System.out.println("(vazio)");
        } catch (IOException e) {
            System.out.println("Falha ao listar 'data': " + e.getMessage());
        }

        // 2) Check Path Exists
        System.out.println("\n=== Check Path Exists (clients.txt) ===");
        boolean exists = Files.exists(clientsFile);
        System.out.println(exists);

        // 3) Read File Line by Line (somente se existir)
        System.out.println("\n=== Read File Line by Line (clients.txt) ===");
        if (exists) {
            try (BufferedReader r = Files.newBufferedReader(clientsFile, StandardCharsets.UTF_8)) {
                String line;
                int n = 1;
                while ((line = r.readLine()) != null) {
                    System.out.printf("%d: %s%n", n++, line);
                }
                if (n == 1) System.out.println("(arquivo vazio)");
            } catch (IOException e) {
                System.out.println("Erro lendo clients.txt: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não existe. Operação de leitura ignorada.");
        }

        // 4) Append Text to File (leitura do usuário, mostra apenas as linhas adicionadas)
        System.out.println("\n=== Append Text to File (clients.txt) ===");
        if (exists) {
            System.out.println("Digite as linhas para acrescentar (linha vazia para terminar):");
            List<String> novasLinhas = new ArrayList<>();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
                while (true) {
                    String s = in.readLine();
                    if (s == null || s.isEmpty()) break; // fim com linha vazia ou EOF
                    novasLinhas.add(s);
                }
                if (novasLinhas.isEmpty()) {
                    System.out.println("(nenhuma linha adicionada)");
                } else {
                    Files.write(clientsFile, novasLinhas, StandardCharsets.UTF_8,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Linhas adicionadas:");
                    for (String s : novasLinhas) {
                        System.out.println(s);
                    }
                }
            } catch (IOException e) {
                System.out.println("Falha ao acrescentar linhas: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não existe. Operação de append ignorada.");
        }

        // 5) Write Text File (clients_new.txt), confirmar e ler
        System.out.println("\n=== Write Text File (clients_new.txt) ===");
        try {
            List<String> linhas = new ArrayList<>();
            linhas.add(String.format("%-6s %-20s %-15s", "ID", "NOME", "CIDADE"));
            linhas.add(String.format("%-6s %-20s %-15s", "1", "Alice Martins", "Brasília"));
            linhas.add(String.format("%-6s %-20s %-15s", "2", "Bruno Costa", "São Paulo"));
            linhas.add(String.format("%-6s %-20s %-15s", "3", "Carla Nunes", "Rio de Janeiro"));

            Files.write(clientsNewFile, linhas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            boolean ok = Files.exists(clientsNewFile);
            long size = ok ? Files.size(clientsNewFile) : -1L;
            System.out.println("Gravação " + (ok ? "OK" : "FALHOU") + " (tamanho: " + size + " bytes)");

            if (ok) {
                System.out.println("Conteúdo de clients_new.txt:");
                try (BufferedReader r = Files.newBufferedReader(clientsNewFile, StandardCharsets.UTF_8)) {
                    String line;
                    while ((line = r.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever/ler clients_new.txt: " + e.getMessage());
        }

        // 6) Copy File (clients.txt -> backup/clients_backup.txt) com REPLACE_EXISTING
        System.out.println("\n=== Copy File (clients.txt -> backup/clients_backup.txt) ===");
        try {
            Files.createDirectories(backupDir);
            if (exists) {
                Path backupFile = backupDir.resolve("clients_backup.txt");
                Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Cópia concluída: " + backupFile);
            } else {
                System.out.println("clients.txt não existe. Cópia ignorada.");
            }
        } catch (IOException e) {
            System.out.println("Falha na cópia: " + e.getMessage());
        }

        // 7) Delete (backup/old-clients.txt) com relatório de ausência vs permissão
        System.out.println("\n=== Delete (backup/old-clients.txt) ===");
        Path oldClients = backupDir.resolve("old-clients.txt");
        try {
            Files.delete(oldClients);
            System.out.println("Removido: " + oldClients);
        } catch (NoSuchFileException e) {
            System.out.println("Arquivo não encontrado: " + oldClients);
        } catch (AccessDeniedException e) {
            System.out.println("Sem permissão para remover: " + oldClients);
        } catch (IOException e) {
            System.out.println("Falha ao remover " + oldClients + ": " + e.getMessage());
        }

        // 8) Directory Tree Walk (últimas 24h) mostrando tamanho
        System.out.println("\n=== Directory Tree Walk (data) — modificados nas últimas 24h ===");
        Instant cutoff = Instant.now().minus(24, ChronoUnit.HOURS);
        try (Stream<Path> walk = Files.walk(dataDir)) {
            final int[] count = {0};
            walk.filter(Files::isRegularFile).forEach(p -> {
                try {
                    FileTime lm = Files.getLastModifiedTime(p);
                    if (lm.toInstant().isAfter(cutoff)) {
                        long sz = Files.size(p);
                        Path rel = dataDir.relativize(p);
                        System.out.println(rel + " | modificado: " + fmt.format(lm.toInstant()) + " | tamanho: " + sz + " bytes");
                        count[0]++;
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler metadados de " + p + ": " + e.getMessage());
                }
            });
            if (count[0] == 0) System.out.println("(nenhum arquivo recente)");
        } catch (IOException e) {
            System.out.println("Falha ao percorrer 'data': " + e.getMessage());
        }

        // 9) File Attributes and Metadata (clients.txt)
        System.out.println("\n=== File Attributes and Metadata (clients.txt) ===");
        if (exists) {
            try {
                BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
                System.out.println("Tamanho: " + attrs.size() + " bytes");
                System.out.println("Criação: " + fmt.format(attrs.creationTime().toInstant()));
                System.out.println("Última modificação: " + fmt.format(attrs.lastModifiedTime().toInstant()));
            } catch (IOException e) {
                System.out.println("Erro ao ler atributos de clients.txt: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não existe. Leitura de atributos ignorada.");
        }
    }
}
