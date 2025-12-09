import java.util.Locale;

public class RentalSummary {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final double amount;

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

    @Override
    public String toString() {
        return String.join(
            ",",
            firstName,
            lastName,
            email,
            String.format(Locale.US, "%.2f", amount)
        );
    }
}

