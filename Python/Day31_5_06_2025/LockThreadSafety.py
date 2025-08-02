""" Q2. Thread Safety Demonstration
Without using a lock, demonstrate a race condition where multiple threads increment a shared counter. 
Then, fix the race condition using the Lock class. """
import threading
import time
counter = 0
counter_lock = threading.Lock()
def increment_without_lock(times):
    global counter
    for _ in range(times):
        temp = counter
        temp += 1
        counter = temp
def increment_with_lock(times):
    global counter
    for _ in range(times):
        with counter_lock:
            temp = counter
            temp += 1
            counter = temp
def run_threads(task_function, num_threads, increments_per_thread):
    global counter
    counter = 0  
    threads = []
    for _ in range(num_threads):
        thread = threading.Thread(target=task_function, args=(increments_per_thread,))
        threads.append(thread)
        thread.start()
    for thread in threads:
        thread.join()
    return counter
def ThreadSafety():
    print("Thread Safety Demonstration")
    num_threads = int(input("Enter number of threads: "))
    increments_per_thread = int(input("Enter number of increments per thread: "))
    print("\n--- Running WITHOUT Lock ---")
    result_without_lock = run_threads(increment_without_lock, num_threads, increments_per_thread)
    print(f"Final counter value without lock: {result_without_lock} (Expected: {num_threads * increments_per_thread})")
    print("\n--- Running WITH Lock ---")
    result_with_lock = run_threads(increment_with_lock, num_threads, increments_per_thread)
    print(f"Final counter value with lock: {result_with_lock} (Expected: {num_threads * increments_per_thread})")
if __name__ == "__main__":
    ThreadSafety()