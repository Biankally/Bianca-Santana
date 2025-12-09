import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderFileReaderRead {
    public static void main(String[] args){
        try {
           File file = new File("data/hello.txt");

            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                while(reader.ready())
                    System.out.println(reader.readLine());
            }                        

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}
