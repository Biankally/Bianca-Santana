import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        // Criando 2 estudantes
        participants.add(new StudentParticipant("S01", "Ana Silva", "ana@email.com", "Engenharia de Software", 3));
        participants.add(new StudentParticipant("S02", "Carlos Souza", "carlos@email.com", "Ciência da Computação", 5));

        // Criando 2 profissionais
        participants.add(new ProfessionalParticipant("P01", "Mariana Lima", "mariana@email.com", "Google"));
        participants.add(new ProfessionalParticipant("P02", "João Pereira", "joao@email.com", "Microsoft"));

        // Exibir informações
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("-------------------------------------------------");
        }
    }
}
