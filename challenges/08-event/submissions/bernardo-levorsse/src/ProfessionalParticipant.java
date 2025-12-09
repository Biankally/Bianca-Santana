public class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email,
                                   String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    public String getOrganization() { return organization; }

    @Override
    public String describeRole() {
        return "Profissional representante da organização: " + organization;
    }

    @Override
    public String toString() {
        return String.format(
            "ProfessionalParticipant{id='%s', fullName='%s', email='%s', organization='%s'}",
            getId(), getFullName(), getEmail(), organization
        );
    }
}
