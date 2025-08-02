/* Q2. Create a BankAccount class with the following features:
Fields: accountNumber, accountHolderName, and balance.
Constructors:
A default constructor to initialize the balance to 0 and the account holder name to "Not specified".
A parameterized constructor to initialize the account number, name, and balance.
Methods:
deposit(double amount) to increase the balance.
withdraw(double amount) to decrease the balance (ensure balance doesn’t go negative).
displayAccountDetails() to display account */
import java.util.Scanner;
public class ConstructorBankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    public ConstructorBankAccount() {
        this.accountNumber = " ";
        this.accountHolderName = "Not Specified";
        this.balance = 0.0;
    }
    public ConstructorBankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid Deposit Amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficienct balance or invalid amount.");
        }
    }
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter Account Number: ");
            String accNum = scanner.nextLine();
            System.out.println("Enter Account Holder Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Initial Balance: ");
            double bal = scanner.nextDouble();
            ConstructorBankAccount account = new ConstructorBankAccount(accNum, name, bal);
            account.displayAccountDetails();
            System.out.println("\n Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
            account.displayAccountDetails();
            scanner.close();
        }
      }
}