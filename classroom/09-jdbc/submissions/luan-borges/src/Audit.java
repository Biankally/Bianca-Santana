import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Audit {
    
    private static final String ARQUIVO_LOG = "audit.log";

    public static void registrarLog(String mensagem) {
        String entradaLog = LocalDateTime.now() + " - " + mensagem + "\n";
        try {
            Files.write(
                Paths.get(ARQUIVO_LOG), 
                entradaLog.getBytes(), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Erro de auditoria: " + e.getMessage());
        }
    }
}
