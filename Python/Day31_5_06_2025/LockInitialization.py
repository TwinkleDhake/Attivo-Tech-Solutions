""" Q1. Lock Initialization and Usage
Write a Python program to create a thread-safe counter using the Lock class. 
Demonstrate how to acquire and release the lock. """
import threading
counter = 0
counter_lock = threading.Lock()
def increment_counter(times):
    global counter
    for _ in range(times):
        counter_lock.acquire()
        try:
            counter += 1
        finally:
            counter_lock.release()
def LockInitialization():
    num_threads = int(input("Enter number of threads: "))
    increments_per_thread = int(input("Enter number of increments per thread: "))
    threads = []
    for _ in range(num_threads):
        thread = threading.Thread(target=increment_counter, args=(increments_per_thread,))
        threads.append(thread)
        thread.start()
    for thread in threads:
        thread.join()
    print(f"Final counter value: {counter}")
if __name__ == "__main__":
    LockInitialization()