import java.util.ArrayList;
import java.util.List;

public final class EventApp {
    private EventApp() {
    }

    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant(
                "stu-001",
                "Ana Martins",
                "ana.martins@exemplo.com",
                "Ciência da Computação",
                3
        ));

        participants.add(new StudentParticipant(
                "stu-002",
                "Bruno Lopes",
                "bruno.lopes@exemplo.com",
                "Sistemas de Informação",
                5
        ));

        participants.add(new ProfessionalParticipant(
                "pro-101",
                "Carla Souza",
                "carla.souza@empresa.com",
                "IDP Tech"
        ));

        participants.add(new ProfessionalParticipant(
                "pro-102",
                "Daniel Ribeiro",
                "daniel.ribeiro@consultoria.com",
                "Consultoria Inova"
        ));

        printParticipants(participants);
    }

    private static void printParticipants(List<Participant> participants) {
        System.out.println("Participantes cadastrados:");
        for (Participant participant : participants) {
            System.out.println(participant);
            System.out.println("  -> " + participant.describeRole());
        }
    }
}
