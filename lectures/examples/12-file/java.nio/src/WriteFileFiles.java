import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileFiles {
    public static void main(String[] args) {
        try {

            Path p = Paths.get("data/hello.txt");

            String conteudo = Files.readString(p);
            conteudo += "\nHello, World!";
            
            Files.write(p, conteudo.getBytes());

        } catch(FileNotFoundException fne){
            System.out.print("Arquivo não encontrado");
        } catch(IOException ioe){
            System.out.print("Arquivo não encontrado");
        }
    }
}
