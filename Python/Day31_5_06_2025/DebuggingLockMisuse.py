""" Q7. Debugging Lock Misuse
Write a program with a deliberate bug where a lock is not released after use. 
Identify and fix the issue using proper locking techniques. """
import threading
import time
counter = 0
lock = threading.Lock()
def buggy_increment(thread_id, increments):
    global counter
    for i in range(increments):
        print(f"[Thread {thread_id}] Attempting to acquire lock...")
        lock.acquire()
        print(f"[Thread {thread_id}] Acquired lock.")
        counter += 1
        print(f"[Thread {thread_id}] Counter: {counter}")
        if i == 0:
            print(f"[Thread {thread_id}] Simulating forgotten release...")
            break
        lock.release()
def DebuggingLockMisuse():
    num_threads = int(input("Enter number of threads: "))
    increments_per_thread = int(input("Enter number of increments per thread: "))
    threads = []
    for i in range(num_threads):
        t = threading.Thread(target=buggy_increment, args=(i+1, increments_per_thread))
        threads.append(t)
        t.start()
    for t in threads:
        t.join(timeout=5)
    print(f"\nFinal counter value: {counter}")
    print("If threads are hanging, the lock wasn't released correctly.")
if __name__ == "__main__":
    DebuggingLockMisuse()