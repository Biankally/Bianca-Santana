public class ProfessionalParticipant extends Participant {
    private String organization;
<<<<<<< HEAD
    
    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        this.organization = organization;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    @Override
    public String describeRole() {
        return "Profissional da organização " + organization;
    }
    
    @Override
    public String toString() {
        return "ProfessionalParticipant{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}

=======

    public ProfessionalParticipant(String id, String fullName, String email, String organization) {
        super(id, fullName, email);
        
        this.organization = organization;
    }

    @Override
    public String describeRole() {
        return "Profissional da organização: " + organization + ".";
    }

    @Override
    public String toString() {
        return "Profissional: " + getFullName() + " (ID: " + getId() + ", Email: " + getEmail() + ", Organização: " + organization + ")";
    }
}
>>>>>>> c23b2b3759b8776fbb9bf72d5b1f3761f6aa31eb
