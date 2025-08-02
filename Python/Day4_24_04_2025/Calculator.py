print("Welcome to the basic calculator program!")
name = input("Enter your name: ")
print("Hello, " + name + " Lets do some calculation.\n")
operations_list = ['Addition', 'Subtraction', 'Multiplication', 'Division', 'Modulus', 'Exponential', 'Floor Division']
symbols_tuple = ('+', '-', '*', '/', '%', '**')
operations_dictionary = {'Addition':'+', 'Subtraction':'-', 'Multiplication':'*', 'Division':'/', 'Modulus':'%', 'Exponential':'**', 'Floor Division':'//'}
print("Available operations:")
for op in operations_list: print(f"- {op} ({operations_dictionary[op]})")
n = int(input("Enter the number n "))
m = int(input("Enter the number m "))
operation = input("Choose an Operation (Addition, Subtraction, Multiplication, Division, Modulus, Exponential, Floor Division): ").title()
result = None
if operation == 'Addition':
    result = n + m
elif operation == 'Subtraction':
    result = n - m
elif operation == 'Multiplication':
    result = n * m
elif operation == 'Division':
    if m != 0:
        result = n / m
    else: 
        result = 'Error!'
elif operation == 'Floor Division':
        result = n // m
else:
    result = "Invalid operation selected"
print(f"\n{name}, following is the result: ")
print("Result:", result)
print("\nData types of inputs and result:")
print("Type of n:", type(n))
print("Type of m:", type(m))
print("Type of result:", type(result))
print("\nThank You for using the Calculator, " + name + "!")