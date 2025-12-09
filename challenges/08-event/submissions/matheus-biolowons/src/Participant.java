public abstract class Participant {
  final String id;
  final String fullName;
  final String email;

  Participant (String id, String fullName, String email ) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public abstract String describeRole();

  @Override
  public String toString() {
    return String.format("Id: %s\nName: %s\nEmail: %s", getId(), getFullName(), getEmail());
  }
}
