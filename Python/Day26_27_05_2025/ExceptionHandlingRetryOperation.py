# Q6. Write a Python function that retries an operation multiple times with exception handling.
import time
def retry_operation(operation, max_retries=3, delay=2, exceptions=(Exception,)):
    for attempt in range(1, max_retries + 1):
        try:
            print(f"Attempt {attempt}...")
            result = operation()
            print("Operation succeeded.")
            return result
        except exceptions as e:
            print(f"Operation failed on attempt {attempt}. Error: {e}")
            if attempt < max_retries:
                print(f"Retrying in {delay} seconds...\n")
                time.sleep(delay)
            else:
                print("All retries have been failed. Raising the last exception.")
                raise
import random
def unstable_operation():
    if random.random() < 0.5:
        raise ValueError("Random failure!")
    return "Success!"
result = retry_operation(unstable_operation, max_retries=5, delay=1)
print(f"Final result: {result}")