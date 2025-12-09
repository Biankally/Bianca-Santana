import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        
        List<Participant> participantes = new ArrayList<>();

        participantes.add(new StudentParticipant("1234", "Felipe Eduardo Ornelas Ballarin", "ornelas.ballarin@gmail.com", "Engenharia de Software", 4));
        participantes.add(new StudentParticipant("2345", "Pietro Branco Rossi", "pedrobiancovermelhos@gmail.com", "Ciencia da computação", 4));

        participantes.add(new ProfessionalParticipant("3456", "Fabricio Santana", "fabricio.satana@gmail.com", "Senado e IDP"));
        participantes.add(new ProfessionalParticipant("4567", "Lorena Borges", "lorena.borges@gmail.com", "STF e IDP"));

        System.out.println("Participantes cadastrados:");
        System.out.println(); 

        for (Participant participante_atual : participantes) { 
            System.out.println(participante_atual);
            String role = participante_atual.describeRole();
            System.out.println(role);
            System.out.println();
        }
    }
}
