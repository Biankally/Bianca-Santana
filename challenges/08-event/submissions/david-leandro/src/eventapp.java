import java.util.ArrayList;
import java.util.List;

// Classe abstrata base
abstract class Participant {
    private String id;
    private String fullName;
    private String email;

    public Participant(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public abstract String describeRole();

    @Override
    public String toString() {
        return "Participant {" +
                "id='" + id + '\'' +
                ", nome='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

// Subclasse: Estudante
class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {
        return "Estudante do curso de " + course + " no semestre " + currentSemester + ".";
    }

    @Override
    public String toString() {
        return "StudentParticipant {" +
                "id='" + getId() + '\'' +
                ", nome='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", curso='" + course + '\'' +
                ", semestre=" + currentSemester +
                '}';
    }
}

// Subclasse: Profissional
class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização: " + organization + ".";
    }

    @Override
    public String toString() {
        return "ProfessionalParticipant {" +
                "id='" + getId() + '\'' +
                ", nome='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", organização='" + organization + '\'' +
                '}';
    }
}

// Classe principal
public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        StudentParticipant student1 = new StudentParticipant("S001", "Maria Silva", "maria@idp.edu", "Engenharia de Software", 3);
        StudentParticipant student2 = new StudentParticipant("S002", "Bruno Souza", "bruno@idp.edu", "Ciência da Computação", 5);

        ProfessionalParticipant professional1 = new ProfessionalParticipant("P001", "Ana Costa", "ana@empresa.com", "Tech Solutions");
        ProfessionalParticipant professional2 = new ProfessionalParticipant("P002", "Carlos Lima", "carlos@startup.com", "InovaTech");

        participants.add(student1);
        participants.add(student2);
        participants.add(professional1);
        participants.add(professional2);

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("--------------------------------");
        }
    }
}
