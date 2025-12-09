import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadFileScanner {
    public static void main(String[] args){
        try {
           Path p = Path.of("data/hello.txt");

            try(Scanner reader = new Scanner(p.toFile())){
                while(reader.hasNextLine())
                    System.out.println(reader.nextLine());
            }
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}