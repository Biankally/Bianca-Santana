public class ProfessionalParticipant extends Participant{

    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization){
        super(id, fullName, email); //chama o construtor da superclasse
        this.organization = organization;
    }

    @Override 
    public String describeRole(){
        return "Papel: Profissional - Organização: " + this.organization;
    }

    @Override
    public String toString() {
        return super.toString() + " - Organização: " + this.organization;
    }
}
