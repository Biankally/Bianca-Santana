import java.util.Scanner; 

public class AssertTest { 
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a number between 0 and 10: "); 
            int number = input.nextInt(); 

            assert (number >= 0 && number <= 10) : "bad number: " + number; 

            //if (number >= 0 && number <= 10) throw new Exception("bad number: " + number);

            System.out.printf("You entered %d%n", number);
        } 
    } 
} 