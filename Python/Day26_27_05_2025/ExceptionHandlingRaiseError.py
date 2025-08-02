# Q3. Create a program that raises an exception using raise and re-raises it in a try block.
def check_age(age):
    if age < 0:
        raise ValueError("Age cannot be negative!")
try:
    try:
        check_age(-5)
    except ValueError as ve:
        print("Caught an exception in the inner try block:")
        print(f"Error: {ve}")
        print("Re-raising the exception...\n")
        raise  
except ValueError as ve_outer:
    print("Caught the re-raised exception in the outer try block:")
    print(f"Error: {ve_outer}")