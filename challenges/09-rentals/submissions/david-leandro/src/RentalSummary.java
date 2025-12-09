



public class RentalSummary {


    private String firstName;


    private String lastName;


    private String email;


    private double amount;





    


    public RentalSummary(String firstName, String lastName, String email, double amount) {


        this.firstName = firstName;


        this.lastName = lastName;


        this.email = email;


        this.amount = amount;


    }





    // Getters


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





    


    //Retorna uma string formatada para CSV: Nome,Sobrenome,Email,Valor Gasto





    @Override


    public String toString() {


        return String.format("%s,%s,%s,%.2f", firstName, lastName, email, amount);


    }


}