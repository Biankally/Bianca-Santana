import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) throws IOException {

        System.out.println("Configurando ambiente inicial...");
        Path dataDir = Paths.get("data");
        Path backupDir = Paths.get("backup");
        Files.createDirectories(dataDir);
        Files.createDirectories(backupDir);

        Path clientsTxt = dataDir.resolve("clients.txt");
        List<String> initialClients = List.of(
                "1,Alice,alice@example.com",
                "2,Bob,bob@example.com",
                "3,Charlie,charlie@example.com"
        );
        Files.write(clientsTxt, initialClients, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        Path reportPdf = dataDir.resolve("report.pdf");
        Files.writeString(reportPdf, "Este é um relatório falso.", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Ambiente configurado.\n");

        FileService fileService = new FileService();

        try (Scanner scanner = new Scanner(System.in)) {

            fileService.listFiles(dataDir);

            Path nonexistent = dataDir.resolve("nonexistent.txt");
            fileService.checkPathExists(clientsTxt, nonexistent);

            fileService.readFileLineByLine(clientsTxt);

            System.out.println("--- 4. Append Text to File (Entrada) ---");
            System.out.println("Digite novas linhas para adicionar a 'clients.txt' (digite 'sair' para terminar):");
            List<String> newLines = new ArrayList<>();
            while (true) {
                String input = scanner.nextLine();
                if ("sair".equalsIgnoreCase(input)) {
                    break;
                }
                newLines.add(input);
            }
            fileService.appendTextToFile(clientsTxt, newLines);

            Path clientsNewPath = dataDir.resolve("clients_new.txt");
            List<String> dataToWrite = List.of(
                    "ID: 1, Nome: Ana, Status: Ativo",
                    "ID: 2, Nome: Bruno, Status: Inativo"
            );
            fileService.writeTextFile(clientsNewPath, dataToWrite);

            Path backupPath = backupDir.resolve("clients_backup.txt");
            fileService.copyFile(clientsTxt, backupPath);

            Path oldClientsPath = backupDir.resolve("old-clients.txt");
            fileService.deleteFile(oldClientsPath);

            fileService.walkDirectoryTree(dataDir);

            fileService.showFileAttributes(clientsTxt);

        }

        System.out.println("--- Demonstração FileApp (Refatorada) concluída ---");
    }
}

