import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double initialRate = scanner.nextDouble();

            SavingsAccount saver = new SavingsAccount(initialBalance);
            SavingsAccount.setAnnualInterestRate(initialRate);

            System.out.printf("%nSaldos com taxa de juros de %.1f%%:%n", SavingsAccount.getAnnualInterestRate());

            for (int month = 1; month <= 12; month++) {
                saver.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f%n", month, saver.getSavingsBalance());
            }

            System.out.print("\nInforme a nova taxa de juros anual: ");
            double newRate = scanner.nextDouble();

            System.out.printf("%nAlterando taxa de juros anual para %.0f%%...%n", newRate);
            SavingsAccount.setAnnualInterestRate(newRate);

            saver.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f%n", saver.getSavingsBalance());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado. Verifique os dados inseridos.");
        }
    }
}