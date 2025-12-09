public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) throws Exception {
        if (savingsBalance < 0) throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");

        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double annualRateDecimal = annualInterestRate / 100.0;
        double monthlyRate = Math.pow(1 + annualRateDecimal, 1.0 / 12.0) - 1;
        double interest = savingsBalance * monthlyRate;

        savingsBalance += interest;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void setAnnualInterestRate(double newRate) throws Exception {
        if (newRate < 0) throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");

        annualInterestRate = newRate;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
}