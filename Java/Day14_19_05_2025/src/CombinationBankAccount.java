/* Q7. Create a class BankAccount with:
Private fields for accountNumber (String), holderName (String), and balance (double).
Getters and setters for each field.
A method deposit(double amount) to add to the balance.
A method withdraw(double amount) to subtract from the balance (ensure balance doesn’t go negative).
Write a main method to test:
Creating a BankAccount object.
Using getters, setters, deposit(), and withdraw() methods. */
class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }
}
public class CombinationBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Holder Name: " + account.getHolderName());
        System.out.println("Balance: $" + account.getBalance());
        account.deposit(500.0);
        account.withdraw(300.0);
        account.withdraw(1500.0);
        System.out.println("Final Balance: $" + account.getBalance());
    }
}