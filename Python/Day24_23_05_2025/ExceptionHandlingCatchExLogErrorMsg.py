# Q5. Write a program to catch an exception and log the error message to a file instead of printing it.
def divide_and_log():
    try:
        a = float(input("Enter numerator: "))
        b = float(input("Enter denominator: "))
        result = a / b
        print("Result:", result)
    except Exception as e:
        with open("error_log.txt", "a") as log_file:
            log_file.write(f"Error: {str(e)}\n")
divide_and_log() # Run