import java.util.Locale;

public class RentalSummary {
    private String firstName;
    private String lastName;
    private String email;
    private double amount;

    public RentalSummary(String firstName, String lastName, String email, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * Retorna a linha pronta para o CSV: Nome,Sobrenome,Email,Valor Gasto
     * Usa Locale.US para garantir ponto decimal.
     */
    @Override
    public String toString() {
        // Formata o valor com 2 casas decimais e separador ponto (ex: 123.45)
        String formattedAmount = String.format(Locale.US, "%.2f", amount);
        return String.join(",", firstName, lastName, email, formattedAmount);
    }
}
