import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.*;



public class FileApp {
    public static void main(String[] args) {
        Path data = Paths.get("data");
        Path clients = data.resolve("clients.txt");
        Path clientsNew = data.resolve("clients_new.txt");
        Path backup = Paths.get("backup");
        Path clientsBackup = backup.resolve("clients_backup.txt");
        Path oldClients = backup.resolve("old-clients.txt");


        try (Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8)) {




            System.out.println("List Files in Directory");
            try {
                if (Files.isDirectory(data)) Files.list(data).forEach(p -> System.out.println(p.getFileName()));
                else System.out.println("(diretório 'data' não existe)");
            } catch (IOException e) { System.out.println("Falha ao listar: " + e.getMessage()); }




            System.out.println("\nCheck Path Exists");
            System.out.println(Files.exists(clients));




            System.out.println("\nRead File Line by Line");
            if (Files.exists(clients)) {
                try {
                    List<String> all = Files.readAllLines(clients, StandardCharsets.UTF_8);
                    for (int i = 0; i < all.size(); i++) System.out.printf("%d: %s%n", i + 1, all.get(i));
                } catch (IOException e) { System.out.println("Erro ao ler: " + e.getMessage()); }
            } else System.out.println("(clients.txt não encontrado)");




            System.out.println("\nAppend Text to File");
            try {
                Files.createDirectories(data);
                if (Files.notExists(clients)) Files.createFile(clients);
                System.out.println("Digite linhas para adicionar (ENTER vazio finaliza):");
                List<String> add = new ArrayList<>();
                for (;;) { System.out.print("> "); String s = sc.nextLine(); if (s.isEmpty()) break; add.add(s); }
                if (!add.isEmpty()) { Files.write(clients, add, StandardCharsets.UTF_8, APPEND); add.forEach(System.out::println); }
                else System.out.println("(nada a adicionar)");
            } catch (IOException e) { System.out.println("Erro ao anexar: " + e.getMessage()); }




            System.out.println("\nWrite Text File");
            try {
                List<String> linhas = List.of("id,nome,limite","1,Ana,5000","2,Bruno,3000","3,Carlos,7000");
                Files.write(clientsNew, linhas, StandardCharsets.UTF_8, CREATE, TRUNCATE_EXISTING);
                Files.readAllLines(clientsNew, StandardCharsets.UTF_8).forEach(System.out::println);
            } catch (IOException e) { System.out.println("Erro write/read: " + e.getMessage()); }




            System.out.println("\nCopy File");
            try {
                Files.createDirectories(backup);
                if (Files.exists(clients)) { Files.copy(clients, clientsBackup, REPLACE_EXISTING); System.out.println("Copiado para " + clientsBackup); }
                else System.out.println("(clients.txt não encontrado; cópia ignorada)");
            } catch (IOException e) { System.out.println("Erro na cópia: " + e.getMessage()); }




            System.out.println("\nDelete");
            try { Files.delete(oldClients); System.out.println("backup/old-clients.txt removido."); }
            catch (NoSuchFileException e) { System.out.println("Arquivo não existe: " + oldClients.getFileName()); }
            catch (IOException e) { System.out.println("Falha ao remover: " + e.getMessage()); }




            System.out.println("\nDirectory Tree Walk (últimas 24h)");
            try {
                if (Files.exists(data)) {
                    Instant limite = Instant.now().minus(Duration.ofHours(24));
                    try (var w = Files.walk(data)) {
                        w.filter(Files::isRegularFile).forEach(p -> {
                            try {
                                if (Files.getLastModifiedTime(p).toInstant().isAfter(limite))
                                    System.out.printf("%s | %d bytes%n", data.relativize(p), Files.size(p));
                            } catch (IOException ex) { System.out.println("Meta falhou em " + p.getFileName()); }
                        });
                    }
                } else System.out.println("(diretório 'data' não existe)");
            } catch (IOException e) { System.out.println("Erro no walk: " + e.getMessage()); }




            System.out.println("\nFile Attributes and Metadata");
            try {
                if (Files.exists(clients)) {
                    BasicFileAttributes a = Files.readAttributes(clients, BasicFileAttributes.class);
                    System.out.println("Tamanho: " + a.size() + " bytes");
                    System.out.println("Criação: " + a.creationTime());
                    System.out.println("Última modificação: " + a.lastModifiedTime());
                } else System.out.println("(clients.txt não encontrado)");
            } catch (IOException e) { System.out.println("Erro lendo atributos: " + e.getMessage()); }
        }
    }
}
