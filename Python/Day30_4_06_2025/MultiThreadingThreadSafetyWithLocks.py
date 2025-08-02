""" Q3. Thread Safety with Locks
Write a program that uses two threads to increment a shared variable 1000 times each. 
Use a threading.Lock to ensure thread safety. """
import threading
counter = 0
lock = threading.Lock()
def increment():
    global counter
    for _ in range(1000):
        with lock: 
            counter += 1
thread1 = threading.Thread(target=increment)
thread2 = threading.Thread(target=increment)
thread1.start()
thread2.start()
thread1.join()
thread2.join()
print(f"Final counter value: {counter}")