public class ProfessionalParticipant extends Participant {
    private String empresa;

    public ProfessionalParticipant(String matricula, String nomeCompleto, String email, String empresa) {
        super(matricula, nomeCompleto, email);
        this.empresa = empresa;
    }

    
    public String descreverPapel() {
        return "Atuo profissionalmente na empresa " + empresa + ".";
    }

    
    public String toString() {
        return "[ProfessionalParticipant] " + getNomeCompleto() + " | Matrícula: " + getMatricula() +
               " | Email: " + getEmail() +
               " | Empresa: " + empresa;
    }
}
