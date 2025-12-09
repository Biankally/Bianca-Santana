import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        Path dataDir = Paths.get("../../data");
        Path clientsFile = dataDir.resolve("clients.txt");
        Path clientsNewFile = dataDir.resolve("clients_new.txt");
        Path backupDir = dataDir.resolve("backup");
        Path tempDir = dataDir.resolve("temp");

        System.out.println("1. List Files in Directory:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar arquivos: " + e.getMessage());
        }

        System.out.println("\n2. Check Path Exists:");
        System.out.println(Files.exists(clientsFile));

        System.out.println("\n3. Read File Line by Line:");
        try (Stream<String> lines = Files.lines(clientsFile)) {
            final int[] lineNumber = {1};
            lines.forEach(line -> System.out.println((lineNumber[0]++) + ": " + line));
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        System.out.println("\n4. Read File in One Go:");
        try {
            List<String> lines = Files.readAllLines(clientsFile);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        System.out.println("\n5. Write to File:");
        List<String> newContent = List.of(
                "João da Silva",
                "joaodasilva@email.com",
                "(11) 99999-9999"
        );
        try {
            Files.write(clientsNewFile, newContent, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            System.out.println("Arquivo criado com sucesso:");
            Files.readAllLines(clientsNewFile).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }

        System.out.println("\n6. Copy File:");
        try {
            Files.copy(clientsFile, backupDir.resolve("clients_backup.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao copiar arquivo: " + e.getMessage());
        }

        System.out.println("\n7. Delete File:");
        try {
            Files.deleteIfExists(tempDir.resolve("old_clients.txt"));
            Files.deleteIfExists(backupDir.resolve("old_clients_backup.txt"));
            System.out.println("Arquivos deletados (se existiam).");
        } catch (IOException e) {
            System.out.println("Erro ao deletar arquivos: " + e.getMessage());
        }

        System.out.println("\n8. List Files Recursively:");
        try (Stream<Path> walk = Files.walk(dataDir)) {
            Instant oneHourAgo = Instant.now().minus(1, ChronoUnit.HOURS);
            walk.filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        return Files.getLastModifiedTime(path).toInstant().isBefore(oneHourAgo);
                    } catch (IOException e) {
                        return false;
                    }
                })
                .forEach(path -> {
                    try {
                        System.out.println(path + " - " + Files.size(path) + " bytes");
                    } catch (IOException e) {
                        System.out.println("Erro ao obter tamanho: " + e.getMessage());
                    }
                });
        } catch (IOException e) {
            System.out.println("Erro ao percorrer diretório: " + e.getMessage());
        }

        System.out.println("\n9. Buffered File Read:");
        for (Path file : List.of(clientsFile, clientsNewFile)) {
            System.out.println("Lendo: " + file);
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler com BufferedReader: " + e.getMessage());
            }
        }

        System.out.println("\n10. File Attributes & Metadata:");
        try {
            BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
            System.out.println("Tamanho: " + attrs.size() + " bytes");
            System.out.println("Criado em: " + attrs.creationTime());
            System.out.println("Última modificação: " + attrs.lastModifiedTime());
        } catch (IOException e) {
            System.out.println("Erro ao obter atributos: " + e.getMessage());
        }
    }
}
