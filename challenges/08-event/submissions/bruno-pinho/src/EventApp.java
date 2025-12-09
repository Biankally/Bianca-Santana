import java.util.ArrayList;
import java.util.List;

public class EventApp {

    public static void main(String[] args) {

        List<Participant> participants = new ArrayList<>();

        
        participants.add(new StudentParticipant("S001", "Ana Carolina", "ana.c@email.com", "Ciência da Computação", 3));
        participants.add(new StudentParticipant("S002", "Bruno Alves", "bruno.a@email.com", "Engenharia de Software", 2));
        participants.add(new StudentParticipant("S003", "Joana Lima", "joana.lima@email.com", "Publicidade e Propaganda", 1));
        participants.add(new StudentParticipant("S004", "Pedro Rocha", "pedro.rocha@email.com", "Análise de Sistemas", 6));
        participants.add(new StudentParticipant("S005", "Mariana Costa", "mari.costa@email.com", "Engenharia de Produção", 5));
        participants.add(new StudentParticipant("S006", "Lucas Pereira", "lucas.pereira@email.com", "Arquitetura", 4));
        

        participants.add(new ProfessionalParticipant("P001", "Carlos Silva", "carlos.s@company.com", "Google"));
        participants.add(new ProfessionalParticipant("P002", "Daniela Martins", "daniela.m@startup.com", "Tech Solutions"));
        participants.add(new ProfessionalParticipant("P003", "Roberto Souza", "roberto.souza@empresa.com", "InovaTech"));
        participants.add(new ProfessionalParticipant("P004", "Fernanda Lima", "fernanda.lima@empresa.com", "Creative Agency"));
        participants.add(new ProfessionalParticipant("P005", "Tatiana Alves", "tatiana.alves@empresa.com", "Marketing Inc."));
        participants.add(new ProfessionalParticipant("P006", "Eduardo Gomes", "eduardo.gomes@empresa.com", "Finance Corp."));
        
        System.out.println("--- Lista de Participantes da IDP Tech Week ---");
        System.out.println();

        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("   Papel: " + p.describeRole());
            System.out.println("---------------------------------------------");
        }
    }
}