/* Q4. Thread Communication
Write a program where two threads communicate using the wait() and notify() methods to print even and odd numbers alternately. */
import java.util.Scanner;
class NumberPrinter {
    private int number = 1;
    private final int max;
    public NumberPrinter(int max) {
        this.max = max;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public synchronized void printOdd() {
        while (number <= max) {
            if (number % 2 == 0) {
                try {
                    wait(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Odd: " + number);
                number++;
                notify(); 
            }
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public synchronized void printEven() {
        while (number <= max) {
            if (number % 2 == 1) {
                try {
                    wait(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Even: " + number);
                number++;
                notify();
            }
        }
    }
}
class OddThread extends Thread {
    private final NumberPrinter printer;
    public OddThread(NumberPrinter printer) {
        this.printer = printer;
    }
    @Override
    public void run() {
        printer.printOdd();
    }
}
class EvenThread extends Thread {
    private final NumberPrinter printer;
    public EvenThread(NumberPrinter printer) {
        this.printer = printer;
    }
    @Override
    public void run() {
        printer.printEven();
    }
}
public class MultiThreadingThreadCommunication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the maximum number to print: ");
            int max = scanner.nextInt();
            NumberPrinter printer = new NumberPrinter(max);
            Thread oddThread = new OddThread(printer);
            Thread evenThread = new EvenThread(printer);
            oddThread.start();
            evenThread.start();
            try {
                oddThread.join();
                evenThread.join();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Finished printing even and odd numbers alternately.");
    }
}