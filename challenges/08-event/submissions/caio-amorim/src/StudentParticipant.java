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
        return "Estudante do curso de " + course + ", semestre " + currentSemester + ".";
    }

    @Override
    public String toString() {
        return "StudentParticipant { ID='" + getId() + "', Nome='" + getFullName() +
                "', Email='" + getEmail() + "', Curso='" + course + "', Semestre=" + currentSemester + " }";
    }
}
