import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeJsonDeserializationApp {

    public static void main(String[] args) {

        try {
            Path path = Path.of("data/employee.json");

            String json = Files.readString(path);

            ObjectMapper mapper = new ObjectMapper();

            Employee e = mapper.readValue(json, Employee.class);

            System.out.println("Objeto desserializado:");
            System.out.println(e);

        } catch (IOException ex) {
            System.out.printf("Erro ao desserializar JSON: %s%n", ex);
        }
    }
}
