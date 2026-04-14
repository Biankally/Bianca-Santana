public class SavingsAccount {
    private double savingsbalance;
    private static double annulInterestRate;

    //Constructor
    public SavingsAccount(double savingsbalance, double annulInterestRate){

        this.savingsbalance = savingsbalance;
        this.annulInterestRate= annulInterestRate;
    }

    public void setSavingsAccount(double savingsbalance, double annulInterestRate) {

    if (savingsbalance < 0) {
        throw new IllegalArgumentException("Saldo não pode ser negativo");
    }
    if (annulInterestRate < 0){
        throw new IllegalArgumentException("A taxa de Juros não pode ser negativa.");
    }

    this.savingsbalance = savingsbalance;
    this.annulInterestRate = annulInterestRate;
    }

    //Get e Set
    public double getSavingsBalance(){ return savingsbalance; }
    public double getAnnulInterestRate(){ return annulInterestRate; }
    public void setSavingsBalance(double savingsbalance) { this.savingsbalance = savingsbalance; }
    public void setAnnulInterestRate(double annulInterestRate) { this.annulInterestRate = annulInterestRate; }

    public void calculateMonthlyInterest(){

        //((1 + annulInterestRate)^(1.0/12) -1);
        //double MonthlyInterest = Math.pow(1 + (annulInterestRate / 100), 1.0 / 12) -1;
        double MonthlyInterest = (annulInterestRate / 100) / 12.0;

        savingsbalance = savingsbalance * (1.0 + MonthlyInterest);

        }
    }
    