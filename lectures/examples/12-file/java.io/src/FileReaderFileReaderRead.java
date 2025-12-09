import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileReaderFileReaderRead {
    public static void main(String[] args){

        try {
            File file = new File("data/hello.txt");

            try(FileReader fileReader = new FileReader(file)){
                while(fileReader.ready())
                    System.out.print((char)fileReader.read());
            }                        
        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}
