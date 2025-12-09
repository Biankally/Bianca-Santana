public class Participant {
    private String id;
    private String fullName;
    private String email;
    private String type;

    public Participant(String id, String fullName, String email, String type) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public String describeRole() {
        return "Participante: " + type;
    }

    @Override
    public String toString() {
        return type + ": " + fullName + " (ID: " + id + ", Email: " + email + ")";
    }
}