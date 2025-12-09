import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloStudentFiles {
    public static void main(String[] args){

        Path file = Path.of("data/students.txt");
        //Path file = Path.of(args[0]);

        try{
            System.out.println("Usando java.nio.file.Files para ler arquivos");

            List<String> students = Files.readAllLines(file);

            for (String student : students) {
                System.out.printf("Hello, %s!%n", student);
            }
        } catch(IOException ex){
            System.out.printf("Error: %s%n", ex);
            ex.printStackTrace();
        }
    }   
}
