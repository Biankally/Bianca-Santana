import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class AuditLogger {

    private static final Path LOG_PATH = Path.of("audit.log");

    public static void log(String acao) {
        String registro = LocalDateTime.now() + " - " + acao + System.lineSeparator();
        try {
            Files.write(LOG_PATH,
                    registro.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao registrar log.");
        }
    }
}

