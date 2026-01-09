import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class FileWriterWrite {
    public static void main(String[] args){

        try {
            File file = new File("data/hello.txt");

            try(FileWriter fileWriter = new FileWriter(file)){
                fileWriter.write("Hello, World");
              
            }                        
        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}
