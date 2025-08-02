# Q1. Write a Python program to handle a ZeroDivisionError when dividing two numbers provided by the user.
def divide_numbers():
    try:
        # input from the user
        n = float(input("Enter the numerator: "))
        d = float(input("Enter the denominator: "))
        # division
        result = n / d
        print(f"Result: {result}")
    except ZeroDivisionError:
        print("Error: Cannot be divide by zero.")
    except ValueError:
        print("Error: Please enter valid numbers.")
divide_numbers() # Run