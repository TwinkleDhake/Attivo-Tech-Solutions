""" Q8. Write a program to handle exceptions in a calculator application (handle ZeroDivisionError, ValueError, and more).
Write a Python program that acts as a calculator and performs the following operations: addition, subtraction, multiplication, and division. 
The user should input the operation and two numbers.
However, the program must be able to handle the following exceptions using try-except blocks:
1.	Invalid operator input – if the user enters an operator other than +, -, *, or /, raise a ValueError with an appropriate message.
2.	Non-numeric input – if the user inputs something that is not a number for the operands, catch and handle the ValueError.
3.	Division by zero – handle ZeroDivisionError gracefully.
4.	General exception – catch any other unforeseen exception. """

def calculator():
    while True:
        try:
            op = input("Enter operation (+, -, *, /) or 'q' to quit: ").strip()
            if op.lower() == 'q': # makes the check case-insensitive
                print("Goodbye!")
                break        
            if op not in ['+', '-', '*', '/']:
                raise ValueError("Invalid operator! Choose from +, -, *, /.")
            n1 = input("Enter first number: ").strip()
            n2 = input("Enter second number: ").strip()
            n1 = float(n1)
            n2 = float(n2)
            if op == '+':
                result = n1 + n2
            elif op == '-':
                result = n1 - n2
            elif op == '*':
                result = n1 * n2
            else:  # division
                result = n1 / n2
            print(f"Result: {result}")
        except ValueError as ve:
            print(f"ValueError: {ve}")
        except ZeroDivisionError:
            print("Error: Cannot divide by zero!")
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
calculator()