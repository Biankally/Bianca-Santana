import java.util.ArrayList;
import java.util.List;


    abstract class Participant {

        private String id;

        private String fullName;
        
        private String email;


        public Participant (String id, String fullName, String email){

                this.id = id;

                this.fullName = fullName;

                this.email = email;
        }

        public String getId(){

            return id;
        }

         public String getFullName(){

            return fullName;
        }

         public String getEmail(){

            return email;
        }


        public abstract String describeRole();  


    @Override
    public String toString() {
    return "ID: " + id + " | Nome: " + fullName + " | Email: " + email;
    }


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
    return String.format("Estudante de %s, %dº semestre", course, currentSemester);
    }

    @Override
    public String toString() {
    return super.toString() + " | Curso: " + course + " | Semestre: " + currentSemester;
    }
}

class ProfessionalParticipant extends Participant {

    private String organization;

    public ProfessionalParticipant (String id, String fullName, String email, String organization) {

        super(id, fullName, email);

        this.organization = organization;

    }

    @Override
    public String describeRole(){
        return "Profissional da organização:" + organization;
    }

    @Override
    public String toString(){
        return super.toString() + ", Organização: " + organization;
    }
}

// CLASSE PRINCIPAL

public class EventApp {

    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        //INSERÇÃO DE PARTICIPANTES, 2 ESTUDANTES E 2 PROFISSIONAIS

        participants.add(new StudentParticipant("1", "Matheus de Souza Bosco", "matheus@gmail.com", "Engenharia de Software", 3));
        participants.add(new StudentParticipant("2", "Thiago Weber", "thiago@gmail.com", "Engenharia de Software", 3));
        participants.add(new ProfessionalParticipant("3", "Giorgian de Arrascaeta", "arrasca@gmail", "Clube de Regatas do Flamengo"));
        participants.add(new ProfessionalParticipant("4", "Bruno Henrique", "bh@gmail", "Clube de Regatas do Flamengo"));

        
        //EXIBE

        for (Participant p : participants) {

            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("----------------------------------");
        }
    }
}




