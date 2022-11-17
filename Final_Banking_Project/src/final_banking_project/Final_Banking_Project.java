package Final_Banking_Project;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Final_Banking_Project {
    public static void main(String[] args)
    {   
        createCSV();
//        List<List<String>> records = readCSV();
//        System.out.println("Enter your choice:\n1.Aleardy User\n2.Create New Account");
//        Scanner choiceobj = new Scanner(System.in);
//        int choice = choiceobj.nextInt();
//        if(choice == 1){
//            System.out.println("Enter your username");
//            Scanner userobj = new Scanner(System.in);
//            String username = userobj.nextLine();
//            System.out.println("Enter your Password");
//            Scanner passobj = new Scanner(System.in);
//            String password = passobj.nextLine();
//            validate(username,password,records);
//        }
//        transactionOptions();
    }
    public static void createCSV(){
        try {
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\src\\final_banking_project\\input.csv");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
//                writeCSV();
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static List<List<String>> readCSV(){
//
//        String line;
//        List<List<String>> records = new ArrayList<>();
//
//        int i = 0;
//        int j = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\src\\final_banking_project\\input.csv"))) {
//            while ((line = br.readLine()) != null) {
//                String[] abc = line.split(",");
//                records.add(Arrays.asList(abc));
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//            
//            return records;
//    }
//    public static void validate(String username, String password, List<List<String>> records){
//        int temp = 0;
//        for(List<String> record : records){
//            String[] array = record.toArray(new String[record.size()]);
//            String user_exists = array[0];
//            String password_exists = array[1];
//            if(username == user_exists){
//                if(password == password_exists){
//                    temp=1;
//                }
//                else{
//                    System.out.println("Invlid Password");
//                    System.exit(0);
//                }
//            }
//        }
//        if(temp==0){
//            System.out.println("Username does not exists");
//            System.exit(0);
//        }
//    }
}
//    public static int transactionOptions()
//    {
//        System.out.println("Banking System- Final Project:");
//        Scanner in = new Scanner(System.in);
//        System.out.println("1. Make a Deposit \n2. Withdraw money \n3. Transfer money to a friend");
//        System.out.println("4. Transfer between accounts \n5. Display current balance \n6. Pay to a merchant");
//        System.out.print("Enter your choice: ");
//        int choice = in.nextInt();
//        return choice;
//    }

//    public static double deposit(double balance, double depositAmount)
//    {
//        balance = balance + depositAmount;
//        return balance;
//    }
//}
//    public static double withdraw()
//    {
//
//    }
//
//    public static double transfer()
//    {
//
//    }
//
//    public static double internalTransfer()
//    {
//
//    }
//    public static double displayBalance()
//    {
//
//    }
//    public static double payMerchant()
//    {
//
//    }
