""" Q4. Passing Arguments to Threads
Write a Python program where a thread function accepts arguments. 
Pass a list of numbers to the thread function, and the function should print the square of each number. """
import threading
def print_squares(n):
    for num in n:
        print(f"Square of {num}: {num ** 2}")
user_input = input("Enter numbers separated by spaces: ")
num_list = list(map(int, user_input.strip().split()))
thread = threading.Thread(target=print_squares, args=(num_list,))
thread.start()
thread.join()
print("Finished printing squares.")