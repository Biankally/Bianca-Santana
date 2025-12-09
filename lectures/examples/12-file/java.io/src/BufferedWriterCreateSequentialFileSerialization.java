import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BufferedWriterCreateSequentialFileSerialization {
    public static void main(String[] args) {

        try(BufferedWriter output = Files.newBufferedWriter(Path.of("clients.xml"))) { //Paths.get

          Scanner input = new Scanner(System.in);
      
          List<Account> accountList = new ArrayList<>();

            System.out.printf("%s%n%s%n? ",
            "Enter account number, first name, last name and balance.",
            "Enter end-of-file indicator to end input.");

            while (input.hasNext()) {
                try {
                    Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
                    accountList.add(record);
                } catch (NoSuchElementException elementException) {
                    System.err.println("Invalid input. Please try again.");
                    input.nextLine(); // descarta linha inválida
                }
                
                System.out.print("? ");
            }
          
        } catch(IOException e){
            e.printStackTrace();
        }  
    } 
}

class Account {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;
 
    public Account() {
       this(0, "", "", 0.0);
    }
 
    public Account(int accountNumber, String firstName, String lastName, double balance) {
       this.accountNumber = accountNumber;
       this.firstName = firstName;
       this.lastName = lastName;
       this.balance = balance;
    }
 
    public int getAccountNumber() {
       return accountNumber;
    }
 
    public void setAccountNumber(int accountNumber) {
       this.accountNumber = accountNumber;
    }
 
    public String getFirstName() {
       return firstName;
    }
 
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
 
    public String getLastName() {
       return lastName;
    }
 
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }
 
    public double getBalance() {
       return balance;
    }
 
    public void setBalance(double balance) {
       this.balance = balance;
    }
 }
 