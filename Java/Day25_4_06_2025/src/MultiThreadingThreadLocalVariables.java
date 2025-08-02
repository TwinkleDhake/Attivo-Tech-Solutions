/* Q8. Thread Local Variables
Demonstrate the use of ThreadLocal in Java by creating a multi-threaded application 
where each thread maintains its own copy of a variable, such as a user session ID. */
import java.util.Scanner;
import java.util.UUID;
class SessionManager {
    private static final ThreadLocal<String> sessionId = ThreadLocal.withInitial(() -> null);
    private static final ThreadLocal<String> userName = ThreadLocal.withInitial(() -> null);
    public static void startSession(String user) {
        sessionId.set(UUID.randomUUID().toString());
        userName.set(user);
        System.out.println(Thread.currentThread().getName() + " - User: " + user + ", Session ID: " + sessionId.get());
    }
    public static void showSessionInfo() {
        System.out.println(Thread.currentThread().getName() + " - Session Info => User: " + userName.get() + ", Session ID: " + sessionId.get());
    }
    public static void endSession() {
        System.out.println(Thread.currentThread().getName() + " - Ending session for User: " + userName.get());
        sessionId.remove();
        userName.remove();
    }
}
class UserSessionTask implements Runnable {
    private final String user;

    public UserSessionTask(String user) {
        this.user = user;
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        SessionManager.startSession(user);
        try {
            Thread.sleep((int)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SessionManager.showSessionInfo();
        SessionManager.endSession();
    }
}
public class MultiThreadingThreadLocalVariables {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of users: ");
            int userCount = scanner.nextInt();
            scanner.nextLine();
            Thread[] threads = new Thread[userCount];
            for (int i = 0; i < userCount; i++) {
                System.out.print("Enter name for user " + (i + 1) + ": ");
                String user = scanner.nextLine();
                threads[i] = new Thread(new UserSessionTask(user), "Thread-" + (i + 1));
                threads[i].start();
            }
            for (int i = 0; i < userCount; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("All sessions completed.");
    }
}