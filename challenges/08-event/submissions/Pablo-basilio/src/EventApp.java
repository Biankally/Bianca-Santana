import java.util.ArrayList;
import java.util.List;

public class EventApp {

    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant(
            "1", "jorginho carrascal", "algum2@gmail.com", "Computacao", 5
        ));
        participants.add(new StudentParticipant(
            "2", "josé boto", "algum@gmail.com", "Software", 3
        ));

        participants.add(new ProfessionalParticipant(
            "3", "de la druz silva", "3algum@gmail.com", "oxford"
        ));

        participants.add(new ProfessionalParticipant(
            "4", "Pedro da silva Cabral", "4algum@outlook.com", "Amstel"
        ));
        
        displayParticipantsInfo(participants);
    }
    
    private static void displayParticipantsInfo(List<Participant> participants) {
        System.out.println("Participantes cadastrados");
        
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("---------------------");
        }
    }
}