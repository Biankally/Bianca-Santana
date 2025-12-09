public class StudentParticipant extends Participant {
    private String course;
    private int currentSemester;
<<<<<<< HEAD
    
    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);
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
    public String describeRole() {
        return "Estudante do curso " + course + " no " + currentSemester + "º semestre";
    }
    
    @Override
    public String toString() {
        return "StudentParticipant{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", course='" + course + '\'' +
                ", currentSemester=" + currentSemester +
                '}';
    }
}

=======

    public StudentParticipant(String id, String fullName, String email, String course, int currentSemester) {
        super(id, fullName, email);

        this.course = course;
        this.currentSemester = currentSemester;
    }

    @Override
    public String describeRole() {
        return "Estudante do curso de " + course + " no semestre " + currentSemester + ".";
    }

    @Override
    public String toString() {
        return "Estudante: " + getFullName() + " (ID: " + getId() + ", Email: " + getEmail() + ", Curso: " + course + ", semestre " + currentSemester + ")";
    }
}
>>>>>>> c23b2b3759b8776fbb9bf72d5b1f3761f6aa31eb
