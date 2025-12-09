public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email, "Estudante");
        this.course = course;
        this.currentSemester = currentSemester;
    }

    public String getCourse() {
        return course;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso: " + course + ", Semestre: " + currentSemester;
    }
}