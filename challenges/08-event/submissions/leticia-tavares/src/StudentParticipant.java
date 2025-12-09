import java.util.ArrayList;
import java.util.List;


class StudentParticipant extends Participant {

    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email); 
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {

        return "participante estudante";
    }

    @Override
    public String toString() {

        return "-- participante estudante --\n" +
               "id: " + getId() + "\n" +
               "nome: " + getFullName() + "\n" +
               "emial: " + getEmail() + "\n" +
               "curso: " + this.course + "\n" +
               "semestre atual : " + this.currentSemester;
    }
}


