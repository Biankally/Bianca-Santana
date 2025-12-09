import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Aplicativo para testar a classe SavingsAccount.
 * Ele simula o cálculo de juros ao longo de 13 meses com duas taxas diferentes.
 */
public class SavingsAccountApp {

    public static void main(String[] args) {
        // Define o Locale para US para aceitar ponto como separador decimal
        Locale.setDefault(Locale.US);
        
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita dados iniciais
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();

            System.out.print("Informe a taxa de juros anual (%): ");
            double annualRate = scanner.nextDouble();

            // Cria a conta e define a taxa de juros inicial
            SavingsAccount account = new SavingsAccount(initialBalance);
            SavingsAccount.setAnnualInterestRate(annualRate);

            // Calcula e exibe os saldos para os primeiros 12 meses
            System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", SavingsAccount.getAnnualInterestRate());
            for (int i = 1; i <= 12; i++) {
                account.calculateMonthlyInterest();
                System.out.printf("Mês %d: R$%.2f\n", i, account.getSavingsBalance());
            }
            
            // Solicita e define a nova taxa de juros
            System.out.print("\nInforme a nova taxa de juros anual (%): ");
            double newAnnualRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(newAnnualRate);
            
            System.out.printf("\nAlterando taxa de juros anual para %.1f%%...\n\n", SavingsAccount.getAnnualInterestRate());

            // Calcula e exibe o saldo do 13º mês com a nova taxa
            account.calculateMonthlyInterest();
            System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        } catch (IllegalArgumentException | InputMismatchException e) {
            // Captura erros de validação (saldo/taxa negativa) ou entrada de tipo incorreto
            System.err.println("Erro: " + e.getMessage());
        }
    }
}