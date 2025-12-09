import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 1. List Files in Directory ===");
        try {
            Path dataDir = Paths.get("src/data");
            Stream<Path> files = Files.list(dataDir);
            files.filter(Files::isRegularFile)
                 .forEach(file -> System.out.println(file.getFileName()));
            files.close();
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }
        
        System.out.println("\n=== 2. Check Path Exists ===");
        Path clientsPath = Paths.get("src/data/clients.txt");
        boolean exists = Files.exists(clientsPath);
        System.out.println("Arquivo clients.txt existe: " + exists);
        
        System.out.println("\n=== 3. Read File Line by Line ===");
        try {
            Path filePath = Paths.get("src/data/clients.txt");
            java.util.List<String> lines = Files.readAllLines(filePath);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        
        System.out.println("\n=== 4. Append Text to File ===");
        try {
            Path filePath = Paths.get("src/data/clients.txt");
            System.out.println("Digite as linhas para adicionar (digite 'fim' para encerrar):");
            StringBuilder newLines = new StringBuilder();
            
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("fim")) {
                    break;
                }
                newLines.append(line).append(System.lineSeparator());
            }
            
            if (newLines.length() > 0) {
                Files.write(filePath, newLines.toString().getBytes(), StandardOpenOption.APPEND);
                System.out.println("Linhas adicionadas:");
                String[] addedLines = newLines.toString().split(System.lineSeparator());
                for (String line : addedLines) {
                    if (!line.isEmpty()) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao adicionar texto: " + e.getMessage());
        }
        
        System.out.println("\n=== 5. Write Text File ===");
        try {
            Path newFilePath = Paths.get("src/data/clients_new.txt");
            String content = "10 Ana Silva 3500.00\n11 Carlos Oliveira 2800.00\n12 Julia Santos 4200.00\n";
            Files.write(newFilePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo clients_new.txt gravado com sucesso!");
            
            java.util.List<String> readLines = Files.readAllLines(newFilePath);
            System.out.println("Conteúdo do arquivo:");
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo: " + e.getMessage());
        }
        
        System.out.println("\n=== 6. Copy File ===");
        try {
            Path source = Paths.get("src/data/clients.txt");
            Path target = Paths.get("src/data/backup/clients_backup.txt");
            Files.createDirectories(target.getParent());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado com sucesso para backup/clients_backup.txt");
        } catch (IOException e) {
            System.err.println("Erro ao copiar arquivo: " + e.getMessage());
        }
        
        System.out.println("\n=== 7. Delete ===");
        try {
            Path fileToDelete = Paths.get("src/data/backup/old-clients.txt");
            Files.delete(fileToDelete);
            System.out.println("Arquivo old-clients.txt removido com sucesso");
        } catch (NoSuchFileException e) {
            System.out.println("Arquivo old-clients.txt não encontrado (ausente)");
        } catch (IOException e) {
            System.err.println("Erro ao remover arquivo (falha de permissão ou outro erro): " + e.getMessage());
        }
        
        System.out.println("\n=== 8. Directory Tree Walk ===");
        try {
            Path dataDir = Paths.get("src/data");
            Instant now = Instant.now();
            Instant yesterday = now.minus(24, ChronoUnit.HOURS);
            
            Stream<Path> paths = Files.walk(dataDir);
            paths.filter(Files::isRegularFile)
                 .filter(path -> {
                    try {
                        FileTime lastModified = Files.getLastModifiedTime(path);
                        return lastModified.toInstant().isAfter(yesterday);
                    } catch (IOException e) {
                        return false;
                    }
                 })
                 .forEach(path -> {
                    try {
                        long size = Files.size(path);
                        System.out.println(path + " - Tamanho: " + size + " bytes");
                    } catch (IOException e) {
                        System.err.println("Erro ao obter tamanho: " + e.getMessage());
                    }
                 });
            paths.close();
        } catch (IOException e) {
            System.err.println("Erro ao percorrer diretório: " + e.getMessage());
        }
        
        System.out.println("\n=== 9. File Attributes and Metadata ===");
        try {
            Path filePath = Paths.get("src/data/clients.txt");
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            
            System.out.println("Atributos do arquivo clients.txt:");
            System.out.println("Tamanho: " + attrs.size() + " bytes");
            System.out.println("Data de criação: " + attrs.creationTime());
            System.out.println("Última modificação: " + attrs.lastModifiedTime());
        } catch (IOException e) {
            System.err.println("Erro ao ler atributos: " + e.getMessage());
        }
        
        scanner.close();
    }
}

