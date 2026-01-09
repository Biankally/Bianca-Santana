import java.io.IOException;
import java.nio.file.Path;
import java.util.NoSuchElementException; 
import java.util.Scanner; 

public class ReadTextFile { 
   public static void main(String[] args) { 
    
      try (Scanner input = new Scanner(Path.of("data/clients.txt"))) { //Paths.get("clients.txt")
         System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance"); 

         while (input.hasNext()) { 
            int accountNumber = input.nextInt(); 
            String firstName = input.next(); 
            String lastName = input.next(); 
            double balance = input.nextDouble(); 

            System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber, firstName, lastName, balance);
         } 
      } 
      catch (IOException | NoSuchElementException | IllegalStateException e) { 
        e.printStackTrace(); 
      } 
   } 
}
