import java.util.Scanner; 
import java.util.InputMismatchException; // trata os erros de digitação

public class SavingsAccountApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double initialBalance = 0;
        double annualRate = 0;

        try {
            System.out.print("Informe o saldo inicial: ");
            initialBalance = input.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            annualRate = input.nextDouble();

        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um número válido.");
            return; // Encerra o programa se a entrada for inválida
        }

        try {
            SavingsAccount account = new SavingsAccount(initialBalance);

            SavingsAccount.setAnnualInterestRate(annualRate);

            System.out.println("\nSaldos com taxa de juros de " + annualRate + "%:");

            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();

                System.out.printf("Mês %d: R$%.2f\n", month, account.getSavingsBalance());
            }

            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double newAnnualRate = input.nextDouble();

            SavingsAccount.setAnnualInterestRate(newAnnualRate);
            System.out.println("\nAlterando taxa de juros anual para " + newAnnualRate + "%...");

            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        } catch (IllegalArgumentException e) {
            // Captura os erros que podem aparecer na classe SavingsAccount (saldo ou taxa negativos)
            System.out.println("Erro ao criar a conta: " + e.getMessage());
        } finally {
            input.close(); 
        }
    }
}
