import java.util.ArrayList;
import java.util.List;

public class EventApp{
    public static void main(String[] args){
        List<Participant> participantes = new ArrayList<>();

        participantes.add(new StudentParticipant("S001", "Felipe Trindade", "felipe.trindade@idp.edu", "Engenharia de Software", 3));
        participantes.add(new StudentParticipant("S002", "Eduardo Novais", "eduardo.novais@idp.edu", "Ciência da Computação", 5));
        participantes.add(new StudentParticipant("S003", "Lucas Santana", "lucas.santana@idp.edu", "Ciência da Computação", 7));

        participantes.add(new ProfessionalParticipant("P001", "Fabricio Santana", "fabricioa@techcorp.com", "TechCorp"));
        participantes.add(new ProfessionalParticipant("P002", "Felipe Ballarin", "ballarin@startupx.com", "StartUpX"));
        participantes.add(new ProfessionalParticipant("P003", "Luan Borges", "lborges@techcorp.com", "TechCorp"));

        System.out.println("Participantes cadastrados");

        for(Participant p : participantes){
            System.out.println(p);
            System.out.println(p.describeRole());
        }
    }
}