/* Q7. Fork/Join Framework
Implement a program using the Fork/Join Framework in Java to perform a recursive task, 
such as summing up a large array of integers by dividing it into smaller chunks. */
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
class ArraySum extends RecursiveTask<Long> {
    private static final int THRESHOLD = 100;
    private final int[] array;
    private final int start;
    private final int end;
    public ArraySum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            ArraySum leftTask = new ArraySum(array, start, mid);
            ArraySum rightTask = new ArraySum(array, mid, end);
            leftTask.fork(); 
            long rightResult = rightTask.compute(); 
            long leftResult = leftTask.join();
            return leftResult + rightResult;
        }
    }
}
public class MultiThreadingForkJoinFramework {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter size of the array: ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            Random random = new Random();
            System.out.println("Filling array with random integers...");
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(100);
            }
            ForkJoinPool pool = new ForkJoinPool();
            try {
                ArraySum task = new ArraySum(array, 0, array.length);
                long totalSum = pool.invoke(task);
                System.out.println("Total sum of array elements: " + totalSum);
            } finally {
                pool.shutdown();
            }
        }
    }
}