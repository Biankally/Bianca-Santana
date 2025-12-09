import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("S01", "Ana Silva", "ana@email.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("S02", "Carlos Souza", "carlos@email.com", "Engenharia de Software", 5));
        participants.add(new ProfessionalParticipant("P01", "Mariana Costa", "mariana@email.com", "Empresa Tech Ltda"));
        participants.add(new ProfessionalParticipant("P02", "João Pereira", "joao@email.com", "StartupX"));

        System.out.println("Participantes cadastrados:");

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println(p.describeRole());
        }
    }
}
