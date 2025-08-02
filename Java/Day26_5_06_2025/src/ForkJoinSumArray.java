import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumArray {
    static class ArraySumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 100;
        private final int[] array;
        private final int start;
        private final int end;
        public ArraySumTask(int[] array, int start, int end) {
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
                ArraySumTask left = new ArraySumTask(array, start, mid);
                ArraySumTask right = new ArraySumTask(array, mid, end);
                left.fork();
                long rightResult = right.compute();
                long leftResult = left.join();
                return leftResult + rightResult;
            }
        }
    }
    public static void main(String[] args) {
        int size = 1000;
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        try (ForkJoinPool pool = new ForkJoinPool()) {
            try {
                ArraySumTask task = new ArraySumTask(array, 0, array.length);
                long total = pool.invoke(task);
                System.out.println("Total sum = " + total);
            } finally {
                pool.shutdown();
            }
        }
    }
}