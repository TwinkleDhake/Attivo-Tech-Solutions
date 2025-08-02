""" Q7. Thread Pooling with ThreadPoolExecutor
Write a program to calculate the factorial of multiple numbers concurrently using concurrent.futures.ThreadPoolExecutor. """
import concurrent.futures
import math
def compute_factorial(n):
    result = math.factorial(n)
    print(f"Factorial of {n} is {result}")
    return result
user_input = input("Enter numbers separated by spaces: ")
numbers = list(map(int, user_input.strip().split()))
with concurrent.futures.ThreadPoolExecutor() as executor:
    futures = [executor.submit(compute_factorial, num) for num in numbers]
    for future in concurrent.futures.as_completed(futures):
        future.result()