import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class FileService {

    public void listFiles(Path directory) throws IOException {
        System.out.println("--- 1. List Files in Directory ---");
        System.out.println("Arquivos no diretório '" + directory.getFileName() + "':");
        try (Stream<Path> stream = Files.list(directory)) {
            stream
                .map(Path::getFileName)
                .forEach(System.out::println);
        }
        System.out.println();
    }

    public void checkPathExists(Path... paths) {
        System.out.println("--- 2. Check Path Exists ---");
        for (Path path : paths) {
            boolean exists = Files.exists(path);
            System.out.println("Caminho '" + path + "' existe? " + exists);
        }
        System.out.println();
    }

    public void readFileLineByLine(Path fileToRead) throws IOException {
        System.out.println("--- 3. Read File Line by Line ---");
        System.out.println("Conteúdo de '" + fileToRead.getFileName() + "' com números de linha:");
        List<String> lines = Files.readAllLines(fileToRead);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
        System.out.println();
    }

    public void appendTextToFile(Path fileToAppend, List<String> newLines) throws IOException {
        System.out.println("--- 4. Append Text to File ---");
        if (!newLines.isEmpty()) {
            Files.write(fileToAppend, newLines, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            System.out.println("Linhas adicionadas com sucesso a '" + fileToAppend.getFileName() + "':");
            newLines.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma linha adicionada.");
        }
        System.out.println();
    }

    public void writeTextFile(Path fileToWrite, List<String> data) throws IOException {
        System.out.println("--- 5. Write Text File ---");
        Files.write(fileToWrite, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Arquivo '" + fileToWrite.getFileName() + "' gravado com sucesso.");

        System.out.println("Conteúdo de '" + fileToWrite.getFileName() + "':");
        List<String> readBack = Files.readAllLines(fileToWrite);
        readBack.forEach(System.out::println);
        System.out.println();
    }

    public void copyFile(Path source, Path destination) throws IOException {
        System.out.println("--- 6. Copy File ---");
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Arquivo '" + source.getFileName() + "' copiado para: " + destination);
        System.out.println();
    }

    public void deleteFile(Path fileToDelete) {
        System.out.println("--- 7. Delete ---");
        System.out.println("Tentando deletar '" + fileToDelete + "'...");
        try {
            Files.delete(fileToDelete);
            System.out.println("Arquivo '" + fileToDelete.getFileName() + "' deletado com sucesso.");
        } catch (NoSuchFileException e) {
            System.out.println("Falha ao deletar: Arquivo não encontrado (NoSuchFileException).");
        } catch (IOException e) {
            System.out.println("Erro de permissão ou outro erro de IO ao deletar: " + e.getMessage());
        }
        System.out.println();
    }

    public void walkDirectoryTree(Path dirToWalk) throws IOException {
        System.out.println("--- 8. Directory Tree Walk ---");
        System.out.println("Arquivos em '" + dirToWalk.getFileName() + "' modificados nas últimas 24h:");
        Instant yesterday = Instant.now().minus(24, ChronoUnit.HOURS);

        try (Stream<Path> walk = Files.walk(dirToWalk)) {
            walk
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        return Files.getLastModifiedTime(path).toInstant().isAfter(yesterday);
                    } catch (IOException e) {
                        return false;
                    }
                })
                .forEach(path -> {
                    try {
                        System.out.printf("  - %s (Tamanho: %d bytes)\n",
                                path.getFileName(), Files.size(path));
                    } catch (IOException e) {
                        System.err.println("Não foi possível ler o tamanho de " + path);
                    }
                });
        }
        System.out.println();
    }

    public void showFileAttributes(Path fileToShow) throws IOException {
        System.out.println("--- 9. File Attributes and Metadata ---");
        System.out.println("Atributos de '" + fileToShow.getFileName() + "':");
        BasicFileAttributes attrs = Files.readAttributes(fileToShow, BasicFileAttributes.class);

        System.out.println("  Tamanho: " + attrs.size() + " bytes");
        System.out.println("  Data de Criação: " + attrs.creationTime());
        System.out.println("  Última Modificação: " + attrs.lastModifiedTime());
        System.out.println("  É diretório? " + attrs.isDirectory());
        System.out.println("  É arquivo regular? " + attrs.isRegularFile());
        System.out.println();
    }
}
