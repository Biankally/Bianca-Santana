import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path; // <-- 1. IMPORT ADICIONADO AQUI
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstra várias operações de manipulação de arquivos usando java.nio.
 * Todas as operações são executadas diretamente no método main.
 */
public class FileApp {

    public static void main(String[] args) {
        
        // --- SETUP: Criar diretórios e arquivos iniciais necessários ---
        // Isso é necessário para que as operações abaixo funcionem.
        try {
            System.out.println("--- 0. SETUP INICIAL ---");
            Path dataDir = Paths.get("data");
            Path backupDir = Paths.get("backup");
            Path clientsFile = dataDir.resolve("clients.txt");

            if (Files.notExists(dataDir)) {
                Files.createDirectories(dataDir);
                System.out.println("Diretório criado: " + dataDir);
            }
            if (Files.notExists(backupDir)) {
                Files.createDirectories(backupDir);
                System.out.println("Diretório criado: " + backupDir);
            }
            
            if (Files.notExists(clientsFile)) {
                List<String> initialClients = Arrays.asList(
                        "1,John Doe,john.doe@example.com",
                        "2,Jane Smith,jane.smith@example.com",
                        "3,Robert Brown,robert.brown@example.com"
                );
                Files.write(clientsFile, initialClients, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
                System.out.println("Arquivo inicial criado: " + clientsFile);
            }
            
            // Cria um arquivo extra para o teste de "walk"
            Path oldReport = dataDir.resolve("report_old.pdf");
            if (Files.notExists(oldReport)) {
                 Files.write(oldReport, Arrays.asList("Old data"), StandardOpenOption.CREATE);
                 // Modifica o tempo para mais de 24h atrás (simulação)
                 // --- 2. LINHA CORRIGIDA ABAIXO ---
                 Files.setLastModifiedTime(oldReport, FileTime.from(Instant.now().minus(48, ChronoUnit.HOURS)));
            }


        } catch (IOException e) {
            System.err.println("Erro durante o setup inicial: " + e.getMessage());
            e.printStackTrace();
            return; // Encerra se o setup falhar
        }
        
        System.out.println("\n----------------------------------------\n");

        // 1. List Files in Directory
        System.out.println("--- 1. List Files in Directory (data) ---");
        Path dataDir = Paths.get("data");
        try (Stream<Path> stream = Files.list(dataDir)) {
            stream.forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // 2. Check Path Exists
        System.out.println("--- 2. Check Path Exists (data/clients.txt) ---");
        Path clientsPath = Paths.get("data", "clients.txt");
        boolean exists = Files.exists(clientsPath);
        System.out.println("O arquivo " + clientsPath + " existe? " + exists);

        System.out.println("\n----------------------------------------\n");

        // 3. Read File Line by Line
        System.out.println("--- 3. Read File Line by Line (data/clients.txt) ---");
        AtomicInteger lineNumber = new AtomicInteger(1);
        try (Stream<String> lines = Files.lines(clientsPath, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                System.out.println(lineNumber.getAndIncrement() + ": " + line);
            });
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo linha por linha: " + e.getMessage());
        }
        
        System.out.println("\n----------------------------------------\n");

        // 4. Append Text to File
        System.out.println("--- 4. Append Text to File (data/clients.txt) ---");
        System.out.println("Digite novas linhas (digite 'SAIR' em uma linha nova para parar):");
        
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> newLines = new java.util.ArrayList<>();
            while (true) {
                String inputLine = scanner.nextLine();
                if ("SAIR".equalsIgnoreCase(inputLine.trim())) {
                    break;
                }
                if (!inputLine.isEmpty()) {
                    newLines.add(inputLine);
                }
            }

            if (!newLines.isEmpty()) {
                Files.write(clientsPath, newLines, StandardCharsets.UTF_8, 
                            StandardOpenOption.APPEND, StandardOpenOption.WRITE);
                
                System.out.println("\nLinhas adicionadas com sucesso:");
                newLines.forEach(System.out::println);
            } else {
                System.out.println("Nenhuma linha foi adicionada.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao anexar texto ao arquivo: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // 5. Write Text File
        System.out.println("--- 5. Write Text File (data/clients_new.txt) ---");
        Path newClientsPath = Paths.get("data", "clients_new.txt");
        List<String> formattedData = Arrays.asList(
                "ID;NOME;EMAIL",
                "10;Alice;alice@web.com",
                "11;Bob;bob@web.com"
        );
        
        try {
            Files.write(newClientsPath, formattedData, StandardCharsets.UTF_8, 
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            
            if (Files.exists(newClientsPath) && Files.size(newClientsPath) > 0) {
                System.out.println("Arquivo 'clients_new.txt' gravado com sucesso.");
            } else {
                System.out.println("Falha ao gravar o arquivo 'clients_new.txt'.");
            }
            
            System.out.println("\nConteúdo de 'clients_new.txt':");
            List<String> readBack = Files.readAllLines(newClientsPath, StandardCharsets.UTF_8);
            readBack.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Erro ao escrever ou ler o novo arquivo: " + e.getMessage());
        }
        
        System.out.println("\n----------------------------------------\n");

        // 6. Copy File
        System.out.println("--- 6. Copy File (clients.txt -> backup/clients_backup.txt) ---");
        Path backupPath = Paths.get("backup", "clients_backup.txt");
        try {
            Files.copy(clientsPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado para: " + backupPath);
        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // 7. Delete
        System.out.println("--- 7. Delete (backup/old-clients.txt) ---");
        Path oldClientsPath = Paths.get("backup", "old-clients.txt");
        try {
            Files.delete(oldClientsPath);
            System.out.println("Arquivo " + oldClientsPath + " removido com sucesso (não deveria acontecer se o arquivo não existe).");
        } catch (NoSuchFileException e) {
            System.err.println("Falha ao remover (COMO ESPERADO): Arquivo não encontrado: " + e.getFile());
        } catch (IOException e) {
            System.err.println("Erro de permissão ou outro IO erro ao tentar remover: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------\n");

        // 8. Directory Tree Walk
        System.out.println("--- 8. Directory Tree Walk (Arquivos em 'data' modificados nas últimas 24h) ---");
        Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);
        
        try (Stream<Path> walk = Files.walk(dataDir)) {
            List<Path> recentFiles = walk
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                        return attrs.lastModifiedTime().toInstant().isAfter(twentyFourHoursAgo);
                    } catch (IOException e) {
                        System.err.println("Não foi possível ler atributos de: " + path);
                        return false;
                    }
                })
                .collect(Collectors.toList());

            if (recentFiles.isEmpty()) {
                System.out.println("Nenhum arquivo modificado nas últimas 24 horas encontrado.");
            } else {
                recentFiles.forEach(path -> {
                    try {
                        System.out.printf("Arquivo: %-20s | Tamanho: %d bytes%n", 
                                          path.getFileName(), 
                                          Files.size(path));
                    } catch (IOException e) {
                        System.err.println("Erro ao obter tamanho de: " + path);
                    }
                });
            }

        } catch (IOException e) {
            System.err.println("Erro ao percorrer o diretório 'data': " + e.getMessage());
        }
        
        System.out.println("\n----------------------------------------\n");

        // 9. File Attributes and Metadata
        System.out.println("--- 9. File Attributes and Metadata (data/clients.txt) ---");
        try {
            BasicFileAttributes attrs = Files.readAttributes(clientsPath, BasicFileAttributes.class);
            
            System.out.println("Atributos para: " + clientsPath);
            System.out.println("Tamanho (bytes): " + attrs.size());
            System.out.println("Data de Criação: " + attrs.creationTime());
            System.out.println("Última Modificação: " + attrs.lastModifiedTime());
            System.out.println("É diretório? " + attrs.isDirectory());
            System.out.println("É arquivo regular? " + attrs.isRegularFile());

        } catch (IOException e) {
            System.err.println("Erro ao ler os atributos do arquivo: " + e.getMessage());
        }
        
        System.out.println("\n----------------------------------------\n");
        System.out.println("Todas as operações foram concluídas.");
    }
}
