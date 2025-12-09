public class StudentParticipant extends Participant {
    private final String course;
    private final int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {
        return "Estudante do curso " + course + ", semestre " + currentSemester;
    }

    @Override
    public String toString() {
        return "Estudante: " + getId() + " - " + getFullName() +
                " | " + course + " (semestre " + currentSemester + ")" +
                " | " + getEmail();
    }
}
