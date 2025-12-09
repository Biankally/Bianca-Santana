import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class FileApp {

    public static void main(String[] args) {
        Path dataDir = Paths.get("data");
        Path clientsFile = dataDir.resolve("clients.txt");
        Path backupDir = Paths.get("backup");
        
        System.out.println("=== INÍCIO DO PROGRAMA ===");

        try {
            System.out.println("\n--- 1. List Files in Directory ---");
            if (Files.exists(dataDir) && Files.isDirectory(dataDir)) {
                try (Stream<Path> files = Files.list(dataDir)) {
                    files.forEach(path -> System.out.println(path.getFileName()));
                }
            } else {
                System.out.println("Diretório 'data' não encontrado.");
            }

            System.out.println("\n--- 2. Check Path Exists ---");
            boolean exists = Files.exists(clientsFile);
            System.out.println("O arquivo clients.txt existe? " + exists);

            if (exists) {
                System.out.println("\n--- 3. Read File Line by Line ---");
                List<String> lines = Files.readAllLines(clientsFile);
                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + ": " + lines.get(i));
                }

                System.out.println("\n--- 4. Append Text to File ---");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite um novo nome de cliente para adicionar: ");
                String newClient = scanner.nextLine();
                
                Files.write(clientsFile, Collections.singletonList(newClient), StandardOpenOption.APPEND);
                System.out.println("Linha adicionada: " + newClient);

                System.out.println("\n--- 5. Write Text File ---");
                Path newFile = dataDir.resolve("clients_new.txt");
                String content = "ID: 001, Nome: Novo Cliente VIP\nID: 002, Nome: Outro Cliente";
                
                Files.write(newFile, content.getBytes());
                System.out.println("Arquivo clients_new.txt gravado com sucesso.");
                
                System.out.println("Conteúdo lido do novo arquivo:");
                Files.readAllLines(newFile).forEach(System.out::println);

                System.out.println("\n--- 6. Copy File ---");
                if (!Files.exists(backupDir)) {
                    Files.createDirectory(backupDir);
                }
                Path backupFile = backupDir.resolve("clients_backup.txt");
                Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Cópia realizada para: " + backupFile);

                System.out.println("\n--- 7. Delete ---");
                Path fileToDelete = backupDir.resolve("old-clients.txt");
                try {
                    Files.delete(fileToDelete);
                    System.out.println("Arquivo removido com sucesso.");
                } catch (NoSuchFileException e) {
                    System.out.println("Erro: O arquivo não existe (NoSuchFileException).");
                } catch (IOException e) {
                    System.out.println("Erro de permissão ou outro erro de I/O: " + e.getMessage());
                }

                System.out.println("\n--- 8. Directory Tree Walk (Modificados nas últimas 24h) ---");
                Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);
                
                try (Stream<Path> walk = Files.walk(dataDir)) {
                    walk.filter(Files::isRegularFile)
                        .filter(p -> {
                            try {
                                return Files.getLastModifiedTime(p).toInstant().isAfter(twentyFourHoursAgo);
                            } catch (IOException e) {
                                return false;
                            }
                        })
                        .forEach(p -> {
                            try {
                                System.out.println("Arquivo: " + p.getFileName() + " | Tamanho: " + Files.size(p) + " bytes");
                            } catch (IOException e) {
                                System.err.println("Erro ao ler tamanho: " + p);
                            }
                        });
                }

                System.out.println("\n--- 9. File Attributes and Metadata ---");
                BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                                                             .withZone(ZoneId.systemDefault());

                System.out.println("Arquivo: " + clientsFile.getFileName());
                System.out.println("Tamanho: " + attrs.size() + " bytes");
                System.out.println("Criação: " + formatter.format(attrs.creationTime().toInstant()));
                System.out.println("Última Modificação: " + formatter.format(attrs.lastModifiedTime().toInstant()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
