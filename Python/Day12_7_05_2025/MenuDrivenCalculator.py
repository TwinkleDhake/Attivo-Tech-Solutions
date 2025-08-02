""" Q1. Menu-Driven Calculator
Create a menu-driven calculator that performs addition, subtraction, multiplication, and division. 
Use a do-while equivalent loop to ensure the program keeps running until the user chooses to exit. """

def is_number(s):
    return s.replace('.', '', 1).lstrip('-').isdigit()
def Add (a, b):
    return a + b
def Subtract(a, b):
    return a - b
def Multiply(a, b):
    return a * b
def Divide(a, b):
    if b ==0:
         return "Error! Cannot be divided by Zero."
    return a / b
while True:
    print("\n Menu Driven Calculator" )
    print("1. Addition")
    print("2. Subtraction")
    print("3. Multiplication")
    print("4. Division")
    print("5. Exit")

    choice = input("Enter your choice (1 - 5):")
    if choice == '5':
        print("Exit")
        break
    if choice in ['1', '2', '3', '4']:
            num1 = float(input("Enter the First Number: "))
            num2 = float(input("Enter the Second Number: "))
            if not (is_number(num1) and is_number(num2)):
                  print("Invalid input! Please Enter Valid Value.")
                  continue
            num1 = float(num1)
            num2 = float(num2)

            match choice:
                case '1':
                    print("Result:", Add(num1, num2))
                case '2':
                    print("Result:", Subtract(num1, num2))
                case '3':
                    print("Result:", Multiply(num1, num2))
                case '4':
                    print("Result:", Divide(num1, num2))
    else:
        print("Invalid Choice! Please choose the valid option.")