# Q6. Create a decorator function that catches and handles exceptions raised in the decorated function.
def exception_handle_raised(func):
    def wrapper(*args, **kwargs):
        try:
            print(f"Calling function '{func.__name__}' with args={args}, kwargs={kwargs}")
            return func(*args, **kwargs)
        except Exception as e:
            print(f"An exception occurred in '{func.__name__}': {e}")
    return wrapper
@exception_handle_raised
def divide(a, b):
    return a / b
@exception_handle_raised
def access_list_element(lst, index):
    return lst[index]
print("Result of division:", divide(10, 2))
print("Result of division:", divide(5, 0))
print("List access:", access_list_element([1, 2, 3], 5))