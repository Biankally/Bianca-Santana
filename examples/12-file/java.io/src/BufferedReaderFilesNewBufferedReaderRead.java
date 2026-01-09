import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedReaderFilesNewBufferedReaderRead {
    public static void main(String[] args){
        try {
            Path p = Path.of("hello.txt");

            try(BufferedReader reader = Files.newBufferedReader(p)){
                while(reader.ready())
                    System.out.print(reader.readLine());
            }                        

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}