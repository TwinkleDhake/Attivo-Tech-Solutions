""" Q5. Producer-Consumer Problem
Use the Lock class to implement a producer-consumer problem where a producer thread produces items, 
and a consumer thread consumes them, ensuring thread-safe access to a shared queue. """
import threading
import time
import random
buffer = []
buffer_size = 5
lock = threading.Lock()
condition = threading.Condition(lock)
def producer(produce_count):
    for i in range(produce_count):
        item = f"item-{i+1}"
        time.sleep(random.uniform(0.2, 0.6)) 
        with condition:
            while len(buffer) >= buffer_size:
                print("Producer waiting: Buffer is full")
                condition.wait()
            buffer.append(item)
            print(f"Producer produced: {item} | Buffer: {buffer}")
            condition.notify()
def consumer(consume_count):
    for _ in range(consume_count):
        time.sleep(random.uniform(0.3, 0.7))
        with condition:
            while not buffer:
                print("Consumer waiting: Buffer is empty")
                condition.wait()
            item = buffer.pop(0)
            print(f"Consumer consumed: {item} | Buffer: {buffer}")
            condition.notify()
def LockProducerConsumer():
    produce_count = int(input("Enter number of items to produce: "))
    consume_count = int(input("Enter number of items to consume: "))
    producer_thread = threading.Thread(target=producer, args=(produce_count,))
    consumer_thread = threading.Thread(target=consumer, args=(consume_count,))
    producer_thread.start()
    consumer_thread.start()
    producer_thread.join()
    consumer_thread.join()
    print("\nAll items have been produced and consumed.")
if __name__ == "__main__":
    LockProducerConsumer()