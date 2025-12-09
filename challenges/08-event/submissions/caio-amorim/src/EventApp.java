import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("S001", "Claudia dias", "claudia.dias@email.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("S002", "Carlos Souza", "carlos.souza@email.com", "Engenharia de Software", 5));
        participants.add(new ProfessionalParticipant("P001", "Mariana Oliveira", "mariana.oliveira@email.com", "IBM"));
        participants.add(new ProfessionalParticipant("P002", "João Pereira", "joao.pereira@email.com", "Google"));

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("------------------------------");
        }
    }
}
