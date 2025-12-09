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

    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "%s,%s,%s,%.2f",
                firstName, lastName, email, amount);
    }
}
