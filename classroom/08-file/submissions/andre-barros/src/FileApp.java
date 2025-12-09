import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) {
        Path pastaDados = Paths.get("data");
        Path arquivoClientes = pastaDados.resolve("clients.txt");
        Path pastaBackup = Paths.get("backup");
        Path arquivoBackup = pastaBackup.resolve("clients_backup.txt");
        Path backupAntigo = pastaBackup.resolve("old-clients.txt");
        Path arquivoNovo = pastaDados.resolve("clients_new.txt");

        try {
            if (Files.notExists(pastaDados)) Files.createDirectories(pastaDados);
            if (Files.notExists(pastaBackup)) Files.createDirectories(pastaBackup);
        } catch (IOException e) {
            System.out.println("Falha ao preparar pastas");
            return;
        }

        System.out.println("List Files in Directory:");
        try (Stream<Path> s = Files.list(pastaDados)) {
            s.forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {}

        System.out.println("\nCheck Path Exists:");
        boolean temClientes = Files.exists(arquivoClientes);
        System.out.println(temClientes);

        if (!temClientes) {
            try {
                List<String> base = List.of("id,nome", "1,Ana", "2,Beto", "3,Caio");
                Files.write(arquivoClientes, base, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {}
        }

        System.out.println("\nRead File Line by Line:");
        try (Stream<String> linhas = Files.lines(arquivoClientes, StandardCharsets.UTF_8)) {
            final int[] n = {1};
            linhas.forEach(l -> System.out.println(n[0]++ + ": " + l));
        } catch (IOException e) {}

        System.out.println("\nAppend Text to File:");
        Scanner teclado = new Scanner(System.in, StandardCharsets.UTF_8);
        List<String> novasLinhas = new ArrayList<>();
        while (true) {
            String l = teclado.nextLine();
            if (l.isBlank()) break;
            novasLinhas.add(l);
        }
        try {
            if (!novasLinhas.isEmpty()) {
                Files.write(arquivoClientes, novasLinhas, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                novasLinhas.forEach(System.out::println);
            }
        } catch (IOException e) {}

        System.out.println("\nWrite Text File:");
        List<String> conteudoNovo = List.of(
                "id;nome;email",
                "10;Dora;dora@example.com",
                "11;Enzo;enzo@example.com",
                "12;Fabi;fabi@example.com"
        );
        try {
            Files.write(arquivoNovo, conteudoNovo, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            boolean ok = Files.exists(arquivoNovo);
            if (ok) {
                try (Stream<String> l = Files.lines(arquivoNovo, StandardCharsets.UTF_8)) {
                    l.forEach(System.out::println);
                }
            }
        } catch (IOException e) {}

        System.out.println("\nCopy File:");
        try {
            Files.copy(arquivoClientes, arquivoBackup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(arquivoBackup.toAbsolutePath());
        } catch (IOException e) {}

        System.out.println("\nDelete:");
        try {
            Files.delete(backupAntigo);
            System.out.println("apagado");
        } catch (NoSuchFileException e) {
            System.out.println("ausente");
        } catch (IOException e) {
            System.out.println("sem permissão ou falha");
        }

        System.out.println("\nDirectory Tree Walk:");
        Instant limite = Instant.now().minus(24, ChronoUnit.HOURS);
        try (Stream<Path> w = Files.walk(pastaDados)) {
            w.filter(Files::isRegularFile).forEach(p -> {
                try {
                    if (Files.getLastModifiedTime(p).toInstant().isAfter(limite)) {
                        System.out.println(p.getFileName() + " - " + Files.size(p) + " bytes");
                    }
                } catch (IOException e) {}
            });
        } catch (IOException e) {}

        System.out.println("\nFile Attributes and Metadata:");
        try {
            BasicFileAttributes a = Files.readAttributes(arquivoClientes, BasicFileAttributes.class);
            System.out.println("tamanho=" + a.size());
            System.out.println("criacao=" + a.creationTime());
            System.out.println("modificacao=" + a.lastModifiedTime());
        } catch (IOException e) {}
    }
}
