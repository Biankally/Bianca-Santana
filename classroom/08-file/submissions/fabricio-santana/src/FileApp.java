import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileApp {
    public static void main(String[] args) {
        Path dataDirectory = Paths.get("classroom", "08-file", "data");
        Path clientsFile = dataDirectory.resolve("clients.txt");

        System.out.println("List Files in Directory");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDirectory)) {
            boolean isEmpty = true;
            for (Path entry : stream) {
                isEmpty = false;
                System.out.println(" - " + entry.getFileName());
            }
            if (isEmpty) {
                System.out.println(" (diretório vazio)");
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar diretório: " + e.getMessage());
        }

        System.out.println("Check Path Exists");
        System.out.println(Files.exists(clientsFile));

        System.out.println("Read File Line by Line");
        try {
            List<String> lines = Files.readAllLines(clientsFile, StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {
                System.out.printf("%d -> %s%n", i + 1, lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        System.out.println("Append Text to File");
        List<String> appendedLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("Digite novas linhas (linha vazia encerra):");
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                if (inputLine.isBlank()) {
                    break;
                }
                appendedLines.add(inputLine);
            }
        }
        if (appendedLines.isEmpty()) {
            System.out.println("Nenhuma linha adicionada.");
        } else {
            try {
                Files.write(clientsFile, appendedLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                System.out.println("Linhas adicionadas:");
                for (String line : appendedLines) {
                    System.out.println(" + " + line);
                }
            } catch (IOException e) {
                System.out.println("Erro ao adicionar linhas: " + e.getMessage());
            }
        }

        System.out.println("Write Text File");
        Path newClientsFile = dataDirectory.resolve("clients_new.txt");
        List<String> newFileContent = Arrays.asList(
            "id,nome,email,saldo",
            "1,Ana Silva,ana.silva@example.com,1250.75",
            "2,Caio Souza,caio.souza@example.com,842.10",
            "3,Fernanda Lima,fernanda.lima@example.com,990.00"
        );
        try {
            Files.write(
                newClientsFile,
                newFileContent,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Arquivo gravado: " + newClientsFile.toAbsolutePath());
            List<String> confirmation = Files.readAllLines(newClientsFile, StandardCharsets.UTF_8);
            for (String line : confirmation) {
                System.out.println(" > " + line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}
