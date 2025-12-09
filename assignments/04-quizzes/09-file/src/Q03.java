import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Q03 {
    public static void main(String[] args) {
    
        try{
            Path pathToInputFile = Path.of("data/Q3.txt");
            Path pathToOutPutFile = Path.of("data/Q3_NEW.txt");
    
            Files.copy(pathToInputFile, pathToOutPutFile, StandardCopyOption.REPLACE_EXISTING);

            if (Files.isSameFile(pathToInputFile, pathToOutPutFile))
                System.out.println("São o mesmo arquivo");
            else
                System.out.println("São arquivos diferentes");

        } catch(IOException e){
            System.out.printf("Erro %s%n:", e);
        }
    }
}
