
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        
        System.out.println("1. List Files in Directory");
        Path dataDir = Paths.get("data");
        try (Stream<Path> stream = Files.list(dataDir)) {
            stream.filter(Files::isRegularFile)
                  .map(Path::getFileName)
                  .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao listar arquivos: " + e.getMessage());
        }

        System.out.println("\n2. Check Path Exists");
        Path clientsPath = Paths.get("data/clients.txt");
        System.out.println("clients.txt existe: " + Files.exists(clientsPath));

        System.out.println("\n3. Read File Line by Line");
        try {
            List<String> lines = Files.readAllLines(clientsPath);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler clients.txt: " + e.getMessage());
        }

        System.out.println("\n4. Append Text to File");
        // Simulação de entrada do usuário com um valor fixo, pois a interação via Scanner não é possível no ambiente de execução.
        String newLine = "Cliente D (adicionado)";
        if (!newLine.trim().isEmpty()) {
            try {
                Files.write(clientsPath, List.of(newLine), java.nio.file.StandardOpenOption.APPEND);
                System.out.println("Linha adicionada: " + newLine);
            } catch (IOException e) {
                System.out.println("Erro ao adicionar linha: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhuma linha adicionada.");
        }
        
        System.out.println("\n5. Write Text File");
        Path newClientsPath = Paths.get("clients_new.txt");
        List<String> newContent = List.of("ID,Nome", "1,Fabricio", "2,Santana");
        try {
            Files.write(newClientsPath, newContent);
            System.out.println("Gravação de clients_new.txt bem-sucedida: " + Files.exists(newClientsPath));
            System.out.println("Conteúdo de clients_new.txt:");
            Files.readAllLines(newClientsPath).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao escrever/ler clients_new.txt: " + e.getMessage());
        }

        System.out.println("\n6. Copy File");
        Path backupDir = Paths.get("backup");
        try {
            Files.createDirectories(backupDir);
            Path backupPath = Paths.get("backup/clients_backup.txt");
            Files.copy(clientsPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Cópia de clients.txt para backup/clients_backup.txt concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao copiar arquivo: " + e.getMessage());
        }

        System.out.println("\n7. Delete");
        Path oldClientsPath = Paths.get("backup/old-clients.txt");
        try {
            Files.delete(oldClientsPath);
            System.out.println(oldClientsPath.getFileName() + " removido com sucesso.");
        } catch (java.nio.file.NoSuchFileException e) {
            System.out.println("Erro ao remover: " + oldClientsPath.getFileName() + " não existe.");
        } catch (IOException e) {
            System.out.println("Erro ao remover: Falha de permissão ou outro erro de I/O.");
        }

        System.out.println("\n8. Directory Tree Walk");
        Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);
        try (Stream<Path> walk = Files.walk(dataDir)) {
            System.out.println("Arquivos em 'data' modificados nas últimas 24h:");
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
                        System.out.println(p.getFileName() + " - Tamanho: " + Files.size(p) + " bytes");
                    } catch (IOException e) {
                        System.out.println(p.getFileName() + " - Erro ao obter tamanho.");
                    }
                });
        } catch (IOException e) {
            System.out.println("Erro ao percorrer diretório: " + e.getMessage());
        }

        System.out.println("\n9. File Attributes and Metadata");
        try {
            BasicFileAttributes attrs = Files.readAttributes(clientsPath, BasicFileAttributes.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
            
            System.out.println("Atributos de clients.txt:");
            System.out.println("Tamanho: " + attrs.size() + " bytes");
            System.out.println("Data de Criação: " + formatter.format(attrs.creationTime().toInstant()));
            System.out.println("Última Modificação: " + formatter.format(attrs.lastModifiedTime().toInstant()));
        } catch (IOException e) {
            System.out.println("Erro ao ler atributos do arquivo: " + e.getMessage());
        }
    }
}
