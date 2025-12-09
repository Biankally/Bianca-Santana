public class StudentParticipant extends Participant {
  String course;
  int currentSemester;

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
    return String.format("%s\nsemestre %d", getCourse(), getCurrentSemester());
  }

  @Override
  public String toString() {
    return String.format("Type: Estudante\n%s\nCourse: %s\nsemestre %d", super.toString(), getCourse(), getCurrentSemester());
  }
}
