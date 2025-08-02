# Q2. Write a program that handles multiple exceptions (ValueError and TypeError) in a single try-except block.
def process_input(data):
    try:
        num = int(data)
        result = num + "10"  
        print("Result:", result)
    except (ValueError, TypeError) as e:
        print("An exception occurred!")
        print(f"Exception type: {type(e).__name__}")
        print(f"Error message: {e}")
    else:
        print("Processing completed without error.")
    finally:
        print("End of exception handling.\n")
process_input("abc")
process_input(5)     
process_input("20")    