public abstract class Participant {
    private String regNumber;   
    private String fullLabel;   
    private String mail;        

    public Participant(String regNumber, String fullLabel, String mail) {
        this.regNumber = regNumber;
        this.fullLabel = fullLabel;
        this.mail = mail;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getFullLabel() {
        return fullLabel;
    }

    public String getMail() {
        return mail;
    }

    public abstract String describeRole();
}
