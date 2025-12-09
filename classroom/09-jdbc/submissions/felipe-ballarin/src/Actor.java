public class Actor {
    private Integer actorId;
    private String firstName;
    private String lastName;

    public Actor(Integer actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s (ID: %d)", firstName, lastName, actorId);
    }
}