import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("stu-001", "Ana Martins", "ana@example.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("stu-002", "Bruno Lima", "bruno@example.com", "Engenharia de Software", 5));
        participants.add(new ProfessionalParticipant("pro-101", "Daniel Rocha", "daniel@example.com", "IDP Tech"));
        participants.add(new ProfessionalParticipant("pro-102", "Eduarda Souza", "eduarda@example.com", "Consultoria Inova"));

        System.out.println("Participantes cadastrados:");
        for (Participant participant : participants) {
            System.out.println(participant.toString());
            System.out.println(participant.describeRole());
        }
    }
}
