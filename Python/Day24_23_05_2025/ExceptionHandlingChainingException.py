# Q7. Write a program to demonstrate chaining exceptions using the __cause__ attribute.
def read_number_from_file(filename):
    try:
        with open(filename, 'r') as file:
            data = file.read()
            return int(data)
    except FileNotFoundError as e:
        new_exc = RuntimeError("Failed to read number from file")
        new_exc.__cause__ = e  # this line explicitly set the cause
        raise new_exc
try:
    number = read_number_from_file("missing_file.txt")
except RuntimeError as e:
    print("Caught RuntimeError:", e)
    if e.__cause__:
        print("Original cause:", repr(e.__cause__))