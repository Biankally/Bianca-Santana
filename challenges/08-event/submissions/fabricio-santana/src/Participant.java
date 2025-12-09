public abstract class Participant {
    private final String id;
    private final String fullName;
    private final String email;

    protected Participant(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public abstract String describeRole();

    @Override
    public String toString() {
        return id + " | " + fullName + " | " + email + " | " + describeRole();
    }
}
