import java.util.ArrayList;
import java.util.List;

public class EventApp {

    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        StudentParticipant student1 = new StudentParticipant("S001", "Marcelo Silva do Nascimento", "marcelo_sn3@hotmail.com", "Ciência da Computação", 4);
        StudentParticipant student2 = new StudentParticipant("S002", "Bruno Pinho Cardoso", "bruno.pinho@gmail.com", "Engenharia de Software", 4);
        
        ProfessionalParticipant professional1 = new ProfessionalParticipant("P001", "Fabricio Santana", "fabricio.santana@idp.edu.br", "IDP");
        ProfessionalParticipant professional2 = new ProfessionalParticipant("P002", "Paulo Peres", "paulo.peres@idp.edu.br", "IDP");

        participants.add(student1);
        participants.add(student2);
        participants.add(professional1);
        participants.add(professional2);

        System.out.println("--- Exibindo informações dos participantes ---");

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("----------------------------------------------");
        }
    }
}