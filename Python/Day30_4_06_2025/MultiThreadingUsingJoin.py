""" Q2. Using join
Create a program that launches three threads. 
Ensure that the main thread waits for all threads to complete before printing "All threads are done." """
import threading
import time
def task(thread_name):
    print(f"{thread_name} is starting.")
    time.sleep(2)
    print(f"{thread_name} has finished.")
thread_names = []
for i in range(1, 4):
    name = input(f"Enter name for thread {i}: ")
    thread_names.append(name)
threads = []
for name in thread_names:
    t = threading.Thread(target=task, args=(name,))
    threads.append(t)
    t.start()
for t in threads:
    t.join()
print("All threads are done.")