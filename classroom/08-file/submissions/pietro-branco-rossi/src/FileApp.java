
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class FileApp {

    public static void main(String[] args) {

        // Definição do arquivo:

        Path basePath = Path.of("classroom/08-file");

        Path dirData = basePath.resolve("data");
        Path fileClients = dirData.resolve("clients.txt");
        Path fileClientsBackup = basePath.resolve("backup/clients_backup.txt");
        Path newClientsFile = dirData.resolve("clients_new.txt");
        Path oldClientsFile = basePath.resolve("old-clients.txt");

        // 1. Liste todos os nomes de arquivos existentes no diretório

        try (Stream<Path> stream = Files.list(dirData)){
            List<Path> listaDeArquivos = stream.toList();

            for (int i = 0; i < listaDeArquivos.size(); i++) {
                Path arquivoAtual = listaDeArquivos.get(i);
                System.out.println(listaDeArquivos.get(i).getFileName());
            
                System.out.println(i + " -> " + arquivoAtual.getFileName());
            }
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }

        // 2. Check Path Exists

        boolean existe = Files.exists(fileClients);
        System.out.println("O arquivo clients.txt existe? " + existe);

        // 3. Read File Line by Line

            try{
                List<String> linhas = Files.readAllLines(fileClients);
                for (int i = 0; i < linhas.size(); i++) {
                    System.out.println((i + 1) + ": " + linhas.get(i));
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }

        // 4. Append Text to File

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o texto para adicionar ao arquivo clients.txt (ou 'sair' para terminar):");
            StringBuilder novasLinhas = new StringBuilder();
            while (true) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("sair")) {
                    break;
                }
                novasLinhas.append(linha).append(System.lineSeparator());
            }
            Files.writeString(fileClients, novasLinhas.toString(), java.nio.file.StandardOpenOption.APPEND);
            System.out.println("Novas linhas adicionadas ao arquivo clients.txt:");
            System.out.println(novasLinhas.toString());
        } catch (IOException e) {
            System.err.println("Erro ao adicionar texto ao arquivo: " + e.getMessage());
        }

        // 5. Write Text File

        try {
            List<String> dadosFormatados = List.of("ID=1, Nome=Pietro", "ID=2, Nome=Rossi");

            Files.write(newClientsFile, dadosFormatados, StandardCharsets.UTF_8);
            System.out.println(" Arquivo 'clients_new.txt' criado com sucesso.");
            
            System.out.println("Conteúdo do arquivo 'clients_new.txt':");
            List<String> conteudo = Files.readAllLines(newClientsFile, StandardCharsets.UTF_8);
            System.out.println(conteudo);
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo 'clients_new.txt': " + e.getMessage());
        }

        // 6. Copy File

        try {
            Files.copy(fileClients, fileClientsBackup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado para " + fileClientsBackup);
        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }

        // 7. Delete File

        try {
            Files.delete(oldClientsFile);
            System.out.println("Arquivo deletado com sucesso: " + oldClientsFile);
        } catch (NoSuchFileException e) {
            System.err.println("Arquivo não encontrado (esperado se não existir): " + e.getFile());
        } catch (IOException e) {
            System.err.println("Erro de permissão ou I/O: " + e.getMessage());
        }

        // 8. Directory Tree Walk

        try (Stream<Path> walk = Files.walk(dirData)) {
            Instant twentyFourHoursAgo = Instant.now().minus(24, ChronoUnit.HOURS);

            walk.filter(Files::isRegularFile) // Apenas arquivos, ignora diretórios
                .filter(p -> {
                    try {
                        return Files.getLastModifiedTime(p).toInstant().isAfter(twentyFourHoursAgo);
                    } catch (IOException e) {
                        System.err.println("Erro ao ler data de: " + p);
                        return false;
                    }
                })
                .forEach(p -> {
                    try {
                        System.out.println("Arquivo: " + p.getFileName() + " | Tamanho: " + Files.size(p) + " bytes");
                    } catch (IOException e) {
                        System.err.println("Erro ao ler tamanho: " + p);
                    }
                });

        } catch (IOException e) {
            System.err.println("Erro ao percorrer diretório: " + e.getMessage());
        }

        // 9. File Attributes and Metadata

        try {
            BasicFileAttributes attrs = Files.readAttributes(fileClients, BasicFileAttributes.class);
            
            System.out.println("Arquivo: " + fileClients.getFileName());
            System.out.println("Tamanho: " + attrs.size() + " bytes");
            System.out.println("Data de Criação: " + attrs.creationTime());
            System.out.println("Última Modificação: " + attrs.lastModifiedTime());
            System.out.println("É diretório? " + attrs.isDirectory());
            
        } catch (IOException e) {
            System.err.println("Erro ao ler atributos: " + e.getMessage());
        }

    }

}

/*

    4. Append Text to File: leia entrada do usuário e acrescente novas linhas ao final arquivo clients.txt e mostre apenas as linhas adicionadas.
    5. Write Text File: escreva dados formatados no novo arquivo clients_new.txt, confirme o sucesso da gravação e em seguida leia o arquivo para exibir o conteúdo.
    7. Delete: tente remover backup/old-clients.txt com Files.delete, capturando NoSuchFileException para relatar ausência versus falha de permissão.
    8. Directory Tree Walk: percorra recursivamente data com Files.walk, filtrando apenas arquivos modificados nas últimas 24h e imprimindo o tamanho com Files.size.
    9. File Attributes and Metadata: leia atributos básicos do arquivo clients.txt via Files.readAttributes (tamanho, criação, última modificação) e exiba-os formatados.

*/
