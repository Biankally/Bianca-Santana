public class StudentParticipant extends Participant {
    private final String course;
    private final int currentSemester;

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
        return "Estudante: participa de palestras/workshops e representa a comunidade acadêmica.";
    }

    @Override
    public String toString() {
        return String.format(
            "Tipo: Estudante | %s | Curso: %s | Semestre: %d",
            super.toString(), course, currentSemester
        );
    }
}
