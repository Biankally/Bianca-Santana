import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileApp {

    public static void main(String[] args) {
        
        System.out.println("--- 0. Configuração Inicial ---");
        Path dataDir = Paths.get("data");
        Path backupDir = Paths.get("backup");
        Path clientsFile = dataDir.resolve("clients.txt");

        try {
            Files.createDirectories(dataDir);
            Files.createDirectories(backupDir);

            if (!Files.exists(clientsFile)) {
                List<String> initialClients = Arrays.asList("1 - Alice", "2 - Bob", "3 - Charlie");
                Files.write(clientsFile, initialClients, StandardOpenOption.CREATE);
                System.out.println("Diretórios 'data', 'backup' e arquivo 'clients.txt' inicial criados.");
            }

            Path oldReport = dataDir.resolve("report_old.log");
             if (!Files.exists(oldReport)) {
                Files.write(oldReport, Arrays.asList("Log data antigo"), StandardOpenOption.CREATE);
                Files.setLastModifiedTime(oldReport, FileTime.from(Instant.now().minus(2, ChronoUnit.DAYS)));
             }
             
            Path newReport = dataDir.resolve("report_new.log");
             if (!Files.exists(newReport)) {
                Files.write(newReport, Arrays.asList("Log data recente"), StandardOpenOption.CREATE);
             }
            
        } catch (IOException e) {
            System.err.println("Erro fatal na configuração inicial: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- 1. List Files in Directory (data) ---");
        try (Stream<Path> stream = Files.list(dataDir)) {
            System.out.println("Arquivos e diretórios em 'data':");
            stream.forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.err.println("Erro ao listar diretório: " + e.getMessage());
        }

        System.out.println("\n--- 2. Check Path Exists (clients.txt) ---");
        boolean exists = Files.exists(clientsFile);
        System.out.println("O arquivo 'clients.txt' existe? " + exists);

        System.out.println("\n--- 3. Read File Line by Line (clients.txt) ---");
        if (exists) {
            try {
                List<String> lines = Files.readAllLines(clientsFile);
                System.out.println("Conteúdo de 'clients.txt':");
                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + ": " + lines.get(i));
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo 'clients.txt' não encontrado para leitura.");
        }

        System.out.println("\n--- 4. Append Text to File (clients.txt) ---");
        System.out.println("Digite o texto para adicionar (digite 'SAIR' em uma linha para parar):");
        
        List<String> newLines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if ("SAIR".equalsIgnoreCase(line)) {
                break;
            }
            newLines.add(line);
        }

        if (!newLines.isEmpty()) {
            try {
                Files.write(clientsFile, newLines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                System.out.println("Linhas adicionadas com sucesso:");
                for (String addedLine : newLines) {
                    System.out.println("+ " + addedLine);
                }
            } catch (IOException e) {
                System.err.println("Erro ao anexar ao arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhuma linha adicionada.");
        }

        System.out.println("\n--- 5. Write Text File (clients_new.txt) ---");
        Path newClientsFile = dataDir.resolve("clients_new.txt");
        List<String> formattedData = Arrays.asList(
            "ID;Nome;Email",
            "101;David;david@example.com",
            "102;Eve;eve@example.com"
        );
        
        try {
            Files.write(newClientsFile, formattedData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo 'clients_new.txt' gravado com sucesso.");
            
            System.out.println("Lendo 'clients_new.txt' para confirmação:");
            List<String> linesRead = Files.readAllLines(newClientsFile);
            linesRead.forEach(System.out::println);
            
        } catch (IOException e) {
            System.err.println("Erro ao gravar ou ler novo arquivo: " + e.getMessage());
        }

        System.out.println("\n--- 6. Copy File (clients.txt -> backup/clients_backup.txt) ---");
        Path backupFile = backupDir.resolve("clients_backup.txt");

        try {
            Path copiedPath = Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado para: " + copiedPath.toAbsolutePath());
            System.out.println("Verificando se a cópia existe: " + Files.exists(backupFile));
        } catch (IOException e) {
            System.err.println("Erro ao copiar arquivo: " + e.getMessage());
        }

        System.out.println("\n--- 7. Delete (backup/old-clients.txt) ---");
        Path oldFile = backupDir.resolve("old-clients.txt");
        
        try {
            Files.delete(oldFile);
            System.out.println("Arquivo 'old-clients.txt' deletado com sucesso (Inesperado, pois não deveria existir).");
        } catch (NoSuchFileException e) {
            System.err.println("Erro esperado: O arquivo não existe. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao deletar arquivo (ex: permissão negada): " + e.getMessage());
        }

        System.out.println("\n--- 8. Directory Tree Walk (Arquivos em 'data' modificados nas últimas 24h) ---");
        Instant last24Hours = Instant.now().minus(24, ChronoUnit.HOURS);

        try (Stream<Path> walk = Files.walk(dataDir)) {
            List<Path> recentFiles = walk
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        return Files.getLastModifiedTime(path).toInstant().isAfter(last24Hours);
                    } catch (IOException e) {
                        System.err.println("Não foi possível ler o tempo do arquivo: " + path);
                        return false;
                    }
                })
                .collect(Collectors.toList());

            if (recentFiles.isEmpty()) {
                System.out.println("Nenhum arquivo modificado recentemente encontrado.");
            } else {
                recentFiles.forEach(path -> {
                    try {
                        System.out.printf("Arquivo: %s, Tamanho: %d bytes%n", 
                            path.getFileName(), Files.size(path));
                    } catch (IOException e) {
                        System.err.println("Não foi possível obter o tamanho de: " + path);
                    }
                });
            }

        } catch (IOException e) {
            System.err.println("Erro ao percorrer o diretório 'data': " + e.getMessage());
        }

        System.out.println("\n--- 9. File Attributes and Metadata (clients.txt) ---");
        try {
            BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
            
            System.out.println("Atributos para: " + clientsFile.toAbsolutePath());
            System.out.println("Tamanho: " + attrs.size() + " bytes");
            System.out.println("Data de Criação: " + attrs.creationTime());
            System.out.println("Última Modificação: " + attrs.lastModifiedTime());
            System.out.println("Último Acesso: " + attrs.lastAccessTime());
            System.out.println("É diretório? " + attrs.isDirectory());
            System.out.println("É arquivo regular? " + attrs.isRegularFile());
            
        } catch (IOException e) {
            System.err.println("Erro ao ler atributos do arquivo: " + e.getMessage());
        }

        scanner.close();
        System.out.println("\n--- Fim das operações ---");
    }
}