public abstract class Participant {
    private final String id;
    private final String fullName;
    private final String email;

    public Participant(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }

    /** Cada subclasse descreve seu papel no evento. */
    public abstract String describeRole();

    @Override
    public String toString() {
        // toString básico e uniforme
        return String.format("ID: %s | Nome: %s | Email: %s", id, fullName, email);
    }
}
