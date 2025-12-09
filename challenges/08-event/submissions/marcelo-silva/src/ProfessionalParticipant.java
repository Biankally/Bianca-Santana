public class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização " + this.organization + ".";
    }

    @Override
    public String toString() {
        return "ProfessionalParticipant[id=" + getId() + ", fullName=" + getFullName() + ", email=" + getEmail() + ", organization=" + organization + "]";
    }
}