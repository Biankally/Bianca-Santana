import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
      
       Path dataDir = Paths.get("../../../data");
        Path clientsFile = dataDir.resolve("clients.txt");
        Path backupDir = dataDir.resolve("backup");
        Path backupFile = backupDir.resolve("clients_backup.txt");
        Path oldBackupFile = backupDir.resolve("old-clients.txt");
        Path newClientsFile = dataDir.resolve("clients_new.txt");

        try {
            System.out.println("=== List Files in Directory ===");
            if (Files.exists(dataDir) && Files.isDirectory(dataDir)) {
                try (Stream<Path> paths = Files.list(dataDir)) {
                    paths.forEach(p -> System.out.println(p.getFileName()));
                }
            } else {
                System.out.println("Diretório 'data' não encontrado.");
            }

            System.out.println("\n=== Check Path Exists ===");
            System.out.println("clients.txt existe? " + Files.exists(clientsFile));

            if (!Files.exists(clientsFile)) {
                System.out.println("Arquivo clients.txt não encontrado. Encerrando...");
                return;
            }

            System.out.println("\n=== Read File Line by Line ===");
            List<String> lines = Files.readAllLines(clientsFile, StandardCharsets.UTF_8);
            int i = 1;
            for (String line : lines) {
                System.out.println(i++ + ": " + line);
            }

            System.out.println("\n=== Append Text to File ===");
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite novas linhas para adicionar (vazio para encerrar):");
            StringBuilder appended = new StringBuilder();
            while (true) {
                String input = sc.nextLine();
                if (input.isBlank()) break;
                Files.writeString(clientsFile, "\n" + input, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                appended.append(input).append("\n");
            }
            System.out.println("Linhas adicionadas:\n" + appended);

            System.out.println("\n=== Write Text File ===");
            String content = "ID | Nome | Sobrenome | Salário\n------------------------------\n";
            for (String line : lines) content += line + "\n";
            Files.writeString(newClientsFile, content, StandardCharsets.UTF_8);
            System.out.println("Arquivo 'clients_new.txt' criado com sucesso!\nConteúdo:");
            Files.readAllLines(newClientsFile).forEach(System.out::println);

            System.out.println("\n=== Copy File ===");
            if (!Files.exists(backupDir)) Files.createDirectories(backupDir);
            Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Cópia criada em: " + backupFile);

            System.out.println("\n=== Delete ===");
            try {
                Files.delete(oldBackupFile);
                System.out.println("Arquivo " + oldBackupFile + " removido com sucesso.");
            } catch (NoSuchFileException e) {
                System.out.println("Arquivo " + oldBackupFile + " não existe.");
            } catch (IOException e) {
                System.out.println("Falha ao remover " + oldBackupFile + ": " + e.getMessage());
            }

            System.out.println("\n=== Directory Tree Walk (últimas 24h) ===");
            Instant limite = Instant.now().minus(24, ChronoUnit.HOURS);
            try (Stream<Path> stream = Files.walk(dataDir)) {
                stream.filter(Files::isRegularFile)
                      .filter(p -> {
                          try {
                              return Files.getLastModifiedTime(p).toInstant().isAfter(limite);
                          } catch (IOException e) {
                              return false;
                          }
                      })
                      .forEach(p -> {
                          try {
                              System.out.println(p.getFileName() + " | " + Files.size(p) + " bytes");
                          } catch (IOException e) {
                              System.out.println("Erro ao ler tamanho de " + p);
                          }
                      });
            }

            System.out.println("\n=== File Attributes and Metadata ===");
            BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
            System.out.printf("Tamanho: %d bytes%n", attrs.size());
            System.out.printf("Criação: %s%n", attrs.creationTime());
            System.out.printf("Última modificação: %s%n", attrs.lastModifiedTime());

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
