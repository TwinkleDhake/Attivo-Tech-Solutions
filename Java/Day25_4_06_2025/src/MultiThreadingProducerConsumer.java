/* Q3. Producer-Consumer Problem
Implement a solution for the Producer-Consumer problem using wait() and notify(). */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int maxSize;
    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait(); 
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notify();  
    }
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notify(); 
        return item;
    }
}
class Producer extends Thread {
    private final Buffer buffer;
    private final int itemsToProduce;
    public Producer(Buffer buffer, int itemsToProduce) {
        this.buffer = buffer;
        this.itemsToProduce = itemsToProduce;
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        try {
            for (int i = 1; i <= itemsToProduce; i++) {
                buffer.produce(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer extends Thread {
    private final Buffer buffer;
    private final int itemsToConsume;
    public Consumer(Buffer buffer, int itemsToConsume) {
        this.buffer = buffer;
        this.itemsToConsume = itemsToConsume;
    }
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        try {
            for (int i = 1; i <= itemsToConsume; i++) {
                buffer.consume();
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadingProducerConsumer {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter buffer size: ");
            int bufferSize = scanner.nextInt();
            System.out.print("Enter number of items to produce/consume: ");
            int itemCount = scanner.nextInt();
            Buffer buffer = new Buffer(bufferSize);
            Producer producer = new Producer(buffer, itemCount);
            Consumer consumer = new Consumer(buffer, itemCount);
            producer.start();
            consumer.start();
            try {
                producer.join();
                consumer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Production and consumption completed.");
    }
}