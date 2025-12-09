import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamFileInputStreamRead {
    public static void main(String[] args){

        try {
            File file = new File("data/hello.txt");

            try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))){
                int byteLido;
                while((byteLido = reader.read()) != -1)
                    System.out.print((char)byteLido);
            }                        

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}
