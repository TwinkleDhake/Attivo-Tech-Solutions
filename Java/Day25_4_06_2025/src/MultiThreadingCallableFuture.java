/* Q5. Callable and Future
Create a thread using Callable and use Future to retrieve the result after the thread execution completes. */
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class FactorialCalculator implements Callable<Long> {
    private final int number;
    public FactorialCalculator(int number) {
        this.number = number;
    }
    @Override
    public Long call() throws Exception {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
            Thread.sleep(100);
        }
        return result;
    }
}
public class MultiThreadingCallableFuture {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to calculate its factorial: ");
            int num = scanner.nextInt();
            ExecutorService executor = Executors.newSingleThreadExecutor();
            FactorialCalculator task = new FactorialCalculator(num);
            Future<Long> future = executor.submit(task);
            try {
                Long result = future.get();
                System.out.println("Factorial of " + num + " is: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error occurred: " + e.getMessage());
            } finally {
                executor.shutdown();
                scanner.close();
            }
        }
    }
}