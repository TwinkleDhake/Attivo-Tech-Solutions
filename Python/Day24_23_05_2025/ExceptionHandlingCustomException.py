# Q4. Create a Python program that raises a custom exception if the input is not a positive number.
class NotPositiveError(Exception):
    pass
try:
    num = float(input("Enter a positive number: "))
    if num <= 0:
        raise NotPositiveError
    print("You entered:", num)
except NotPositiveError:
    print("Error: Number is not positive.")
except ValueError:
    print("Error: Invalid number.")