import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class FileApp {

    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        Path basePath = currentRelativePath.toAbsolutePath();

        final Path caminhoDiretorioData = basePath.resolve("data");
        final Path caminhoArquivoClientes = caminhoDiretorioData.resolve("clients.txt");
        final Path caminhoDiretorioBackup = basePath.resolve("backup");

        System.out.println("--- INICIANDO MANIPULACAO DE ARQUIVOS (java.nio) ---");

        try {
            Files.createDirectories(caminhoDiretorioData);
            Files.createDirectories(caminhoDiretorioBackup);

            if (Files.notExists(caminhoArquivoClientes)) {
                System.out.println("\n[SETUP] Criando arquivo clients.txt inicial em " + caminhoDiretorioData.toAbsolutePath());
                List<String> dadosIniciais = List.of(
                    "1. Joao Silva - Marketing",
                    "2. Maria Santos - Vendas",
                    "3. Pedro Costa - TI"
                );
                Files.write(caminhoArquivoClientes, dadosIniciais, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.err.println("Erro critico de setup: Falha ao criar diretorios ou arquivo: " + e.getMessage());
            return;
        }

        System.out.println("\n=======================================================");
        System.out.println("1. List Files in Directory: " + caminhoDiretorioData.toAbsolutePath());
        System.out.println("=======================================================");
        try (Stream<Path> streamDeArquivos = Files.list(caminhoDiretorioData)) {
            streamDeArquivos.forEach(path -> System.out.println("  - " + path.getFileName()));
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("2. Check Path Exists: clients.txt");
        System.out.println("=======================================================");
        boolean arquivoExiste = Files.exists(caminhoArquivoClientes);
        System.out.println("O arquivo clients.txt existe? " + arquivoExiste);

        if (!arquivoExiste) {
            System.out.println("Nao podemos continuar. clients.txt nao foi encontrado.");
            return;
        }

        System.out.println("\n=======================================================");
        System.out.println("3. Read File Line by Line: clients.txt");
        System.out.println("=======================================================");
        try (Stream<String> linhas = Files.lines(caminhoArquivoClientes, StandardCharsets.UTF_8)) {
            final int[] contador = {1};
            linhas.forEach(linha -> {
                System.out.printf("  [%d] %s%n", contador[0]++, linha);
            });
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo linha por linha: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("4. Append Text to File: clients.txt");
        System.out.println("=======================================================");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Por favor, digite as novas linhas (digite 'FIM' para finalizar):");

            String entradaUsuario;
            final StringBuilder linhasAdicionadas = new StringBuilder();

            int linhaContador = 1;
            while (true) {
                System.out.print("Linha " + linhaContador + ": ");
                entradaUsuario = reader.readLine();

                if (entradaUsuario == null || entradaUsuario.trim().equalsIgnoreCase("FIM")) {
                    break;
                }

                linhasAdicionadas.append(entradaUsuario).append("\n");
                linhaContador++;
            }

            if (linhasAdicionadas.length() > 0) {
                String textoParaGravar = linhasAdicionadas.toString().trim();
                List<String> novasLinhas = List.of(textoParaGravar.split("\n"));

                Files.write(
                    caminhoArquivoClientes,
                    novasLinhas,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND
                );

                System.out.println("\nLinhas Adicionadas ao Arquivo (Resultado da Operacao):");
                novasLinhas.forEach(linha -> System.out.println("  > " + linha));
            } else {
                System.out.println("Nenhuma linha adicionada.");
            }

        } catch (IOException e) {
            System.err.println("Erro durante a adicao de texto: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("5. Write Text File: clients_new.txt");
        System.out.println("=======================================================");

        final Path caminhoNovoClientes = caminhoDiretorioData.resolve("clients_new.txt");
        final List<String> dadosNovos = List.of(
            "ID: 100 | Nome: Alice | Status: Ativo",
            "ID: 101 | Nome: Bruno | Status: Pendente"
        );

        try {
            Files.write(caminhoNovoClientes, dadosNovos, StandardCharsets.UTF_8);
            System.out.println("Sucesso na gravacao: " + caminhoNovoClientes.getFileName() + " criado com sucesso.");

            System.out.println("\nConteudo de clients_new.txt (Confirmacao de Leitura):");
            Files.readAllLines(caminhoNovoClientes, StandardCharsets.UTF_8)
                 .forEach(linha -> System.out.println("  " + linha));

        } catch (IOException e) {
            System.err.println("Erro ao escrever ou ler clients_new.txt: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("6. Copy File: clients.txt para backup/clients_backup.txt");
        System.out.println("=======================================================");

        final Path destinoBackup = caminhoDiretorioBackup.resolve("clients_backup.txt");

        try {
            Files.copy(
                caminhoArquivoClientes,
                destinoBackup,
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Copia realizada com sucesso para: " + destinoBackup.getFileName());
        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("7. Delete: Tentativa de remover backup/old-clients.txt");
        System.out.println("=======================================================");

        final Path arquivoParaRemover = caminhoDiretorioBackup.resolve("old-clients.txt");

        try {
            if (Files.notExists(arquivoParaRemover)) {
                Files.createFile(arquivoParaRemover);
                System.out.println("[INFO] Arquivo temporario 'old-clients.txt' criado para demonstracao.");
            }

            Files.delete(arquivoParaRemover);
            System.out.println("  -> Sucesso: Arquivo removido em: " + arquivoParaRemover.getFileName());

            Files.delete(arquivoParaRemover);

        } catch (NoSuchFileException e) {

            System.out.println("  -> Tratamento: Arquivo nao encontrado (NoSuchFileException): " + e.getFile());
        } catch (DirectoryNotEmptyException e) {
            System.err.println("  -> Falha de Permissao/Diretorio: O arquivo e um diretorio nao vazio.");
        } catch (IOException e) {

            System.err.println("  -> Falha de Permissao: Falha na operacao de exclusao devido a permissoes ou outro erro de I/O.");
        }

        System.out.println("\n=======================================================");
        System.out.println("8. Directory Tree Walk: Arquivos em 'data' (modificados nas ultimas 24h)");
        System.out.println("=======================================================");

        final long vinteQuatroHorasAtras = Instant.now().minus(24, ChronoUnit.HOURS).toEpochMilli();

        try (Stream<Path> walkStream = Files.walk(caminhoDiretorioData)) {
            walkStream
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try {
                        FileTime ultimaModificacao = Files.getLastModifiedTime(path);
                        return ultimaModificacao.toMillis() > vinteQuatroHorasAtras;
                    } catch (IOException e) {
                        System.err.println("[ERRO NO WALK] Nao foi possivel obter o tempo de modificacao de " + path.getFileName());
                        return false;
                    }
                })
                .forEach(path -> {
                    try {
                        long tamanhoBytes = Files.size(path);
                        System.out.printf("  [RECENTE] %s | Tamanho: %.2f KB%n",
                                          path.getFileName(),
                                          (double) tamanhoBytes / 1024);
                    } catch (IOException e) {
                        System.err.println("Erro ao obter tamanho do arquivo: " + path.getFileName());
                    }
                });
        } catch (IOException e) {
            System.err.println("Erro durante o percurso da arvore de diretorios: " + e.getMessage());
        }

        System.out.println("\n=======================================================");
        System.out.println("9. File Attributes and Metadata: clients.txt");
        System.out.println("=======================================================");

        try {
            BasicFileAttributes atributosBasicos = Files.readAttributes(
                caminhoArquivoClientes,
                BasicFileAttributes.class
            );

            System.out.println("  - Tamanho (Bytes): " + atributosBasicos.size());

            System.out.println("  - Tempo de Criacao: " + Instant.ofEpochMilli(atributosBasicos.creationTime().toMillis()));
            System.out.println("  - Ultima Modificacao: " + Instant.ofEpochMilli(atributosBasicos.lastModifiedTime().toMillis()));
            System.out.println("  - E um Diretorio? " + atributosBasicos.isDirectory());

        } catch (IOException e) {
            System.err.println("Erro ao ler atributos do arquivo clients.txt: " + e.getMessage());
        }

        System.out.println("\n--- FIM DAS OPERACOES ---");
    }
}
