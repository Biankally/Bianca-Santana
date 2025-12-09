import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerenciadorDeLog {

    private static final Path ARQUIVO_LOG = Path.of("auditoria.log");
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void registrar(String operacao, String detalhes) {
        String horario = LocalDateTime.now().format(FORMATO);
        String entradaLog = String.format("[%s] [%s] %s%n", horario, operacao, detalhes);

        try {
            Files.writeString(ARQUIVO_LOG, entradaLog, 
                              StandardOpenOption.CREATE, 
                              StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("ERRO: Não foi possível escrever no arquivo de log. Detalhe: " + e.getMessage());
        }
    }
}