import java.util.Scanner;

public class SavingsAccount{
    
    private double savingsBalance;
    private double annualInterestRate;

    public SavingsAccount(){
    }

    public SavingsAccount(double savingsBalance, double annualInterestRate){
            this.savingsBalance = savingsBalance;
            this.annualInterestRate = annualInterestRate;
    }

    public void setSavingsBalance(double savingsBalance){
        if(savingsBalance >= 0){
            this.savingsBalance = savingsBalance;
        } else{
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        if(annualInterestRate >= 0){
            this.annualInterestRate = annualInterestRate;
        } else{
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public static void calculateMonthlyInterest(double annualInterestRate, double savingsBalance){
        Scanner scanner = new Scanner(System.in);
        SavingsAccount sa = new SavingsAccount();
        
        System.out.printf("\nSaldos com taxa de juros de %.1f%%:\n", annualInterestRate);
        int i = 1;
        double monthlyInterest = Math.pow(1.0 + (annualInterestRate/100.0), 1.0/12.0) - 1.0;
        
        while(i != 13){
            savingsBalance =  savingsBalance + savingsBalance * monthlyInterest;
            System.out.printf("Mês %d: R$%.2f\n", i, savingsBalance);
            ++i;
            if(i == 13){
                System.out.print("\nInforme a nova taxa de juros anual: ");
                double newAnnualInterestRate = scanner.nextDouble();
                
                System.out.printf("\nAlterando taxa de juros anual para %.1f%%...\n", newAnnualInterestRate);
                double newMonthlyInterest = Math.pow(1.0 + (newAnnualInterestRate/100.0), 1.0/12.0) - 1.0;
                savingsBalance = savingsBalance + savingsBalance * newMonthlyInterest;
        
                System.out.printf("Mês %d: R$%.2f\n", i, savingsBalance);
                sa.setSavingsBalance(savingsBalance);
            }
        }
    }
}