/* ATMCode: My first project from my first computing class. Purpose of this project was to create a program that operates like an ATM,
the program prompts the user to verify their account number and pin, then once verified they may perform operations on the account. 
This was done in tandem with other partners so it is quite flawed. One of my partners used a switch statement for exact, set account 
numbers rather than creating a method that allows for different account numbers to be entered into the file. This was my first time 
applying methods. */
	
import java.util.Scanner;
public class ATMcode {
   //declare acctNumber static because we will use all over the class ATMcode
	public static String acctNumber = "";
   //declare arrays with values for each account number
   private static String[] testAccountNumbers = {
        "00000000",
        "00000001",
        "00000002"
    };
    //declare arrays with values for each pin number for each account
   private static String[] testPinNumbers = {
        "1234",
        "7777",
        "0243"
    };
    //declare arrays with values for each balance for each account
   private static int[] testBalances = {
        0, 100, -50
    };

    /**
     * Allows the user to deposit funds into their account.
     * @param actNumber The users account number.
     * @param amount The amount of funds the user wants to deposit.
     * @return True if the funds were successfully deposited, false otherwise.
     */
public static boolean deposit(String actNumber, int amount2) {
	boolean result;
      //switch case to see which account we are operating on
	   switch (acctNumber) {
	   		case "00000000":
                  //deposit always successful so just add deposit to balance and print new balance
	   				testBalances[0] += amount2;
	   				System.out.println("Your new Balance is: $" + testBalances[0]);
	   				result = true;
	   				return result;
	      	case "00000001":
               //deposit always successful so just add deposit to balance and print new balance
   				testBalances[1] += amount2;
   				System.out.println("Your new Balance is: $" + testBalances[1]);
   				result = true;
   				return result;
		     case "00000002":
            //deposit always successful so just add deposit to balance and print new balance
		    	 testBalances[2] += amount2;
	   				System.out.println("Your new Balance is: $" + testBalances[2]);
	   				result = true;
	   				return result;
		     	default:
		    	  result = false;
		    	  return result;
	   }
}


    /**
     * Allows the user to withdraw funds from their account.
     * @param acctNumber The users account number.
     * @param amount The amount of funds the user wants to withdraw.
     * @return True if the funds were successfully withdrawn, false otherwise.
     */
public static boolean withdraw(String acctNumber, int amount) {
	boolean result;
   int a20 = 0; int a10 = 0; int a5 = 0; int a1 = 0;
   //switch statement to choose which account number was entered
   switch (acctNumber) {
   		case "00000000":
            //change balance based on amount and see if a negative value comes out
   			testBalances[0] -= amount;
            //if statement for if new balance is negative, this means withdrawal cannot be processed
   			if (testBalances[0] < 0) {
   				testBalances[0] += amount;
   				System.out.println("Insufficient Funds. Balance: $:" + testBalances[0]);
   				result = false;
   				return result;
   }
               //default to this if withdrawal is successful and provide new balance
   				else {
               //while loops for cash denominations and change amount as demonations are taken from original amount
                  while (amount >= 20) {
                     a20 = amount / 20;
                     amount = amount % 20;
                     break;
                     }
                  while (amount >= 10) {
                     a10 = amount/10;
                     amount = amount % 10;
                     break;
                     }
                  while (amount >= 5) {
                     a5 = amount/5;
                     amount = amount % 5;
                     break;
                     }
                  while (amount >= 1) {
                     a1 = amount/1;
                     amount = amount % 1;
                     break;
                     }
               System.out.println("The ATM spit out " + a20 + " $20 bills, " + a10 + " $10 bills, " + a5 + " $5 bills, and " + a1 + " $1 bills.");
   				System.out.println("Your new balance is " + testBalances[0]);
   				result = true;
   				return result;
            }
      	case "00000001":
      		testBalances[1] -= amount;
   			if (testBalances[1] < 0) {
   				testBalances[1] += amount;
   				System.out.println("Insufficient Funds. Balance: $" + testBalances[1]);
   				result = false;
   				return result;
   }
               //default to this if withdrawal is successful and provide new balance
   				else {
               //while loops for cash denominations and change amount as demonations are taken from original amount
                  while (amount >= 20) {
                     a20 = amount / 20;
                     amount = amount % 20;
                     break;
                     }
                  while (amount >= 10) {
                     a10 = amount/10;
                     amount = amount % 10;
                     break;
                     }
                  while (amount >= 5) {
                     a5 = amount/5;
                     amount = amount % 5;
                     break;
                     }
                  while (amount >= 1) {
                     a1 = amount/1;
                     amount = amount % 1;
                     break;
                     }
               System.out.println("The ATM spit out " + a20 + " $20 bills, " + a10 + " $10 bills, " + a5 + " $5 bills, and " + a1 + " $1 bills.");
   				System.out.println("Your new balance is " + testBalances[1]);
   				result = true;
   				return result;
            }
	     case "00000002":
	    	 	testBalances[2] -= amount;
	   			if (testBalances[2] < 0) {
	   				testBalances[2] += amount;
	   				System.out.println("Insufficient Funds. Balance: $" + testBalances[2]);
	   				result = false;
	   				return result;
	   }
                  //default to this if withdrawal is successful and provide new balance
	   				else {
                  //while loops for cash denominations and change amount as demonations are taken from original amount
                     while (amount >= 20) {
                     a20 = amount / 20;
                     amount = amount % 20;
                     break;
                     }
                  while (amount >= 10) {
                     a10 = amount/10;
                     amount = amount % 10;
                     break;
                     }
                  while (amount >= 5) {
                     a5 = amount/5;
                     amount = amount % 5;
                     break;
                     }
                  while (amount >= 1) {
                     a1 = amount/1;
                     amount = amount % 1;
                     break;
                     }
                  System.out.println("The ATM spit out " + a20 + " $20 bills, " + a10 + " $10 bills, " + a5 + " $5 bills, and " + a1 + " $1 bills.");
	   				System.out.println("Your new balance is " + testBalances[2]);
	   				result = true;
	   				return result;
	            }
	      default:
	    	  result = false;
	    	  return result; } }
   
    /**
     * Checks that the specified account number belongs to a user.
     * @param acctNumber The account number to check.
     * @return True if the account number exist, False otherwise.
     */
public static boolean doesAccountExist(String acctNumber) {
   boolean result = true;
   //definitive loop since we know when to stop, check each account number
   for (int i = 0; i <= 2; i++) {
      int num = acctNumber.compareTo(testAccountNumbers[i]);
   //if statement for if account number matches any of the accounts
      if (num == 0) {
         return result; } }
   //default process if account number does not match any of the accounts
         result = false;
         return result; 
}
    /**
     * Checks that the specified pin matches the pin stored with the
     * account number.
     * @param acctNumber The users account number.
     * @param pin The users pin number.
     * @return True if the pin matches the pin on file for the account, False
     * otherwise.
     */
public static boolean checkPin(String acctNumber, String pin) {
   //for loop for definitive amount of account numbers
   for (int i = 0; i <= 2; i++) {
   //if statements to enter during each loop for each account
      if (i == 0) {
         int num1 = pin.compareTo(testPinNumbers[0]);
   //if statement if account number matches first account number
         if (num1 == 0) {
            boolean result = true;
            return result; } }
      if (i == 1) {
         int num2 = pin.compareTo(testPinNumbers[1]);
   //if statement if account number matches second account number
         if (num2 == 0) {
            boolean result = true;
            return result; } }
      if (i == 2) {
         int num3 = pin.compareTo(testPinNumbers[2]);
   //if statement if account number matches third account number
         if (num3 == 0) {
            boolean result = true;
            return result; } } }
   //default statement if pin doesnt match those for any account number
         System.out.println("ERROR: Incorrect pin, please try again.");
         boolean result = false;
         return result;
}
    /**
     * Runs the ATM application as described in the handout.
     */
public static void start() {
   //declare variables to be used
   boolean doesAccountExist = false;
   boolean checkPin = false;
   boolean accountCorrect = false;
   //while loop to keep program running until correct account number is entered
   while (accountCorrect == false) {
   //Get account number from user
      Scanner UserInput = new Scanner(System.in);
      System.out.println("Enter your account number.");
      acctNumber = UserInput.next();
   //Check account number presence with doesAccountExist function
      doesAccountExist = doesAccountExist(acctNumber);
   //What to do if account isn't in system
      if (doesAccountExist == false) {
         System.out.println("Account number does not exist, try again.");   }
      else {
   //Allow user to enter pin number if account number is present, then check that Pin is correct
         System.out.println("Enter your pin number.");
         String pin = UserInput.next();
         checkPin = checkPin(acctNumber, pin);
   //Check that pin matches account user's pin
         if (checkPin == true) {
            accountCorrect = true;  }
   //Prompt user that pin was incorrect
         else {
            System.out.println("Incorrect pin, try again."); }
} } }

    /**
     * Runs your implementation so it can be tested/graded. 
     * DO NOT MODIFY THIS CODE.
     * @param args Arguments passed in from a CLI or app runner.
     */
public static void main(String[] args) {
   boolean UserActivity = true;
   //call to start() function to begin ATM program
   start();
   Scanner OptionsInput = new Scanner(System.in);
   //while loop to keep program running
   while (UserActivity == true) {
   //prompt user what they would like to do with their account
      System.out.println("Would you like to Withdraw (1), Deposit (2), Check Your Balance (3), or Exit (4)?");
      int SwitchInput = OptionsInput.nextInt();
   //switch case for easy check of which option they chose
      switch(SwitchInput) {
   //case for withdrawing
         case 1: System.out.println("How much would you like to withdraw?");
            Scanner scanner = new Scanner(System.in);
            int amount = scanner.nextInt();
            if (amount < 1) {
            	System.out.println("Amount must be a postitive whole number");
            	break;}
            boolean Bwithdraw = withdraw(acctNumber, amount);
            break;
   //case for deposit
         case 2: System.out.println("How much would you like to deposit?");
         	Scanner scanner2 = new Scanner(System.in);
         	int amount2 = scanner2.nextInt();
         	if (amount2 < 1) {
         	System.out.println("Amount must be a postitive whole number");
         	break;}
         boolean Bdeposit2 = deposit(acctNumber, amount2);
   	   	break;
   //case for checking balance
         case 3:
   //nested switch cases to check which account balance we need to print
        	 switch (acctNumber) {
 	   		case "00000000":
 	   				System.out.println("Balance: $" + testBalances[0]);
 	   				break;
 	   		case "00000001":
    				System.out.println("Balance: $" + testBalances[1]);
    				break;
 		     case "00000002":{
 	   				System.out.println("Balance: $" + testBalances[2]);
 	   				break;
 		            } }
         case 4: System.out.println("DONE");
	   		UserActivity= false;
	   		break;
   //default statement for those who don't follow instructions
         default: System.out.println ("Please enter a whole number between 1-4");
	   		break;
} } } }
