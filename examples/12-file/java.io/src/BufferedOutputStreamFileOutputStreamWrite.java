import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamFileOutputStreamWrite {
    public static void main(String[] args) {
        try {

            File file = new File("data/hello.txt");

            try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file))){
                output.write("Hello, World".getBytes());
            }
        } catch(FileNotFoundException fne){
            System.out.print("Arquivo não encontrado");
        } catch(IOException ioe){
            System.out.print("Arquivo não encontrado");
        }
    }
}
