/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_banking_projects;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.*;
/**
 *
 * @author Asus
 */
public class Final_Banking_Projects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {   
        System.out.println("*****************************************************");
        System.out.println("Banking System- Term Project:");
        System.out.println("*****************************************************");
        createCSV();
        List<List<String>> records = readCSV();
//        System.out.println(records);
        System.out.println("Enter your choice:\n1.Login\n2.Create New Account");
        Scanner choiceobj = new Scanner(System.in);
        int choice = choiceobj.nextInt();
        System.out.println("------------------------------------------------------");
        if(choice == 1){
            System.out.println("Enter username");
            Scanner userobj = new Scanner(System.in);
            String username = userobj.nextLine();
            System.out.println("Enter Password");
            Scanner passobj = new Scanner(System.in);
            String password = passobj.nextLine();
            System.out.println("------------------------------------------------------");
            validate(username,password,records);
            transactionOptions(username);
        }
        else if(choice == 2){
            System.out.println("Enter your Name");
            Scanner nameobj = new Scanner(System.in);
            String name = nameobj.nextLine();
            System.out.println("Enter Password");
            Scanner passobj = new Scanner(System.in);
            String pass = passobj.nextLine();
            System.out.println("Enter Account Type");
            Scanner accTypObj = new Scanner(System.in);
            String accTyp = accTypObj.nextLine();
            String accBalance = "0";
            String backNumber = "";
            for(int i=0;i<5;i++){
                int random = (int)(Math.random() * 9);
                backNumber = backNumber + String.valueOf(random);
                System.out.println(backNumber);
            }
            
            String username = name.substring(0,4) + backNumber;
            String accNumber = "";
            for(int i=0;i<9;i++){
                double random = Math.random() * 9;
                accNumber = accNumber + String.valueOf((int)random);
            }
            createAccount(username, pass, name, accNumber, accTyp, accBalance);
            main(null);
        }
        else{
            System.out.println("Invalid Choice");
            main(null);
        }
    }
    public static void createCSV(){
        try {
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\Final_Banking_Projects\\src\\final_banking_projects\\input.csv");
            if (file.createNewFile()) {
            } else {
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<List<String>> readCSV(){

        String line;
        List<List<String>> records = new ArrayList<>();

        int i = 0;
        int j = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\Final_Banking_Projects\\src\\final_banking_projects\\input.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] abc = line.split(",");
                records.add(Arrays.asList(abc));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
            
        return records;
    }
    public static void createAccount(String username, String pass, String name, String accNumber, String accTyp, String accBalance){
        String[][] user = {
                {username, pass, name, accNumber, accTyp, accBalance}
        };
        try {
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\Final_Banking_Projects\\src\\final_banking_projects\\input.csv");
            FileWriter fileWriter = new FileWriter(file,true);
            for (String[] data : user) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < data.length; i++) {
                    line.append(data[i]);
                    if (i != data.length - 1) {
                        line.append(',');
                    }
                }
                line.append("\n");
                fileWriter.write(line.toString());
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Account Createed");
            System.out.println("Username is :" +username);
            System.out.println("Password is :" +pass);
            System.out.println("Account number is :" +accNumber);
            System.out.println("Account Type is :" +accTyp);
            System.out.println("------------------------------------------------------");
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void validate(String username, String password, List<List<String>> records){
        int temp = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            String password_exists = array[1];
            if(username.equals(user_exists)){
                if(password.equals(password_exists)){
                    temp=1;
                }
                else{
                    System.out.println("Invlid Password");
                    System.exit(0);
                }
            }
        }
        if(temp==0){
            System.out.println("Username does not exist");
            System.exit(0);
        }
        else{
            System.out.println("Hello "+username);
        }
    }
    public static int validateAccount(String Account){
        List<List<String>> records = readCSV();
        int temp = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String account_exists = array[3];
            if(Account.equals(account_exists)){
                temp=1;
            }
        }
        return temp;
    }
    public static void writeCSV(List<String> record , int i){
        File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Final_Banking_Project\\Final_Banking_Projects\\src\\final_banking_projects\\input.csv");
        String[] array = record.toArray(new String[record.size()]);
        String[][] user = {
                {array[0], array[1], array[2], array[3], array[4], array[5]}
        };
        if(i==0){
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.flush();
                for (String[] data : user) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < data.length; j++) {
                    line.append(data[j]);
                    if (j != data.length - 1) {
                        line.append(',');
                    }
                }
                line.append("\n");
                writer.write(line.toString());
            }
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
             try {
            FileWriter fileWriter = new FileWriter(file,true);
            for (String[] data : user) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < data.length; j++) {
                    line.append(data[j]);
                    if (j != data.length - 1) {
                        line.append(',');
                    }
                }
                line.append("\n");
                fileWriter.write(line.toString());
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        }
        
        
    }
    public static void transactionOptions(String username)
    {
        System.out.println("------------------------------------------------------");
        Scanner in = new Scanner(System.in);
        System.out.println("1. Make a Deposit \n2. Withdraw money \n3. Transfer money to a different bank");
        System.out.println("4. Transfer money to someone in the same bank \n5. Display current balance \n6. Pay to a merchant \n0. Logout");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                deposit(username);
                break;
            case 2:
                withdraw(username);
                break;
            case 3:
                transfer(username);
                break;
            case 4:
                internalTransfer(username);
                break;
            case 5:
                displayBalance(username);
                break;
            case 6:
                payMerchant(username);
                break;
            default:
                main(null);
         }
    }

    public static void deposit(String username)
    {
        System.out.println("Deposit ammount :");
        Scanner depositobj = new Scanner(System.in);
        double depositAmount = depositobj.nextInt();
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            double amount_exists = Double.parseDouble(array[5]);
            if(username.equals(user_exists)){
                amount_exists = amount_exists + depositAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
                writeCSV(record,i);
                i++;
        }
        transactionOptions(username);    
        
    }
    public static void withdraw(String username)
    {
        System.out.println("Withdraw ammount :");
        Scanner depositobj = new Scanner(System.in);
        double depositAmount = depositobj.nextInt();
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            double amount_exists = Double.parseDouble(array[5]);
            if(username.equals(user_exists)){
                if(amount_exists - depositAmount < 0){
                    System.out.println("Insufficient Balance");
                    transactionOptions(username);
                }
                amount_exists = amount_exists - depositAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
                writeCSV(record,i);
                i++;
        }
        transactionOptions(username);
    }
    public static void transfer(String username)
    {
        System.out.println("Transfer account no. :");
        Scanner accobj = new Scanner(System.in);
        int Account = accobj.nextInt();
        System.out.println("Transfer ammount :");
        Scanner transferobj = new Scanner(System.in);
        double transferAmount = transferobj.nextDouble();
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            double amount_exists = Double.parseDouble(array[5]);
            if(username.equals(user_exists)){
                if(amount_exists - transferAmount < 0){
                    System.out.println("Insufficient Balance");
                    transactionOptions(username);
                }
                amount_exists = amount_exists - transferAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
                writeCSV(record,i);
                i++;
        }
        System.out.println("Transfer Successful to account no. "+Account);
        transactionOptions(username);
    }
    public static void internalTransfer(String username)
    {
        System.out.println("Transfer account no. :");
        Scanner accobj = new Scanner(System.in);
        String Account = accobj.nextLine();
        int temp = validateAccount(Account);
        if(temp == 0){
            System.out.println("This Account is not in our bank");
            transactionOptions(username);
        }
        System.out.println("Transfer ammount :");
        Scanner transferobj = new Scanner(System.in);
        double transferAmount = transferobj.nextDouble();
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            String Account_exists = array[3];
            double amount_exists = Double.parseDouble(array[5]);
            if(username.equals(user_exists)){
                if(amount_exists - transferAmount < 0){
                    System.out.println("Insufficient Balance");
                    transactionOptions(username);
                }
                amount_exists = amount_exists - transferAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
            if(Account.equals(Account_exists)){
                amount_exists = amount_exists + transferAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
                writeCSV(record,i);
                i++;
        }
        
        System.out.println("Transfer Successful to account no. "+Account);
        transactionOptions(username);
    }
    public static void displayBalance(String username)
    {
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            if(username.equals(user_exists)){
                System.out.println("Current Balance is : "+array[5]);
            }

        }
        transactionOptions(username);
    }
    public static void payMerchant(String username)
    {
        System.out.println("1.Hydro\n2.Water & Heat\n3.Rent\n4.Telecom Bill\n5.Grocery");
        Scanner merchantobj = new Scanner(System.in);
        double merchantNo = merchantobj.nextInt();
        String merchantName = "";
        if(merchantNo == 1){
            merchantName = "Hydro";
        }
        if(merchantNo == 2){
            merchantName = "Water & Heat";
        }
        if(merchantNo == 3){
            merchantName = "Rent";
        }
        if(merchantNo == 4){
            merchantName = "Telecom Bill";
        }
        if(merchantNo == 5){
            merchantName = "Grocery";
        }
        else{
            System.out.println("Enter a valid choice");
            payMerchant(username);
        }
        System.out.println("Amount :");
        Scanner depositobj = new Scanner(System.in);
        double depositAmount = depositobj.nextInt();
        List<List<String>> records = readCSV();
        int i = 0;
        for(List<String> record : records){
            String[] array = record.toArray(new String[record.size()]);
            String user_exists = array[0];
            double amount_exists = Double.parseDouble(array[5]);
            if(username.equals(user_exists)){
                if(amount_exists - depositAmount < 0){
                    System.out.println("Insufficient Balance");
                    transactionOptions(username);
                }
                amount_exists = amount_exists - depositAmount;
                array[5] = String.valueOf(amount_exists);
                record.set(5, array[5]);
            }
                writeCSV(record,i);
                i++;
        }
        System.out.println("Successfully Paid "+depositAmount +"to "+ merchantName);
        transactionOptions(username);
    }
    
}
