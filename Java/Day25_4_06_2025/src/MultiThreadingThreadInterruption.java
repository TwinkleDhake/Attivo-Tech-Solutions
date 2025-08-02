/* Q6. Thread Interruption
Write a program to demonstrate how thread interruption works in Java. 
Create a thread that performs a long-running task (e.g., a loop) and interrupt it gracefully using the Thread.interrupt() method. */
import java.util.Scanner;
class LongRunningTask extends Thread {
    private final int maxCount;
    public LongRunningTask(int maxCount) {
        this.maxCount = maxCount;
    }
    @Override
    public void run() {
        for (int i = 1; i <= maxCount; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread was interrupted. Exiting gracefully...");
                return;
            }
            System.out.println("Processing: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted during sleep. Exiting gracefully...");
                return;
            }
        }
        System.out.println("Task completed without interruption.");
    }
}
public class MultiThreadingThreadInterruption {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of steps for the task (e.g., 20): ");
            int steps = scanner.nextInt();
            LongRunningTask task = new LongRunningTask(steps);
            task.start();
            System.out.print("Enter delay in seconds before interrupting the thread (e.g., 3): ");
            int interruptAfterSeconds = scanner.nextInt();
            try {
                Thread.sleep(interruptAfterSeconds * 1000);
                System.out.println("Requesting thread interruption...");
                task.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
}