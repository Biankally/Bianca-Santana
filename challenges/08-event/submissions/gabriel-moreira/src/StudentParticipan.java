public class StudentParticipan extends Participante {
    private String curso;
    private int periodo;

    public StudentParticipan(String matricula, String nomeCompleto, String email, String curso, int periodo) {
        super(matricula, nomeCompleto, email);
        this.curso = curso;
        this.periodo = periodo;
    }

    
    public String descreverPapel() {
        return "Sou estudante do curso de " + curso + " e estou no " + periodo + "º período.";
    }

    
    public String toString() {
        return "[StudentParticipan] " + getNomeCompleto() + " | Matrícula: " + getMatricula() + 
               " | Email: " + getEmail() +
               " | Curso: " + curso + " | Período: " + periodo;
    }
}
