import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        // 2 estudantes
        participants.add(new StudentParticipant(
                "S001", "Ana Souza", "ana.souza@idp.edu.br", "Ciência da Computação", 3));
        participants.add(new StudentParticipant(
                "S002", "Pedro Lima", "pedro.lima@idp.edu.br", "Sistemas de Informação", 5));

        // 2 profissionais
        participants.add(new ProfessionalParticipant(
                "P101", "Marina Alves", "marina@techcorp.com", "TechCorp"));
        participants.add(new ProfessionalParticipant(
                "P102", "Felipe Rocha", "felipe@datasense.ai", "DataSense AI"));

        printParticipants(participants);
    }

    private static void printParticipants(List<Participant> list) {
        for (Participant p : list) {
            System.out.println(p.toString());
            System.out.println(p.describeRole());
            System.out.println("------------------------------------");
        }
    }
}
