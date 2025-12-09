import java.util.ArrayList;
import java.util.List;

abstract class Participant {
    private String id;
    private String fullName;
    private String email;


    public Participant (String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId (){
        return id;
    }

    public String getFullName (){
        return fullName;
    }

    public String getEmail (){
        return email;
    }

    public abstract String describeRole();

}

class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant (String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }


    @Override
    public String describeRole() {
        return "Estudante do curso de " + course + " (" + currentSemester + "º semestre).";
    }

    @Override
    public String toString() {
        return String.format(
            "Estudante: %s (ID: %s, E-mail: %s, Curso: %s, Semestre: %d)",
            getFullName(), getId(), getEmail(), course, currentSemester
        );
    }
}

class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant (String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização " + organization + ".";
    }

    @Override
    public String toString() {
        return String.format(
            "Profissional: %s (ID: %s, E-mail: %s, Organização: %s)",
            getFullName(), getId(), getEmail(), organization
        );
    }
}

public class EventApp{

    public static void main (String[] args){
        List<Participant> participants = new ArrayList<>();

        registerParticipants(participants);

        displayParticipantsInfo(participants);
    }

    private static void registerParticipants(List<Participant> participants){

        participants.add(new StudentParticipant("S001", "Pietro Branco Rossi","pietro1.com@gmail.com", "ciencia da computacao", 3));
        participants.add(new StudentParticipant("S002", "Luisa Betini Ribeiro", "luisabetini@gmail.com", "administracao", 4));
        participants.add(new StudentParticipant("S003", "Lais Ribeiro", "anaclara@gmail.com", "engenharia", 5));
        participants.add(new StudentParticipant("S004", "Leticia Tavares Neres Soares", "lettns@gmail.com", "engenharia", 3));

        participants.add(new ProfessionalParticipant("P001", "Fabricio Santana", "fabricio.santana@gmail.com", "Google"));
        participants.add(new ProfessionalParticipant("P002", "Paulo Peres", "paulo.peres@gmail.com", "NVIDIA"));
        participants.add(new ProfessionalParticipant("P003", "Carlos Alberto", "carlos.alberto@gmail.com", "Pinterest"));
    }

    private static void displayParticipantsInfo (List<Participant> participants){
        System.out.println("---- Participantes IDP Tech Week: ----");
        System.out.println();

        for (Participant p : participants){
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("-------------------------------");
        }
        }
    }
