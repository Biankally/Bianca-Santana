import java.util.Scanner;

public class AccountApp {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Welcome to the Account App!");

            System.out.println(">>> First Account!");

            System.out.println(">>>");

            System.out.print("Enter the account holder's name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter the account holder's balance: ");
            double balance = scanner.nextDouble();

            scanner.nextLine();
    
            Account account = new Account();
            account.setName(name);
            account.setBalance(balance);

            System.out.printf("%s's account balance is $%.2f.\n",
                    account.getName(),
                    account.getBalance());

            System.out.println(">>>");

            System.out.println(">>> Second Account!");

            System.out.println(">>>");

            System.out.print("Enter the account holder's name: ");
            String name2 = scanner.nextLine();
    
            System.out.print("Enter the account holder's balance: ");
            double balance2 = scanner.nextDouble();

            scanner.nextLine();

            Account account2 = new Account(name2, balance2);

            System.out.printf("%s's account balance is $%.2f.\n",
                    account2.getName(),
                    account2.getBalance());
            
            System.out.println(">>>");

            System.out.println(">>> Depositing to the First Account!");

            System.out.println(">>>");

            System.out.print("Enter the deposit amount: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            
            System.out.printf("%s's account balance is $%.2f.\n",
                    account.getName(),
                    account.getBalance());
        }
    }
}

    
