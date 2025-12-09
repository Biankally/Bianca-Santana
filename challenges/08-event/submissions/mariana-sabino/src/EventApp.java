import java.util.ArrayList;
import java.util.List;

abstract class Participant {   // CORRIGIDO: agora é abstract
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

    public String getEmail(){
        return email;
    }

    public abstract String describeRole();  
}

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
        return "Estudante do curso " + course + ", semestre " + currentSemester;
    }

    @Override
    public String toString() {
        return "Estudante {" +
               "id='" + getId() + '\'' +
               ", nome='" + getFullName() + '\'' +
               ", email='" + getEmail() + '\'' +
               ", curso='" + course + '\'' +
               ", semestre=" + currentSemester +
               '}';
    }
}

class ProfessionalParticipant extends Participant {
    private final String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização " + organization;   // CORRIGIDO
    }

    @Override
    public String toString() {
        return "Profissional {" +
               "id='" + getId() + '\'' +
               ", nome='" + getFullName() + '\'' +
               ", email='" + getEmail() + '\'' +
               ", organização='" + organization + '\'' +
               '}';
    }
}

public class EventApp {
    public static void main (String[] args) {
        List<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("stu-123", "Mariana Sabino", "mariana@gmail.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("stu-456", "Eduardo Novais", "edu@gmail.com", "Ciência da Computação", 3));

        participants.add(new ProfessionalParticipant("pro-789", "Fabricio Santana", "fabricio@gmail.com", "IDP"));
        participants.add(new ProfessionalParticipant("pro-101", "Felipe Dias", "felipe@example.com", "IDP"));

        System.out.println("Participantes cadastrados");
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println(p.describeRole());
        }
    }
}
