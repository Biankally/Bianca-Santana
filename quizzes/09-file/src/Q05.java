import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Q05 {
    public static void main(String[] args) {
        Path pathToFile = Path.of("data/Q05.txt");

        try {
            
            if (Files.notExists(pathToFile)) {
                Files.createFile(pathToFile);
                Files.writeString(pathToFile, "ID;NOME\n", StandardOpenOption.APPEND);
            }

            Files.writeString(pathToFile, "1;Fabricio\n", StandardOpenOption.APPEND);
            Files.writeString(pathToFile, "2;João\n", StandardOpenOption.APPEND);
            Files.writeString(pathToFile, "3;Maria\n", StandardOpenOption.APPEND);
            Files.writeString(pathToFile, "4;José\n", StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.printf("Erro: %s%n", e);
        }
    }
}
