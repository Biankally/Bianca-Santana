import java.util.ArrayList;
import java.util.List;

public class EventApp {

    public static void main(String[] args) {
        List<Participant> participants = createParticipants();
        displayParticipantsInfo(participants);
    }

    private static List<Participant> createParticipants() {
        List<Participant> participants = new ArrayList<>();
        
        participants.add(new StudentParticipant("stu-001", "Artur Boudens", "Artuzingamer@gmail.com", "Ciência da Computação", 3));
        participants.add(new ProfessionalParticipant("pro-101", "Fabricio Santana", "FabricioSantana@gmail.com", "IDP Tech"));

        return participants;
    }

    private static void displayParticipantsInfo(List<Participant> participants) {
        System.out.println("--- Participantes cadastrados ---");
        for (Participant participant : participants) {
            System.out.println("\n--------------------");
            System.out.println("Papel: " + participant.describeRole());
            System.out.println("Detalhes: " + participant.toString());
            System.out.println("--------------------");
        }
    }
}