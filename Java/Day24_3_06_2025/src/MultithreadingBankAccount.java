/* Multi-Threading:
Q1. Write a Java program that demonstrates the concept of multithreading by simulating a bank account system.
Your program should include the following:
A BankAccount class with methods deposit(int amount) and withdraw(int amount).
A shared bank account with an initial balance of 1000.
Multiple threads performing deposit and withdrawal operations concurrently.
Use appropriate synchronization techniques to ensure thread safety.
Log the transactions and the final balance of the account after all threads have completed execution.
Requirements:
Use Thread or Runnable to create and manage threads.
Ensure that the account does not go into a negative balance during concurrent withdrawals.
Print a message if a thread attempts to withdraw an amount that exceeds the available balance.
 */
import java.util.Scanner;
class BankAccount {
    private int balance;
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(int amount, String threadName) {
        balance += amount;
        System.out.println(threadName + " deposited: $" + amount + " | Current Balance: $" + balance);
    }
    public synchronized void withdraw(int amount, String threadName) {
        if (amount > balance) {
            System.out.println(threadName + " attempted to withdraw $" + amount + " but only $" +  balance + " is available. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println(threadName + " withdrew: $" + amount + " | Current Balance: $" + balance);
        }
    }
    public int getBalance() {
        return balance;
    }
}
class Transaction implements Runnable {
    private final BankAccount account;
    private final String threadName;
    private final int[] deposits;
    private final int[] withdrawals;
    public Transaction(BankAccount account, String threadName, int[] deposits, int[] withdrawals) {
        this.account = account;
        this.threadName = threadName;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }
    @Override
    public void run() {
        for (int amount : deposits) {
            account.deposit(amount, threadName);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted during deposit: " + e.getMessage());
            }
        }
        for (int amount : withdrawals) {
            account.withdraw(amount, threadName);
            try {
                Thread.sleep(100);                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted during withdrawal: " + e.getMessage());
            }
        }
    }
}
public class MultithreadingBankAccount {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BankAccount sharedAccount = new BankAccount(1000);
            System.out.println("Enter number of threads: ");
            int threadCount = scanner.nextInt();
            Thread[] threads = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++) {
                System.out.println("Thread " + (i + 1) + ": How much to deposits?");
                int depCount = scanner.nextInt();
                int[] deposits = new int[depCount];
                for (int j = 0; j < depCount; j++) {
                    System.out.println("Enter deposit " + (j + 1) + " : ");
                    deposits[j] = scanner.nextInt();
                }
                System.out.println("Thread " + (i + 1) + ": How much withdrawals?");
                int withCount = scanner.nextInt();
                int[] withdrawals = new int[withCount];
                for (int j = 0; j < withCount; j++) {
                    System.out.println("Enter withdrawal " + (j + 1) + " : ");
                    withdrawals[j] = scanner.nextInt();
                }
                threads[i] = new Thread(new Transaction(sharedAccount, "Thread-" + (i + 1), deposits, withdrawals));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Main thread interrupted: " + e.getMessage());
                }
            }
            System.out.println("Final balance: $" + sharedAccount.getBalance());
        }
    }
}