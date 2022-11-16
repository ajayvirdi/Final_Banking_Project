import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        transactionOptions();
    }

    public static int transactionOptions()
    {
        System.out.println("Banking System- Final Project:");
        Scanner in = new Scanner(System.in);
        System.out.println("1. Make a Deposit \n2. Withdraw money \n3. Transfer money to a friend");
        System.out.println("4. Transfer between accounts \n5. Display current balance \n6. Pay to a merchant");
        System.out.print("Enter your choice: ");
        var choice = in.nextInt();
        return choice;
    }

    public static double deposit(double balance, double depositAmount)
    {
        balance = balance + depositAmount;
        return balance;
    }

    public static double withdraw()
    {

    }

    public static double transfer()
    {

    }

    public static double internalTransfer()
    {

    }
    public static double displayBalance()
    {

    }
    public static double payMerchant()
    {

    }
}