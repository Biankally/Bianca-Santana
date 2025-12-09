import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        StudentParticipant student1 = new StudentParticipant("S001", "Ana Silva", "ana.silva@email.com", "Engenharia de Software", 5);
        StudentParticipant student2 = new StudentParticipant("S002", "Bruno Costa", "bruno.costa@email.com", "Ciência da Computação", 3);

        ProfessionalParticipant professional1 = new ProfessionalParticipant("P001", "Carlos Mendes", "carlos.mendes@empresa.com", "Tech Solutions Inc.");
        ProfessionalParticipant professional2 = new ProfessionalParticipant("P002", "Diana Lima", "diana.lima@empresa.com", "Global Innovations Ltd.");

        participants.add(student1);
        participants.add(student2);
        participants.add(professional1);
        participants.add(professional2);

        System.out.println("--- Lista de Participantes da IDP Tech Week ---");
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());

            if (p instanceof StudentParticipant) {
                StudentParticipant student = (StudentParticipant) p;
                System.out.println("Curso: " + student.getCourse() + ", Semestre: " + student.getCurrentSemester());
            } else if (p instanceof ProfessionalParticipant) {
                ProfessionalParticipant professional = (ProfessionalParticipant) p;
                System.out.println("Organização: " + professional.getOrganization());
            }

            System.out.println("------------------------------------------");
        }
    }
}