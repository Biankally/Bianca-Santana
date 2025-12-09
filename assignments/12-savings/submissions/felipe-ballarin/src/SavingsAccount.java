public class SavingsAccount {

    private static double annualInterestRate;

    private double savingsBalance;


    public SavingsAccount(double savingsBalance) {
        
        if (savingsBalance < 0) {  //se o saldo for menor que zero lança uma IllegalArgumentException
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        
        //double monthlyInterest = this.savingsBalance * (annualInterestRate / 12); 

        double monthlyRate = Math.pow((1 + annualInterestRate / 100.0), (1.0 / 12.0)) - 1;
        
        double interestAmount = this.savingsBalance * monthlyRate;

        this.savingsBalance += interestAmount;
    }

    public static void setAnnualInterestRate(double newRate) {

        if (newRate < 0) {   //a taxa não pode ser negativa.
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

}
