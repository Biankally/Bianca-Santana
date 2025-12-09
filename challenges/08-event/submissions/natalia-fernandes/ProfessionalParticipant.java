public class ProfessionalParticipant extends Participant {
    private final String organization;

    public ProfessionalParticipant(String id, String fullName, String email,
                                   String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }

    public String getOrganization() { return organization; }

    @Override
    public String describeRole() {
        return "Profissional: mentora/alinha conteúdo com o mercado e pode ministrar sessões.";
    }

    @Override
    public String toString() {
        return String.format(
            "Tipo: Profissional | %s | Organização: %s",
            super.toString(), organization
        );
    }
}
