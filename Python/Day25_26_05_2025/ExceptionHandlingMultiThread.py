# Q7. Write a program to demonstrate exception handling in a multi-threaded Python program.
import threading
import time
def exception_handle_multi_thread(name, divisor):
    try:
        print(f"[{name}] Starting task...")
        time.sleep(1)
        result = 10 / divisor
        print(f"[{name}] Result: {result}")
    except ZeroDivisionError:
        print(f"[{name}] Error: Cannot divide by zero.")
    except Exception as e:
        print(f"[{name}] Unexpected error: {e}")
    finally:
        print(f"[{name}] Task complete.\n")
def run_threads():
    threads = []
    divisors = [2, 0, 5, 'a']
    for i, d in enumerate(divisors):
        t = threading.Thread(target=exception_handle_multi_thread, args=(f"Thread-{i+1}", d))
        threads.append(t)
        t.start()
    for t in threads:
        t.join()
    print("All threads have finished.")
run_threads()