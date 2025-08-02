""" Q1. Thread Creation and Execution
Write a Python program that creates two threads. 
Each thread should print numbers from 1 to 5 with a delay of 1 second between each number. """
import threading
import time
def print_num(thread_name):
    for i in range(1, 6):
        print(f"{thread_name}: {i}")
        time.sleep(1)
name1 = input("Enter name for thread 1: ")
name2 = input("Enter name for thread 2: ")
thread1 = threading.Thread(target=print_num, args=(name1,))
thread2 = threading.Thread(target=print_num, args=(name2,))
thread1.start()
thread2.start()
thread1.join()
thread2.join()
print("Both threads have finished execution.")