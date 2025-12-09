
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        Path dataDir = Paths.get("data");
        Path clientsFile = dataDir.resolve("clients.txt");
        Path backupDir = Paths.get("backup");
        Path backupFile = backupDir.resolve("clients_backup.txt");
        Path oldBackup = backupDir.resolve("old-clients.txt");
        Path newFile = dataDir.resolve("clients_new.txt");

        try {
            System.out.println("=== List Files in Directory ===");
            if (Files.exists(dataDir) && Files.isDirectory(dataDir)) {
                try (Stream<Path> paths = Files.list(dataDir)) {
                    paths.forEach(p -> System.out.println("File: " + p.getFileName()));
                }
            } else {
                System.out.println("Directory 'data' not found.");
            }

            System.out.println("\n=== Check Path Exists ===");
            System.out.println("clients.txt exists? " + Files.exists(clientsFile));

            System.out.println("\n=== Read File Line by Line ===");
            if (Files.exists(clientsFile)) {
                List<String> lines = Files.readAllLines(clientsFile);
                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + ": " + lines.get(i));
                }
            } else {
                System.out.println("clients.txt not found.");
            }

            System.out.println("\n=== Append Text to File ===");
            if (Files.exists(clientsFile)) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter new lines to append (empty line to finish):\n");
                StringBuilder newContent = new StringBuilder();
                while (true) {
                    String line = sc.nextLine();
                    if (line.isEmpty()) break;
                    newContent.append(line).append(System.lineSeparator());
                }
                if (newContent.length() > 0) {
                    Files.writeString(clientsFile, newContent.toString(), StandardOpenOption.APPEND);
                    System.out.println("Lines added:\n" + newContent);
                } else {
                    System.out.println("No new lines added.");
                }
            }

            System.out.println("\n=== Write Text File ===");
            String formattedData = "ID,NAME,EMAIL\n1,Alice,alice@mail.com\n2,Bob,bob@mail.com";
            Files.writeString(newFile, formattedData);
            System.out.println("clients_new.txt created successfully!");
            System.out.println("Content:");
            Files.readAllLines(newFile).forEach(System.out::println);

            System.out.println("\n=== Copy File ===");
            if (!Files.exists(backupDir)) Files.createDirectories(backupDir);
            Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied to " + backupFile);

            System.out.println("\n=== Delete ===");
            try {
                Files.delete(oldBackup);
                System.out.println("Deleted: " + oldBackup);
            } catch (NoSuchFileException e) {
                System.out.println("File not found: " + oldBackup);
            } catch (IOException e) {
                System.out.println("Failed to delete (permission issue?): " + e.getMessage());
            }

            System.out.println("\n=== Directory Tree Walk (Modified in last 24h) ===");
            Instant last24h = Instant.now().minus(24, ChronoUnit.HOURS);
            if (Files.exists(dataDir)) {
                try (Stream<Path> walk = Files.walk(dataDir)) {
                    walk.filter(Files::isRegularFile)
                        .filter(p -> {
                            try {
                                return Files.getLastModifiedTime(p).toInstant().isAfter(last24h);
                            } catch (IOException e) {
                                return false;
                            }
                        })
                        .forEach(p -> {
                            try {
                                System.out.println(p + " | Size: " + Files.size(p) + " bytes");
                            } catch (IOException e) {
                                System.out.println("Error reading size of " + p);
                            }
                        });
                }
            }

            System.out.println("\n=== File Attributes and Metadata ===");
            if (Files.exists(clientsFile)) {
                BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
                System.out.println("Size: " + attrs.size() + " bytes");
                System.out.println("Creation Time: " + attrs.creationTime());
                System.out.println("Last Modified: " + attrs.lastModifiedTime());
            } else {
                System.out.println("clients.txt not found.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
