import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        Path dataDir = Paths.get("../../data");
        Path clientsFile = Paths.get("../../data/clients.txt");

        Path backupDir = Paths.get("backup");
        Path newClientsFile = Paths.get("clients_new.txt");

        try {
            if (!Files.exists(dataDir)) {
                try {
                    Files.createDirectories(dataDir);
                } catch (IOException e) {
                    System.err.println("Aviso: Não foi possível criar o diretório de dados compartilhado: " + e.getMessage());
                }
            }
            if (!Files.exists(backupDir)) Files.createDirectory(backupDir);
        } catch (IOException e) {
            System.err.println("Erro ao preparar ambiente: " + e.getMessage());
        }

        System.out.println("1. List Files in Directory");
        try (Stream<Path> paths = Files.list(dataDir)) {
            paths.forEach(p -> System.out.println(" - " + p.getFileName()));
        } catch (IOException e) {
            System.out.println("Erro ao listar diretório (" + dataDir + "): " + e.getMessage());
        }

        System.out.println("\n2. Check Path Exists");
        boolean exists = Files.exists(clientsFile);
        System.out.println("O arquivo " + clientsFile + " existe? " + exists);

        if (!exists) {
            System.out.println("Pulando operações de leitura pois o arquivo original não existe.");
        } else {
            System.out.println("\n3. Read File Line by Line");
            try {
                List<String> lines = Files.readAllLines(clientsFile);
                for (int i = 0; i < lines.size(); i++) {
                    System.out.printf("%d: %s%n", (i + 1), lines.get(i));
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }

            System.out.println("\n4. Append Text to File");
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Digite um novo cliente (ID Nome Salario): ");
                String input = scanner.nextLine();

                Files.write(clientsFile, Collections.singletonList(input), StandardOpenOption.APPEND);

                System.out.println("Linha adicionada: " + input);
            } catch (IOException e) {
                System.out.println("Erro ao adicionar texto: " + e.getMessage());
            }

            System.out.println("\n5. Write Text File");
            String content = "ID;Nome;Status\n1;Empresa X;Ativo\n2;Empresa Y;Inativo";
            try {
                Files.writeString(newClientsFile, content);
                System.out.println("Arquivo gravado com sucesso.");

                String readContent = Files.readString(newClientsFile);
                System.out.println("Conteúdo lido de " + newClientsFile + ":\n" + readContent);
            } catch (IOException e) {
                System.out.println("Erro na escrita/leitura: " + e.getMessage());
            }

            System.out.println("\n6. Copy File");
            Path backupFile = backupDir.resolve("clients_backup.txt");
            try {
                Files.copy(clientsFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Cópia realizada para: " + backupFile);
            } catch (IOException e) {
                System.out.println("Erro ao copiar: " + e.getMessage());
            }

            System.out.println("\n7. Delete");
            Path oldFile = backupDir.resolve("old-clients.txt");
            try {
                Files.delete(oldFile);
                System.out.println("Arquivo deletado: " + oldFile);
            } catch (NoSuchFileException e) {
                System.out.println("Arquivo não encontrado para deleção: " + oldFile);
            } catch (IOException e) {
                System.out.println("Falha de permissão ou outro erro: " + e.getMessage());
            }

            System.out.println("\n8. Directory Tree Walk");
            try (Stream<Path> walk = Files.walk(dataDir)) {
                Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);

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
                                System.out.println("Arquivo recente: " + p.getFileName() + " | Tamanho: " + Files.size(p) + " bytes");
                            } catch (IOException e) {
                                System.out.println("Erro ao ler tamanho: " + p);
                            }
                        });
            } catch (IOException e) {
                System.out.println("Erro ao percorrer diretório: " + e.getMessage());
            }

            System.out.println("\n9. File Attributes and Metadata");
            try {
                BasicFileAttributes attrs = Files.readAttributes(clientsFile, BasicFileAttributes.class);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                        .withZone(ZoneId.systemDefault());

                System.out.println("Arquivo: " + clientsFile.getFileName());
                System.out.println("Tamanho: " + attrs.size() + " bytes");
                System.out.println("Criação: " + formatter.format(attrs.creationTime().toInstant()));
                System.out.println("Última Modificação: " + formatter.format(attrs.lastModifiedTime().toInstant()));
                System.out.println("É diretório? " + attrs.isDirectory());
                System.out.println("É arquivo regular? " + attrs.isRegularFile());
            } catch (IOException e) {
                System.out.println("Erro ao ler atributos: " + e.getMessage());
            }
        }
    }
}