public class RentalSummary{
    private String firstName;
    private String lastName;
    private String email;
    private double amount;

    public RentalSummary(String firstName, String lastName, String email, double amount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return this.firstName + "," + this.lastName + "," + this.email + "," + this.amount;
    }
    
}