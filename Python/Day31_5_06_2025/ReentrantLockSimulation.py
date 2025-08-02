""" Q8. Reentrant Lock Simulation
Simulate the functionality of a RLock (Reentrant Lock) using a standard Lock. 
Show how to handle the scenario where a thread tries to acquire a lock it already holds. """
import threading
import time
class SimulatedRLock:
    def __init__(self):
        self._lock = threading.Lock()
        self._owner = None
        self._count = 0
        self._internal_lock = threading.Lock()
    def acquire(self):
        current_thread = threading.get_ident()
        with self._internal_lock:
            if self._owner == current_thread:
                self._count += 1
                print(f"[{current_thread}] Re-acquired lock, count = {self._count}")
                return True
        self._lock.acquire()
        with self._internal_lock:
            self._owner = current_thread
            self._count = 1
            print(f"[{current_thread}] Acquired new lock")
        return True
    def release(self):
        current_thread = threading.get_ident()
        with self._internal_lock:
            if self._owner != current_thread:
                raise RuntimeError("Cannot release a lock that's not owned by this thread.")
            self._count -= 1
            print(f"[{current_thread}] Released lock, remaining count = {self._count}")
            if self._count == 0:
                self._owner = None
                self._lock.release()
    def __enter__(self):
        self.acquire()
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.release()
rlock = SimulatedRLock()
def recursive_function(level, max_level):
    if level > max_level:
        return
    rlock.acquire()
    print(f"Thread {threading.get_ident()} acquired lock at level {level}")
    time.sleep(0.3)
    recursive_function(level + 1, max_level)
    print(f"Thread {threading.get_ident()} releasing lock at level {level}")
    rlock.release()
def ReentrantLockSimulation():
    max_depth = int(input("Enter recursive depth (e.g., 3): "))
    t = threading.Thread(target=recursive_function, args=(1, max_depth))
    t.start()
    t.join()
    print("Simulation complete.")
if __name__ == "__main__":
    ReentrantLockSimulation()