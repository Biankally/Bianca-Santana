/**
 * A classe SavingsAccount representa uma conta poupança com um saldo
 * e uma taxa de juros anual compartilhada entre todas as contas.
 */
public class SavingsAccount {

    // Atributo de classe (static) para a taxa de juros anual
    private static double annualInterestRate;

    // Atributo de instância para o saldo da conta
    private double savingsBalance;

    /**
     * Construtor que inicializa a conta com um saldo inicial.
     *
     * @param initialBalance O saldo inicial da conta.
     * @throws IllegalArgumentException se o saldo inicial for negativo.
     */
    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial не pode ser negativo.");
        }
        this.savingsBalance = initialBalance;
    }

    /**
     * Calcula o juro mensal e o adiciona ao saldo da conta.
     * A fórmula utilizada é (saldo * taxaAnual) / 12 para corresponder ao exemplo.
     */
    public void calculateMonthlyInterest() {
        double monthlyInterest = (this.savingsBalance * annualInterestRate) / 12.0;
        this.savingsBalance += monthlyInterest;
    }

    /**
     * Modifica a taxa de juros anual para todas as contas.
     *
     * @param rate A nova taxa de juros anual em formato de porcentagem (ex: 4 para 4%).
     * @throws IllegalArgumentException se a taxa for negativa.
     */
    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juros не pode ser negativa.");
        }
        // Converte a porcentagem para um valor decimal (ex: 4 -> 0.04)
        annualInterestRate = rate / 100.0;
    }
    
    /**
     * Retorna a taxa de juros anual.
     * @return a taxa de juros anual em formato de porcentagem.
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate * 100.0;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return O saldo atual.
     */
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
}