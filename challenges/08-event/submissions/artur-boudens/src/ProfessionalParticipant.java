public class ProfessionalParticipant extends Participant{
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization){
        super(id, fullName, email);

        this.organization = organization;
    }

    @Override
    public String toString(){
        return "Profissional: [ID: " + super.getId() + ", Nome completo: " + super.getFullName() + ", Email: " + super.getEmail() + ", Organização: " + this.organization + "]"; 
    }

    @Override
    public String describeRole(){
        return "Papel: Profissional da organização " + this.organization + ".";
    }
}
