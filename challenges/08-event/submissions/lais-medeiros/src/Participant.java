public abstract class Participant {

    private String id;
    private String fullName;
    private String email;

    public Participant(String id, String fullName, String email) {
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

    // Método abstrato que será implementado pelas subclasses
    public abstract String describeRole();

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + fullName + " | Email: " + email;
    }
}
