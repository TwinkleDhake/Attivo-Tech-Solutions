""" Q3. Deadlock Avoidance
Write a Python program where two threads try to acquire two locks in reverse order, leading to a potential deadlock. 
Modify the code to avoid deadlock using proper locking strategies. """
import threading
import time
lock_a = threading.Lock()
lock_b = threading.Lock()
DELAY = 0.1
def deadlock_1():
    print("Thread 1: Trying to acquire lock A")
    lock_a.acquire()
    print("Thread 1: Acquired lock A")
    time.sleep(DELAY)
    print("Thread 1: Trying to acquire lock B")
    lock_b.acquire()
    print("Thread 1: Acquired lock B")
    print("Thread 1: Doing work...")
    lock_b.release()
    lock_a.release()
def deadlock_2():
    print("Thread 2: Trying to acquire lock B")
    lock_b.acquire()
    print("Thread 2: Acquired lock B")
    time.sleep(DELAY)
    print("Thread 2: Trying to acquire lock A")
    lock_a.acquire()
    print("Thread 2: Acquired lock A")
    print("Thread 2: Doing work...")
    lock_a.release()
    lock_b.release()
def no_deadlock(name, first_lock, second_lock):
    print(f"{name}: Trying to acquire first lock")
    with first_lock:
        print(f"{name}: Acquired first lock")
        time.sleep(DELAY)
        print(f"{name}: Trying to acquire second lock")
        with second_lock:
            print(f"{name}: Acquired second lock")
            print(f"{name}: Doing work...")
def DeadlockAvoidance():
    print("1. Deadlock Example")
    choice = input("Enter 'y' to run with deadlock, 'n' to run safe version: ").strip().lower()
    if choice == 'y':
        t1 = threading.Thread(target=deadlock_1)
        t2 = threading.Thread(target=deadlock_2)
    else:
        print("\n2. Deadlock Avoidance Using Lock Ordering")
        t1 = threading.Thread(target=no_deadlock, args=("Thread 1", lock_a, lock_b))
        t2 = threading.Thread(target=no_deadlock, args=("Thread 2", lock_a, lock_b)) 
    t1.start()
    t2.start()
    t1.join(timeout=5)
    t2.join(timeout=5)
    if t1.is_alive() or t2.is_alive():
        print("\n[!] Potential deadlock detected.")
    else:
        print("\n[✓] Threads finished successfully.")
if __name__ == "__main__":
    DeadlockAvoidance()