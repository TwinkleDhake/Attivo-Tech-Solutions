""" Execption Handling:
Q1. Palindrome Number Finder
Write a program that finds and displays all palindrome numbers within a given range. 
A palindrome number is a number that reads the same backward as forward, such as 121 or 545.
Input:
Starting number of the range (integer).
Ending number of the range (integer).
Output:
A list of all palindrome numbers within the given range.
Example Input and Output:
A list of all palindrome numbers within the given range. """
def is_palindrome(n): # function is defined that takes number 'n'
    return str(n) == str(n)[::-1] # str(n) converts number into string
    # function converts the number to a string and checks whether the string is equal to its reverse
    # if so, it returns 'true' (palindrome); else 'false'
def find_palindrome(start, end): # function is defined to find all palindrome numbers from start to end
    palindrome_list = [] # empty list created to store palindrome numbers 
    for num in range(start, end + 1): # loop runs through all numbers from start to end
        if is_palindrome(num): # checks if it's a palindrome using is_palindrome(num)
            palindrome_list.append(num) # if yes, it adds it to the list
    return palindrome_list # After loop, list of palindromes is returned to the main function 'palindromes()'
# main function (palindromes() )
def palindromes(): # here main function 'palindromes() is defined
    try: # try block starts to catch and handle errors
        # this line prompts the user to enter a number as a string which,
        # converts the user input from string to integer
        start = int(input("Enter the starting number of the range: ")) 
        end = int(input("Enter the ending number of the range: ")) 
        if start > end: # checks if start value is greater than end value
            # raises a custom error with message
            raise ValueError("Starting number must be less than or equal to ending number.")
        result = find_palindrome(start, end) # this calls find_palindrome() using the input values
        print("Palindrome numbers in the range:", result) # list of palindrome numbers is printed
    # if input is not a valid integer or range is invalid, this block runs and shows the error
    except ValueError as ve: # this catches any ValueError
        print("Invalid input:", ve) # prints custom error using 've', having text error
    # if any other error happens, it will be caught and printed here
    except Exception as e: # this catches other unexpected errors
        print("An unexpected error occurred:", e) # prints an error message
palindromes() # runs program