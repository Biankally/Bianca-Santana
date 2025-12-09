import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Q04 {
    public static void main(String[] args) {
        
        Path pathtoDir = Path.of("data");
        
        try(DirectoryStream<Path> directories = Files.newDirectoryStream(pathtoDir)){

            for (Path path : directories)
                System.out.println(path.getFileName());

        } catch(IOException e){
            System.out.println("Erro");
        }
    }    
}
