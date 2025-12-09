import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Q02 {
    public static void main(String[] args) {

        Path fileToPath = Path.of("data/Q2.txt");

        try(BufferedReader bufferedReader = Files.newBufferedReader(fileToPath)){

            int charRead;

            while ((charRead = bufferedReader.read()) != -1) {
                System.out.print((char)charRead);
                break;
            }
            
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
}
