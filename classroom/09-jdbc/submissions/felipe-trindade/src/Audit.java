import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    private static final Path LOG = Paths.get("audit.log");
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String msg) {
        String linha = "[" + LocalDateTime.now().format(FMT) + "] " + msg
                + System.lineSeparator();
        try {
            Files.write(LOG,
                    linha.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever audit.log: " + e.getMessage());
        }
    }
}