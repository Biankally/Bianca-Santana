import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
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
    public static void main(String[] args) throws IOException {

        Path dir = Paths.get("data");
        Path arq = dir.resolve("clients.txt");
        Path dirBackup = dir.resolve("backup");
        Path arqBackup = dirBackup.resolve("clients_backup.txt");
        Path arqOld = dirBackup.resolve("old-clients.txt");
        Path arqNovo = dir.resolve("clients_new.txt");

        Files.createDirectories(dir);
        Files.createDirectories(dirBackup);

        System.out.println("\n1) Listagem de arquivos em data/");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, p -> Files.isRegularFile(p))) {
            for (Path p : ds) System.out.println("- " + p.getFileName());
        }

        System.out.println("\n2) Verificação de caminho: clients.txt existe?");
        boolean existe = Files.exists(arq);
        System.out.println(existe);

        System.out.println("\n3) Leitura linha a linha de clients.txt");
        if (existe) {
            try (BufferedReader br = Files.newBufferedReader(arq)) {
                String linha;
                int n = 1;
                while ((linha = br.readLine()) != null) {
                    System.out.println("linha " + n + " | " + linha);
                    n++;
                }
            }
        } else {
            System.out.println("sem leitura: arquivo ausente");
        }

        System.out.println("\n4) Acrescentar texto em clients.txt");
        try (Scanner sc = new Scanner(System.in)) {
            List<String> acrescentos = new ArrayList<>();
            System.out.println("digite novas linhas (use 'fim' para encerrar):");
            while (true) {
                String in = sc.nextLine();
                if (in.equalsIgnoreCase("fim")) break;
                acrescentos.add(in);
            }
            if (!acrescentos.isEmpty()) {
                Files.write(arq, acrescentos, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("linhas gravadas:");
                for (String s : acrescentos) System.out.println(s);
                existe = true;
            } else {
                System.out.println("nenhuma alteração feita");
            }
        }

        System.out.println("\n5) Gravação de arquivo: clients_new.txt");
        List<String> dados = List.of(
                "ID;Nome;Status",
                "1;Novo Cliente A;Ativo",
                "2;Novo Cliente B;Inativo"
        );
        Files.write(arqNovo, dados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("ok, arquivo criado/atualizado");
        System.out.println("conteúdo lido de clients_new.txt:");
        System.out.println(Files.readString(arqNovo));

        System.out.println("\n6) Cópia de clients.txt para backup/");
        if (existe) {
            Files.copy(arq, arqBackup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("cópia concluída: " + arq + " -> " + arqBackup);
        } else {
            System.out.println("sem cópia: arquivo ausente");
        }

        System.out.println("\n7) Remoção de backup/old-clients.txt");
        try {
            Files.delete(arqOld);
            System.out.println("removido: " + arqOld);
        } catch (NoSuchFileException e) {
            System.out.println("ausente: " + arqOld);
        } catch (IOException e) {
            System.out.println("sem acesso: " + e.getMessage());
        }

        System.out.println("\n8) Arquivos alterados nas últimas 24h (data/)");
        Instant limite = Instant.now().minus(24, ChronoUnit.HOURS);
        try (Stream<Path> walk = Files.walk(dir)) {
            walk.filter(Files::isRegularFile)
                .filter(p -> {
                    try { return Files.getLastModifiedTime(p).toInstant().isAfter(limite); }
                    catch (IOException ex) { return false; }
                })
                .forEach(p -> {
                    try { System.out.println("-> " + dir.relativize(p) + " (bytes " + Files.size(p) + ")"); }
                    catch (IOException ex) { System.out.println("-> " + dir.relativize(p) + " (tamanho indisponível)"); }
                });
        }

        System.out.println("\n9) Metadados de clients.txt");
        if (existe) {
            BasicFileAttributes a = Files.readAttributes(arq, BasicFileAttributes.class);
            System.out.println("tamanho=" + a.size());
            System.out.println("criado=" + a.creationTime());
            System.out.println("modificado=" + a.lastModifiedTime());
        } else {
            System.out.println("sem metadados: arquivo ausente");
        }
    }
}