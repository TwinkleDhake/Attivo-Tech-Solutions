""" Q6. Dining Philosophers Problem
Implement the Dining Philosophers Problem using the Lock class to prevent deadlocks and ensure that 
no two philosophers pick up the same fork simultaneously. """
import threading
import time
import random
def philosopher(philosopher_id, left_fork, right_fork, eat_time, think_time, reverse=False):
    for _ in range(3): 
        print(f"Philosopher {philosopher_id} is thinking.")
        time.sleep(random.uniform(1, think_time)) 
        if reverse:
            first, second = right_fork, left_fork
        else:
            first, second = left_fork, right_fork
        print(f"Philosopher {philosopher_id} is hungry and trying to pick up forks.")
        with first:
            print(f"Philosopher {philosopher_id} picked up first fork.")
            with second:
                print(f"Philosopher {philosopher_id} picked up second fork.")
                print(f"Philosopher {philosopher_id} is eating.")
                time.sleep(random.uniform(1, eat_time)) 
                print(f"Philosopher {philosopher_id} has finished eating and put down forks.")
def LockDiningPhilosophers():
    n = int(input("Enter number of philosophers (e.g., 5): "))
    eat_time = float(input("Enter max eating duration (seconds): "))
    think_time = float(input("Enter max thinking duration (seconds): "))
    forks = [threading.Lock() for _ in range(n)]
    philosophers = []
    for i in range(n):
        left_fork = forks[i]
        right_fork = forks[(i + 1) % n]
        reverse = (i == n - 1)
        t = threading.Thread(
            target=philosopher,
            args=(i + 1, left_fork, right_fork, eat_time, think_time, reverse)
        )
        philosophers.append(t)
    for t in philosophers:
        t.start()
    for t in philosophers:
        t.join()
    print("\nAll philosophers have finished their meals.")
if __name__ == "__main__":
    LockDiningPhilosophers()