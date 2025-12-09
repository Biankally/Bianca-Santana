import java.util.ArrayList;
import java.util.List;


class ProfessionalParticipant extends Participant {
    private String organization;

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email); 
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "participante profissional";
    }

    @Override
    public String toString() {
        return "-- participante profissional --\n" +
               "id: " + getId() + "\n" +
               "nome: " + getFullName() + "\n" +
               "email: " + getEmail() + "\n" +
               "organizacao: " + this.organization;
    }
}


