
import java.io.Serializable;

public class Employee implements Serializable {

    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(){
        this("John", "Doe", "123-45-6789");
    }

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getSocialSecurityNumber() { return socialSecurityNumber; }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public double earnings(){
        return 168 * 40;
    }
    
}
