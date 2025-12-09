public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email,
                              String course, int currentSemester) {
        super(id, fullName, email);
        this.course = course;
        this.currentSemester = currentSemester;
    }

    public String getCourse() { return course; }
    public int getCurrentSemester() { return currentSemester; }

    @Override
    public String describeRole() {
        return "Estudante do curso de " + course + " (semestre " + currentSemester + ")";
    }

    @Override
    public String toString() {
        return String.format(
            "StudentParticipant{id='%s', fullName='%s', email='%s', course='%s', currentSemester=%d}",
            getId(), getFullName(), getEmail(), course, currentSemester
        );
    }
}
