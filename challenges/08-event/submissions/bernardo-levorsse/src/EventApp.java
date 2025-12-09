import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        
        participants.add(new StudentParticipant(
            "S001", "Bernardo Levorsse", "bernardo.levorsse@aluno.idp.edu.br", "Ciência da Computação", 3));
        participants.add(new StudentParticipant(
            "S002", "Gabriel Lopes", "gabriel.lopes@aluno.idp.edu.br", "Engenharia de Software", 5));

        participants.add(new ProfessionalParticipant(
            "P001", "Marlene Leni", "marlene.leni@empresa.com", "Acme Tech"));
        participants.add(new ProfessionalParticipant(
            "P002", "Luísa Fróes", "luisa.froes@startup.io", "Startup.io"));

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("— — —");
        }
    }
}
