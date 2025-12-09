import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("S001", "Ana Carolina", "ana.carolina@email.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("S002", "Bruno Costa", "bruno.costa@email.com", "Engenharia de Software", 5));

        participants.add(new ProfessionalParticipant("P001", "Carlos Dias", "carlos.dias@empresa.com", "Empresa X"));
        participants.add(new ProfessionalParticipant("P002", "Daniela Martins", "daniela.martins@startup.com", "Startup Y"));

        System.out.println("Participantes cadastrados na IDP Tech Week:");
        System.out.println("");

        for (Participant p : participants) {
            System.out.println("---------------------------------------------");
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
        }

        System.out.println("---------------------------------------------");
    }
}