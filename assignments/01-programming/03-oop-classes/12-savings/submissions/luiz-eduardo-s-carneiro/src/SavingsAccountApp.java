import java.util.Scanner;

public class SavingsAccountApp{
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        SavingsAccount sa = new SavingsAccount();

        
        System.out.print("Informe o saldo inicial: ");
        double saldo = scanner.nextDouble();
        
        System.out.print("Informe a taxa de juros anual (%): ");
        double juros = scanner.nextDouble();
        
        sa.setAnnualInterestRate(juros);
        sa.setSavingsBalance(saldo);

        double x = sa.getSavingsBalance();
        double y = sa.getAnnualInterestRate();

        sa.calculateMonthlyInterest(y, x);

    }
}