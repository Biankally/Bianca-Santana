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

        // 1. List Files in Directory
        System.out.println("=== List Files in Directory ===");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {
            for (Path p : stream) {
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar arquivos: " + e.getMessage());
        }

        // 2. Check Path Exists
        System.out.println("\n=== Check Path Exists ===");
        System.out.println("clients.txt existe? " + Files.exists(clientsFile));

        // 3. Read File Line by Line
        System.out.println("\n=== Read File Line by Line ===");
        if (Files.exists(clientsFile)) {
            try {
                List<String> linhas = Files.readAllLines(clientsFile);
                int num = 1;
                for (String l : linhas) {
                    System.out.println(num + ": " + l);
                    num++;
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        // 4. Append Text to File
        System.out.println("\n=== Append Text to File ===");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite linhas para adicionar (digite 'fim' para parar): ");
            StringBuilder sb = new StringBuilder();
            while (true) {
                String linha = sc.nextLine();
                if (linha.equalsIgnoreCase("fim")) break;
                sb.append(linha).append(System.lineSeparator());
            }
            Files.writeString(clientsFile, sb.toString(), StandardOpenOption.APPEND);
            System.out.println("Linhas adicionadas:");
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar texto: " + e.getMessage());
        }

        // 5. Write Text File
        System.out.println("\n=== Write Text File ===");
        Path newFile = dataDir.resolve("clients_new.txt");
        try {
            String conteudo = "Nome;Idade;Cidade\nAna;25;Recife\nBruno;30;São Paulo\n";
            Files.writeString(newFile, conteudo);
            System.out.println("Arquivo gravado com sucesso.\nConteúdo:");
            Files.readAllLines(newFile).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }

        // 6. Copy File
        System.out.println("\n=== Copy File ===");
        try {
            Path backupDir = Paths.get("backup");
            Files.createDirectories(backupDir);
            Path dest = backupDir.resolve("clients_backup.txt");
            Files.copy(clientsFile, dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado para: " + dest);
        } catch (IOException e) {
            System.out.println("Erro ao copiar arquivo: " + e.getMessage());
        }

        // 7. Delete
        System.out.println("\n=== Delete ===");
        Path oldBackup = Paths.get("backup/old-clients.txt");
        try {
            Files.delete(oldBackup);
            System.out.println("Arquivo excluído com sucesso.");
        } catch (NoSuchFileException e) {
            System.out.println("Arquivo não encontrado: " + oldBackup);
        } catch (IOException e) {
            System.out.println("Erro ao excluir arquivo: " + e.getMessage());
        }

        // 8. Directory Tree Walk
        System.out.println("\n=== Directory Tree Walk ===");
        try (Stream<Path> walk = Files.walk(dataDir)) {
            Instant limite = Instant.now().minus(1, ChronoUnit.DAYS);
            walk.filter(Files::isRegularFile)
                .filter(p -> {
                    try {
                        return Files.getLastModifiedTime(p).toInstant().isAfter(limite);
                    } catch (IOException e) {
                        return false;
                    }
                })
                .forEach(p -> {
                    try {
                        System.out.println(p + " (" + Files.size(p) + " bytes)");
                    } catch (IOException e) {
                        System.out.println("Erro ao obter tamanho: " + e.getMessage());
                    }
                });
        } catch (IOException e) {
            System.out.println("Erro ao percorrer diretórios: " + e.getMessage());
        }

        // 9. File Attributes and Metadata
        System.out.println("\n=== File Attributes and Metadata ===");
        try {
            BasicFileAttributes att = Files.readAttributes(clientsFile, BasicFileAttributes.class);
            System.out.println("Tamanho: " + att.size() + " bytes");
            System.out.println("Criado em: " + att.creationTime());
            System.out.println("Última modificação: " + att.lastModifiedTime());
        } catch (IOException e) {
            System.out.println("Erro ao ler atributos: " + e.getMessage());
        }
    }
}