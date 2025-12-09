public class RentalSummary {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final double amount;

    // Construtor que inicializa todos os atributos
    public RentalSummary(String firstName, String lastName, String email, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
    }

    // Getters (não obrigatórios pelo requisito, mas boas práticas)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public double getAmount() { return amount; }

    /**
     * Retorna a string formatada para a linha do CSV.
     * Formato: Nome,Sobrenome,Email,Valor Gasto
     */
    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "\"%s\",\"%s\",\"%s\",%.2f", firstName, lastName, email, amount);
    }
}