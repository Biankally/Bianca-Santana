public class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email, "Profissional");
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return super.toString() + ", Organização: " + organization;
    }
}