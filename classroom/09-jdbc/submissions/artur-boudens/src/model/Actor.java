package model;

public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;

    public void setActorId(int actorId) { this.actorId = actorId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return "Ator [ID=" + actorId + ", Nome=" + firstName + " " + lastName + "]";
    }
}