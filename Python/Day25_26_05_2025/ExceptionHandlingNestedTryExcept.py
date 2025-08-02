# Q4. Develop a program to handle exceptions when working with nested try-except blocks.
def exception_handle_nested_try_except():
    try:
        print("Outer try block started.")
        n1 = int(input("Enter the first number: "))
        n2 = int(input("Enter the second number: "))
        try:
            result = n1 / n2
            print("Result of division:", result)
        except ZeroDivisionError:
            print("Inner Exception: Cannot divide by zero.")
        try:
            list = [10, 20, 30]
            index = int(input("Enter an index to access (0-2): "))
            print("Element at index", index, "is", list[index])
        except IndexError:
            print("Inner Exception: List index is out of range.")
        print("Outer try block completed.")
    except ValueError:
        print("Outer Exception: Invalid input. Please enter integers only.")
    except Exception as e:
        print("Outer Exception: An unexpected error occurred:", str(e))
exception_handle_nested_try_except()