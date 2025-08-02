# Q1. Demonstrate exception handling by writing a program to handle NameError for undefined variables.
try:
    print(undeclared_variable)
except NameError as e:
    print("Caught a NameError!")
    print(f"Error message: {e}")
else:
    print("No error occurred.")
finally:
    print("Execution completed.")