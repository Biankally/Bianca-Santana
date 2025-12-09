import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public final class Q01 {
    public static void main (String[] args) throws IOException {
        
        try {

            Path pathToFile = Path.of("data/Q1.txt");

            List<String> fileLines = Files.readAllLines(pathToFile);

            System.out.println(fileLines.size());
            
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }
}
