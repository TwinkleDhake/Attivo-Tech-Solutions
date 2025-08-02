/* Q1. Basic Thread Creation
Write a Java program to create and start a thread using:
Extending the Thread class.
Implementing the Runnable interface. */
import java.util.Scanner;
class MessageThread extends Thread {
    private final String message;
    public MessageThread(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println("Message from MessageThread: " + message);
    }
}
class MessageRunnable implements Runnable {
    private final String message;

    public MessageRunnable(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println("Message from MessageRunnable: " + message);
    }
}
public class MultiThreadingThread {
    public static void main(String[] args) {
        // Input for thread using Thread class
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter message for MessageThread: ");
            String threadMessage = scanner.nextLine();
            System.out.print("Enter message for MessageRunnable: ");
            String runnableMessage = scanner.nextLine();
            MessageThread t1 = new MessageThread(threadMessage);
            t1.start();
            MessageRunnable runnable = new MessageRunnable(runnableMessage);
            Thread t2 = new Thread(runnable);
            t2.start();
        }
    }
}