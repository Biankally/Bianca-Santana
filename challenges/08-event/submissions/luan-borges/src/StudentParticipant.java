public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {
        return "Estudante do curso de " + this.course + " (semestre " + this.currentSemester + ")";
    }

    @Override
    public String toString() {
        return "Id -> " + getId() + ", Nome -> " + getFullName() + ", Email -> " + getEmail() +
               ", Curso -> " + this.course + ", semestre -> " + this.currentSemester;
    }
}