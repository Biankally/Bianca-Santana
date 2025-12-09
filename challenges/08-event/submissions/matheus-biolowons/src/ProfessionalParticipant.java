public class ProfessionalParticipant extends Participant {
  String organization;

  public ProfessionalParticipant(String id, String fullName, String email, String organization) {
    super(id, fullName, email);

    this.organization = organization;
  }

  public String getOrganization() {
    return organization;
  }

  @Override
  public String describeRole() {
    return this.organization;
  }

  @Override
  public String toString() {
    return String.format("Type: Profissional\n%s\nOrganization: %s", super.toString(), getOrganization());
  }
}
