import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

//inheritance concept used here as Menu class extends or inherits the properties of Accounts class
public class Menu extends Accounts{
    Scanner menuInput = new Scanner(System.in);
    //to denote what kind of money format we have
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //HashMap is storing some account details that include Acc NO ----> Pin
    HashMap<Integer, Integer> data = new HashMap<>();

    /**
     * @throws IOException
     */
    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                //this is sample data given in order to check if some accounts are present or not
                data.put(102030, 1122);
                data.put(102031, 1123);

                System.out.println("Welcome to the ATM Project");
                System.out.println("Enter your Account Number: ");
                setAccountNumber(menuInput.nextInt());  //here is a function to add a new Account number if it does not exist

                System.out.println("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());  //it will set your PIN for your Account Number
            }
            catch(Exception  e){ //we will get an exception when the user is entering any characters or symbols. Only Digits are allowed
                System.out.println("Invalid Character(s). Please enter only digits/numbers"+ "\n");
                x = 2;
            }

            //After the successfull completion of setting acc number and pin we fetch those details and add them to our HashMap to make our database

            int AccNo = getAccountNumer();
            int PinNo = getPinNumber(); // these two methods or functions will get us the acc number and pin number if it exists in the Hashmap

            if(data.containsKey(AccNo) && data.get(AccNo) == PinNo){ //only if the account details match in the HashMap, we get the account type
                getAccountType();  
            }
            else{
                System.out.println("\n" + "Wrong Account Number or PIN Number" + "\n");
            }     
        }
        while(x ==1);
    }

    
    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 : Current Account");
        System.out.println("Type 2 : Savings Account");
        System.out.println("Type 3 : Exit ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
                getCurrent();  //inorder to go into our current account section
                break;

            case 2:
                getSavings();  //inorder to go to our savings account section
                break;

            case 3:
                System.out.println("Thank you for using the ATM, Bye " + "\n");
                break;

            default:
                System.out.println("\n"+ "Invalid choice entered. " + "\n");
                getAccountType(); //it will take as back to the selection of account type section when wrong choice is entered
        }

    }

    
    public double getCurrent(){
        System.out.println("Current Account: ");
        System.out.println("Type 1 : View Balance ");
        System.out.println("Type 2 : Withdraw Balance ");
        System.out.println("Type 3 : Deposit Balance ");
        System.out.println("Type 4 : Exit ");
        System.out.print("Choice : ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
               System.out.println("Current Account Balance: " + moneyFormat.format(getCurrent()));
               getAccountType();
               break;
            case 2:
               getCurrentWithdrawInput();
               getAccountType();
               break;
            case 3:
               getCurrentDepositInput();
               getAccountType();
               break;
            case 4:
               System.out.println("Thank you for using this E-CASH ATM, Bye.");
               break;
            default:
               System.out.println("\n" +"Invalid Choice." + "\n");
               getCurrent();
        }
        return selection;
    }


    public double getSavings(){
        System.out.println("SagetSavings Account: ");
        System.out.println("Type 1 : View Balance ");
        System.out.println("Type 2 : Withdraw Balance ");
        System.out.println("Type 3 : Deposit Balance ");
        System.out.println("Type 4 : Exit ");
        System.out.print("Choice : ");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1:
               System.out.println("Savings Account Balance: " + moneyFormat.format(getSavings()));
               getAccountType();
               break;
            case 2:
               getSavingsWithdrawInput();
               getAccountType();
               break;
            case 3:
               getSavingsDepositInput();
               getAccountType();
               break;
            case 4:
               System.out.println("Thank you for using this E-CASH ATM, Bye.");
               break;
            default:
               System.out.println("\n" +"Invalid Choice." + "\n");
               getSavings();
        }
        return selection;
    }

}
