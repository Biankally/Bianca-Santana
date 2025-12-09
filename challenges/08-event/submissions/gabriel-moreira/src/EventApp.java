import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> lista = new ArrayList<>();

        
        lista.add(new StudentParticipant("ST01", "Mateus Andrade", "mateus.andrade@aluno.com", "Ciência da Computação", 4));
        lista.add(new StudentParticipant("ST02", "Beatriz Rocha", "beatriz.rocha@aluno.com", "Engenharia Elétrica", 7));

        
        lista.add(new ProfessionalParticipant("PR01", "Clara Martins", "clara.martins@corp.com", "SoftDev Ltda."));
        lista.add(new ProfessionalParticipant("PR02", "Diego Ferreira", "diego.ferreira@empresa.com", "Inovatec"));

        
        for (Participant part : lista) {
            System.out.println(part.toString());
            System.out.println("Função: " + part.describeRole());
            System.out.println("====================================");
        }
    }
}

