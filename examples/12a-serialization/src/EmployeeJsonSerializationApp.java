import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeJsonSerializationApp {
    
    public static void main(String[] args) {
        Employee e = new Employee("Fabrico", "Santana", "123456" );

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("data/employee.json"), e);

        } catch (IOException ex) {
            System.out.printf("Erro ao serializar objeto: %s%n", ex);
        }
    }
    
}
