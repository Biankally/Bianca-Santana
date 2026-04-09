public class SavingsAccount{
    
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(){
    }

    public SavingsAccount(double savingsBalance){
        if(savingsBalance < 0){
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public static void setAnnualInterestRate(double rate){
        if(annualInterestRate < 0){
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = rate;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterest = (savingsBalance * annualInterestRate / 100) / 12;
        savingsBalance += monthlyInterest;
    }
}