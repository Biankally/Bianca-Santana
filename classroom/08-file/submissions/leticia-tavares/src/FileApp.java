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
import java.util.List;
import java.util.stream.Stream;

public class FileApp {
    public static void main(String[] args) throws IOException {
        
        Path dirDados = Paths.get("data");
        Path arqClientes = dirDados.resolve("clients.txt");
        Path dirBackup = Paths.get("backup");
        Path arqAntigo = dirBackup.resolve("old-clients.txt");

        Files.createDirectories(dirDados);
        Files.createDirectories(dirBackup);

        String conteudoInicial = "1: Maria Silva\n2: João Santos\n3: Pedro Oliveira\n";
        Files.writeString(arqClientes, conteudoInicial, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        
        Files.writeString(dirDados.resolve("settings.cfg"), "config_data", StandardOpenOption.CREATE);
        Path arqRecente = dirDados.resolve("recent_log.txt");
        Files.writeString(arqRecente, "Log recente para filtro de tempo.", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        Files.setLastModifiedTime(arqRecente, java.nio.file.attribute.FileTime.from(Instant.now().minus(1, ChronoUnit.HOURS)));

        Files.writeString(arqAntigo, "Conteúdo a ser removido no teste.", StandardOpenOption.CREATE);

        System.out.println("1. List Files in Directory: Lista de arquivos no diretório 'data'");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirDados)) {
            System.out.println("Arquivos encontrados:");
            for (Path p : stream) {
                System.out.println("-> " + p.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Exceção ao listar arquivos: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("2. Check Path Exists: Verificação de existência do arquivo 'clients.txt'");
        System.out.println("O arquivo existe? " + Files.exists(arqClientes));

        System.out.println("\n------------------------------------------------\n");

        System.out.println("3. Read File Line by Line: Leitura e numeração do arquivo de clientes");
        if (Files.exists(arqClientes)) {
            try {
                List<String> linhas = Files.readAllLines(arqClientes);
                int indice = 1;
                for (String l : linhas) {
                    System.out.println("Linha " + indice + ": " + l);
                    indice++;
                }
            } catch (IOException e) {
                System.out.println("Exceção ao ler o arquivo: " + e.getMessage());
            }
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("4. Append Text to File: Adicionar novas linhas ao arquivo 'clients.txt'");
        String novoConteudo = "4: Ana Souza (Adicionado)\n5: Carlos Lima (Adicionado)\n";

        try {
            Files.writeString(arqClientes, novoConteudo, StandardOpenOption.APPEND);
            System.out.println("Linhas recém-adicionadas (simulando saída):");
            System.out.print(novoConteudo);

        } catch (IOException e) {
            System.out.println("Exceção ao adicionar conteúdo: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("5. Write Text File: Criação e gravação do arquivo 'clients_new.txt'");
        Path novoArq = dirDados.resolve("clients_new.txt");
        try {
            String dadosFormatados = "ID;Nome;Status\n10;Novo Cliente A;Ativo\n20;Novo Cliente B;Inativo\n";
            Files.writeString(novoArq, dadosFormatados);
            System.out.println("Gravação concluída com sucesso.");
            System.out.println("\nConteúdo do arquivo recém-escrito:");
            Files.readAllLines(novoArq).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Exceção ao manipular o novo arquivo: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("6. Copy File: Duplicação de arquivo com REPLACE_EXISTING");
        try {
            Path destino = dirBackup.resolve("clients_backup.txt");
            Files.copy(arqClientes, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Cópia de 'clients.txt' criada com sucesso em: " + destino.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Exceção ao copiar arquivo: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("7. Delete: Tentativa de remoção de 'backup/old-clients.txt'");
        try {
            Files.delete(arqAntigo);
            System.out.println("Primeira remoção bem-sucedida.");
            // Tentativa de remover novamente para testar a exceção
            Files.delete(arqAntigo);
        } catch (NoSuchFileException e) {
            System.out.println("Falha esperada: Arquivo não existe mais (NoSuchFileException capturada).");
        } catch (IOException e) {
            System.out.println("Falha de permissão ou I/O: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("8. Directory Tree Walk: Listar arquivos recentes (< 24h) em 'data'");
        try (Stream<Path> walk = Files.walk(dirDados)) {
            Instant limite = Instant.now().minus(24, ChronoUnit.HOURS);
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
                        System.out.println("Encontrado: " + p.getFileName() + " | Tamanho: " + Files.size(p) + " bytes");
                    } catch (IOException e) {
                        System.out.println("Erro ao obter tamanho do arquivo.");
                    }
                });
        } catch (IOException e) {
            System.out.println("Exceção ao percorrer diretórios: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------\n");

        System.out.println("9. File Attributes and Metadata: Atributos básicos de 'clients.txt'");
        try {
            BasicFileAttributes att = Files.readAttributes(arqClientes, BasicFileAttributes.class);
            System.out.println("-> Tamanho: " + att.size() + " bytes");
            System.out.println("-> Data de Criação: " + att.creationTime());
            System.out.println("-> Última Modificação: " + att.lastModifiedTime());
        } catch (IOException e) {
            System.out.println("Exceção ao ler atributos: " + e.getMessage());
        }
        
        System.out.println("\n--- Fim da Execução das Operações ---");
    }
}