/* Q2. Thread Synchronization
Write a program to demonstrate thread synchronization using the synchronized keyword.
Example: Create a shared resource (e.g., a counter) and ensure multiple threads increment it correctly without data corruption. */
import java.util.Scanner;
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
class CounterTask implements Runnable {
    private final Counter counter;
    private final int increments;

    public CounterTask(Counter counter, int increments) {
        this.counter = counter;
        this.increments = increments;
    }
    @Override
    public void run() {
        for (int i = 0; i < increments; i++) {
            counter.increment();
        }
    }
}
public class MultiThreadingSync {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of threads: ");
            int numThreads = scanner.nextInt();
            System.out.print("Enter number of increments per thread: ");
            int incrementsPerThread = scanner.nextInt();
            Counter counter = new Counter();
            Thread[] threads = new Thread[numThreads];
            for (int i = 0; i < numThreads; i++) {
                threads[i] = new Thread(new CounterTask(counter, incrementsPerThread));
                threads[i].start();
            }
            for (int i = 0; i < numThreads; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Final Counter Value: " + counter.getCount());
        }
    }
}