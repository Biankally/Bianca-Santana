import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class FileApp {
    public static void main(String[] args) throws Exception {
        Path baseDir = Paths.get("");
        Path dataDir = baseDir.resolve("data");
        Path backupDir = baseDir.resolve("backup");
        Path clientsPath = dataDir.resolve("clients.txt");

        if (!Files.exists(dataDir)) {
            Files.createDirectories(dataDir);
        }
        if (!Files.exists(backupDir)) {
            Files.createDirectories(backupDir);
        }
        if (!Files.exists(clientsPath)) {
            Files.write(clientsPath, List.of("Ana", "Bruno", "Carlos"), StandardCharsets.UTF_8);
        }

        System.out.println("List Files in Directory");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName().toString());
            }
        }

        System.out.println("Check Path Exists");
        System.out.println(Files.exists(clientsPath));

        System.out.println("Read File Line by Line");
        List<String> lines = Files.readAllLines(clientsPath, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        System.out.println("Append Text to File");
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            List<String> added = new ArrayList<>();
            while (true) {
                String input = scanner.nextLine();
                if (input == null) break;
                String value = input.trim();
                if (value.isEmpty()) break;
                Files.writeString(clientsPath, System.lineSeparator() + value, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                added.add(value);
            }
            for (String s : added) {
                System.out.println(s);
            }
        }

        System.out.println("Write Text File");
        Path clientsNewPath = dataDir.resolve("clients_new.txt");
        List<String> formatted = List.of("ID;NOME", "1;Ana", "2;Bruno", "3;Carlos");
        Files.write(clientsNewPath, formatted, StandardCharsets.UTF_8);
        System.out.println(Files.exists(clientsNewPath));
        List<String> newContent = Files.readAllLines(clientsNewPath, StandardCharsets.UTF_8);
        for (String s : newContent) {
            System.out.println(s);
        }

        System.out.println("Copy File");
        Path backupFile = backupDir.resolve("clients_backup.txt");
        Files.copy(clientsPath, backupFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(Files.exists(backupFile));

        System.out.println("Delete");
        Path oldBackup = backupDir.resolve("old-clients.txt");
        try {
            Files.delete(oldBackup);
            System.out.println("Removido");
        } catch (NoSuchFileException e) {
            System.out.println("Arquivo nao encontrado: " + oldBackup.getFileName());
        } catch (IOException e) {
            System.out.println("Falha de permissao ao remover: " + oldBackup.getFileName());
        }

        System.out.println("Directory Tree Walk");
        Instant cutoff = Instant.now().minus(Duration.ofHours(24));
        try {
            Files.walk(dataDir, Integer.MAX_VALUE, FileVisitOption.FOLLOW_LINKS)
                .filter(Files::isRegularFile)
                .forEach(p -> {
                    try {
                        FileTime ft = Files.getLastModifiedTime(p);
                        if (ft.toInstant().isAfter(cutoff)) {
                            System.out.println(p.getFileName() + " -> " + Files.size(p));
                        }
                    } catch (IOException ex) {
                        System.out.println("Erro ao ler arquivo: " + p.getFileName());
                    }
                });
        } catch (IOException e) {
            System.out.println("Erro ao percorrer diretorio: " + dataDir.getFileName());
        }

        System.out.println("File Attributes and Metadata");
        BasicFileAttributes attrs = Files.readAttributes(clientsPath, BasicFileAttributes.class);
        System.out.println("Tamanho: " + attrs.size());
        System.out.println("Criacao: " + attrs.creationTime());
        System.out.println("Ultima modificacao: " + attrs.lastModifiedTime());
    }
}
