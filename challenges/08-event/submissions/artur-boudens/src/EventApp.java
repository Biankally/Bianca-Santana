
import java.util.ArrayList;


public class EventApp {
    public static void main(String[] args) {
        System.out.println("### Participantes cadastrados ###");
        ArrayList<Participant> participants = new ArrayList<>();

        StudentParticipant estudante1 = new StudentParticipant("stu-001", "Artur Boudens", "boudensartur@gmail.com", "Ciência da Computação", 3);
        participants.add(estudante1);

        StudentParticipant estudante2 = new StudentParticipant("stu-002", "Luan Borges", "luanbrgs1@gmail.com", "Engenharia de Software", 3);
        participants.add(estudante2);

        ProfessionalParticipant profissional1 = new ProfessionalParticipant("pro-101", "Fabrício Santana", "fabricio.santana@gmail.com", "IDP");
        participants.add(profissional1);

        ProfessionalParticipant profissional2 = new ProfessionalParticipant("pro-102", "Erik Surjan", "erik.surjan@gmail.com", "Sigma");
        participants.add(profissional2);

        for(Participant participant: participants){
            System.out.println(participant.describeRole());
            System.out.println(participant.toString());
            System.out.println("----------------------");
        }
    }
}
