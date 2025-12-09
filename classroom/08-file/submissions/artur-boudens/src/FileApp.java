import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {

    public static void main(String[] args) throws IOException {

        Path dataDir = Paths.get("data");
        Path clientsPath = dataDir.resolve("clients.txt");
        Path backupDir = dataDir.resolve("backup");
        Path backupPath = backupDir.resolve("clients_backup.txt");
        Path oldBackupPath = backupDir.resolve("old-clients.txt");
        Path newClientsPath = dataDir.resolve("clients_new.txt");

        System.out.println("\n1. List Files in Directory (data/)");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        }

        System.out.println("\n2. Check Path Exists (clients.txt)");
        boolean exists = Files.exists(clientsPath);
        System.out.println("Arquivo " + clientsPath + " existe? " + exists);

        System.out.println("\n3. Read File Line by Line (clients.txt)");
        try (BufferedReader reader = Files.newBufferedReader(clientsPath)) {
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNum + ": " + line);
                lineNum++;
            }
        }

        System.out.println("\n4. Append Text to File (clients.txt)");
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> newLines = new ArrayList<>();
            System.out.println("Digite novos nomes (um por linha). Digite 'sair' para parar:");

            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("sair")) {
                    break;
                }
                newLines.add(input);
            }

            if (!newLines.isEmpty()) {
                Files.write(clientsPath, newLines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                
                System.out.println("\nLinhas adicionadas com sucesso:");
                for (String line : newLines) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Nenhuma linha adicionada.");
            }
        }

        System.out.println("\n5. Write Text File (clients_new.txt)");
        List<String> formattedData = List.of(
                "ID;Nome;Status",
                "1;Novo Cliente A;Ativo",
                "2;Novo Cliente B;Inativo"
        );
        Files.write(newClientsPath, formattedData, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Arquivo " + newClientsPath.getFileName() + " gravado com sucesso.");
        
        System.out.println("\nConteúdo lido do " + newClientsPath.getFileName() + ":");
        String content = Files.readString(newClientsPath);
        System.out.println(content);

        System.out.println("\n6. Copy File (clients.txt -> backup/)");
        Files.copy(clientsPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Cópia realizada de " + clientsPath + " para " + backupPath);

        System.out.println("\n7. Delete (backup/old-clients.txt)");
        try {
            System.out.println("Tentando deletar: " + oldBackupPath);
            Files.delete(oldBackupPath);
            System.out.println("Arquivo deletado (ISTO NÃO DEVE APARECER, POIS O ARQUIVO NÃO EXISTE).");
        
        } catch (NoSuchFileException e) {
            System.out.println("Resultado: Arquivo não encontrado (NoSuchFileException). Não foi possível deletar.");
        
        } catch (IOException e) {
            System.err.println("Erro de I/O (ex: permissão) ao tentar deletar: " + e.getMessage());
        }

        System.out.println("\n8. Directory Tree Walk (data/ modificados nas últimas 24h)");
        Instant yesterday = Instant.now().minus(24, ChronoUnit.HOURS);
        
        try (Stream<Path> walk = Files.walk(dataDir)) {
            walk
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        return Files.getLastModifiedTime(path).toInstant().isAfter(yesterday);
                    } catch (IOException e) {
                        System.err.println("Ignorando erro ao checar data de " + path);
                        return false;
                    }
                })
                .forEach(path -> {
                    try {
                        System.out.println(path.getFileName() 
                                + " (Tamanho: " + Files.size(path) + " bytes)");
                    } catch (IOException e) {
                        System.err.println("Erro ao ler tamanho de " + path);
                    }
                });
        }

        System.out.println("\n9. File Attributes and Metadata (clients.txt)");
        BasicFileAttributes attrs = Files.readAttributes(clientsPath, BasicFileAttributes.class);
        
        System.out.println("Atributos formatados para: " + clientsPath.getFileName());
        System.out.printf("Tamanho: %d bytes\n", attrs.size());
        System.out.printf("Data de Criação: %s\n", attrs.creationTime());
        System.out.printf("Última Modificação: %s\n", attrs.lastModifiedTime());
    }
}

