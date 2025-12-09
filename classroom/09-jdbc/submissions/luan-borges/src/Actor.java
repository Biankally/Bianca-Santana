public class Actor {
    private int id;
    private String primeiroNome;
    private String ultimoNome;

    public Actor(int id, String primeiroNome, String ultimoNome) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    @Override
    public String toString() {
        return "Ator ID: " + id + " | Nome: " + primeiroNome + " " + ultimoNome;
    }
}
