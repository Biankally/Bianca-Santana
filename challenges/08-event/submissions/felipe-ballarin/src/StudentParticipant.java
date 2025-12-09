public class StudentParticipant extends Participant {

    private String course;
    private int currentSemester;
    
    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester){
        super(id, fullName, email); //chama o construtor da superclasse
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override 
    public String describeRole(){
        return "Papel: Estudante - " + this.course + "(semestre " + this.currentSemester + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " - Curso: " + this.course + "(semestre " + this.currentSemester + ")";
    }
}
