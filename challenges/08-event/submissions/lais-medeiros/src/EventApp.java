import java.util.ArrayList;

public class EventApp {
    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();

        // Dois estudantes
        participants.add(new StudentParticipant("01", "Lais Medeiros", "lais@email.com", "Engenharia de Software", 3));
        participants.add(new StudentParticipant("02", "Carlos Costa", "carlos@email.com", "Ciência da Computação", 5));

        // Dois profissionais
        participants.add(new ProfessionalParticipant("P01", "Patricia Silva", "patricia@idp.com", "IDP Tecnologia"));
        participants.add(new ProfessionalParticipant("P02", "Lucas Soza", "jlucas@idp.com", "Tech Solutions"));

        // Mostrar todos os participantes
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("-----------------------------------");
        }
    }
}
