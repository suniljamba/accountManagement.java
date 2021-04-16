package SUNILKUMAR_c0785564_A7;
import java.util.ArrayList;
import java.util.Scanner;


class bank_Account{
    //Class member variables
    long account_No;
    String account_Holder;
    double balance;

    //Parameterised Constructor
    public bank_Account(long account_No, String accountHolder) {
        this.account_No = account_No;
        this.account_Holder = accountHolder;
        this.balance = 0.0;
    }
    //Getters
    public long getaccount_No() { return account_No; }
    public String getAccountHolder() { return account_Holder; }
    public double getBalance() { return balance; }

    //Setters
    public void setaccount_No(long account_No) { this.account_No = account_No; }
    public void setAccountHolder(String accountHolder) { this.account_Holder = accountHolder; }
    public void setBalance(double balance) { this.balance = balance; }

    //Deposit
    void deposit(double money){ this.balance += money; }
    //Withdraw money
    void withdraw(double money){ this.balance -= money; }

    public String toString(){
        //return String.format("%-20s : %d\n%-20s : %s\n%-20s : %.2f\n","Account No. ",account_No,"Account Holder " ,accountHolder,"Balance ",this.balance);
        return String.format("Account No. \t" + account_No +"\nAccount Holder \t" + account_Holder + "\nBalance \t\t" + this.balance);
    }
}

public class accountManagement {
    static ArrayList<bank_Account> accounts = new ArrayList();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        while (option != 5) {
            System.out.println("1. Create an account.");
            System.out.println("2. Deposit money.");
            System.out.println("3. Withdraw money.");
            System.out.println("4. Check Balance.");
            System.out.println("5. Quit");
            System.out.print("Select an option from menu : ");
            option = s.nextInt();
            switch (option) {
                case 1:
                    create_Acc();
                    break;
                case 2:
                    deposit_Amount();
                    break;
                case 3 : withdraw_Amount();
                    break;
                case 4 : checkBalance();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please select a valid option: ");
                    break;
            }
        }
    }

    public static void create_Acc() {
        long account_No;
        String name;
        boolean exists = false;
        System.out.print("Enter account number : ");
        account_No = s.nextLong();
        while (String.valueOf(account_No).length() != 6 || account_No < 0) {
            System.out.println("Enter valid account number.");
            System.out.print("Enter account number : ");
            account_No = s.nextLong();
        }
        System.out.print("Enter account holder name : ");
        s.nextLine();
        name = s.nextLine();
        if (accounts.size() > 0) {
            for (bank_Account a : accounts) {
                if (a.account_No == account_No) {
                    exists = true;
                    System.out.println("Account already Registered");
                }
            }
            if (!exists) {
                accounts.add(new bank_Account(account_No, name));
                System.out.println(" Congrats Account created successfully! ");
            }
        } else {
            accounts.add(new bank_Account(account_No, name));
            System.out.println(" Congrats Account created successfully! ");
        }
    }

    public static void deposit_Amount() {
        double amount;
        long account_No;
        boolean exists = false;
        if (accounts.size() > 0) {
            System.out.print("Enter account number : ");
            account_No = s.nextLong();
            for (bank_Account a : accounts) {
                if (a.account_No == account_No) {
                    exists = true;
                    System.out.print("Enter amount to deposit : ");
                    amount = s.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Please enter amount greater than 0.");
                        System.out.print("Enter amount to deposit : ");
                        amount = s.nextDouble();
                    }
                    a.deposit(amount);
                    //System.out.println(a.toString());
                    System.out.println(" Congrats Amount deposited successfully ");
                }
            }
        }
    }

    private static void withdraw_Amount() {
        double amount;
        System.out.print("Enter account number : ");
        long account_No = s.nextLong();
        for (bank_Account a : accounts) {
            if (a.account_No == account_No) {
                System.out.println(a.toString());
                System.out.print("Enter amount to withdraw : ");
                amount = s.nextDouble();
                a.withdraw(amount);
                System.out.println(a.toString());
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number : ");
        long account_No = s.nextLong();
        for (bank_Account a : accounts) {
            if (a.account_No == account_No) {
                System.out.println(a.toString());
            }
        }
    }

}