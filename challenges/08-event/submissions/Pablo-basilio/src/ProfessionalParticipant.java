public class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional em busca de atualização e potenciais parcerias. Organização: " + organization + ".";
    }

    @Override
    public String toString() {
        return "Profissional [ID: " + getId() + 
               ", Nome: " + getFullName() + 
               ", Email: " + getEmail() + 
               ", Organização: " + organization + "]";
    }
}