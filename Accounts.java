import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {
    private int AccountNumber;
    private int PinNumber;
    private double CurrentBalance = 0;
    private double SavingsBalance = 0;


    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setAccountNumber(int AccountNumber){ //setters
        this.AccountNumber = AccountNumber;
        return AccountNumber;
    }

    public int getAccountNumer(){ //getters
        return AccountNumber;
    }

    public int setPinNumber(int PinNumber){ //setters
        this.PinNumber = PinNumber;
        return PinNumber;
    }

    public int getPinNumber(){ //getters
        return PinNumber;
    }

    //special getters which are not declared anywhere
    public double getCurrentBalance(){ //getters
        return CurrentBalance;
    }

    public double getSavingsBalance(){ //getters
        return SavingsBalance;
    }

    public double calcCurrentWithdraw(double amount){ 
        CurrentBalance = (CurrentBalance - amount);
        return CurrentBalance;
    }
    public double calcSavingsWithdraw(double amount){
        SavingsBalance = (SavingsBalance - amount);
        return SavingsBalance;
    }

    public double calcCurrentDeposit(double amount){ 
        CurrentBalance = (CurrentBalance + amount);
        return CurrentBalance;
    }
    public double calcSavingsDeposit(double amount){
        SavingsBalance = (SavingsBalance + amount);
        return SavingsBalance;
    }

    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Enter the amount you want to withdraw from Current Account: ");
        double amount = input.nextDouble();

        if((CurrentBalance - amount) >= 0){
            calcCurrentWithdraw(amount);
            System.out.println("New Current Account balance:  " + moneyFormat.format(CurrentBalance));
        }
        else{
            System.out.println("Balance cannot be negative" + "\n");
        }
    }


    public void getSavingsWithdrawInput(){
        System.out.println("Savings Account Balance: " + moneyFormat.format(SavingsBalance));
        System.out.print("Enter the amount you want to withdraw from Savings Account: ");
        double amount = input.nextDouble();

        if((SavingsBalance - amount) >= 0){
            calcSavingsWithdraw(amount);
            System.out.println("New Savings Account balance:  " + moneyFormat.format(SavingsBalance));
        }else{
            System.out.println("Balance cannot be negative" + "\n");
        }
    }

    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Enter the amount you want to Deposit from Current Account: ");
        double amount = input.nextDouble();

        if((CurrentBalance + amount) >= 0){
            calcCurrentDeposit(amount);
            System.out.println("New Current Account balance:  " + moneyFormat.format(CurrentBalance));
        }
        else{
            System.out.println("Balance cannot be negative" + "\n");
        }
    }


    public void getSavingsDepositInput(){
        System.out.println("Savings Account Balance: " + moneyFormat.format(SavingsBalance));
        System.out.print("Enter the amount you want to Deposit from Savings Account: ");
        double amount = input.nextDouble();

        if((SavingsBalance + amount) >= 0){
            calcSavingsDeposit(amount);
            System.out.println("New Savings Account balance:  " + moneyFormat.format(SavingsBalance));
        }else{
            System.out.println("Balance cannot be negative" + "\n");
        }
    }

    






    


}
