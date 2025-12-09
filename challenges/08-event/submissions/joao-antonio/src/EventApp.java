import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participantes = new ArrayList<>();

        
        participantes.add(new StudentParticipant("2110", "João Antônio Barbosa Pereira", "joao.anbp@idp.com", "Engenharia de Software", 3));
        participantes.add(new StudentParticipant("3110", "Pablo Basilio", "basilio.pablo11@idp.com", "Engenharia de Software", 3));
        
        participantes.add(new ProfessionalParticipant("4110", "Fabricio Santana", "fabricio.santana@idp.com", "Senado / IDP"));
        participantes.add(new ProfessionalParticipant("5110", "Jeremias", "j3r3mias@idp.com", "IDP"));

        System.out.println("\n---------------------------------\n");
        System.out.println("-- Participantes cadastrados: --\n");
        System.out.println("---------------------------------\n");

        for (Participant participante : participantes) {
            System.out.println(participante);
            String role = participante.describeRole();
            System.out.println(role);
            System.out.println("-----------------------------------\n");
        }
    }
}
