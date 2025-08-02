# Q2. Create a program to handle invalid input using ValueError when converting a string to an integer.
def convert_to_integer():
    try:
        user_input = input("Enter a number: ")
        num = int(user_input)
        print(f"You entered the number: {num}")
    except ValueError:
        print("Error: Invalid input. Please enter a valid integer.")
convert_to_integer() # Run