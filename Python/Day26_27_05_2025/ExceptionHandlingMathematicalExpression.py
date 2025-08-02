""" Q11. Develop a Python program that dynamically evaluates mathematical expressions entered by the user.
Use the eval() function to evaluate the expressions.
Handle the following exceptions:
SyntaxError for invalid expressions.
ZeroDivisionError for division by zero.
NameError if the expression uses undefined variables.
Prompt the user to retry in case of an exception, with a maximum of 3 attempts.
Use a finally block to display a summary of successful and failed attempts. """
def evaluate_expression():
    attempts = 0
    success_count = 0
    failure_count = 0
    while attempts < 3:
        expr = input(f"Attempt {attempts + 1} - Enter a mathematical expression: ")
        try:
            result = eval(expr)
            print(f"Result: {result}")
            success_count += 1
            break
        except SyntaxError:
            print("SyntaxError: Invalid expression.")
            failure_count += 1
        except ZeroDivisionError:
            print("ZeroDivisionError: Cannot divide by zero.")
            failure_count += 1
        except NameError:
            print("NameError: Undefined variable used.")
            failure_count += 1
        except Exception as e:
            print(f"Unexpected error: {e}")
            failure_count += 1
        finally:
            attempts += 1
    print("\n--- Summary ---")
    print(f"Successful attempts: {success_count}")
    print(f"Failed attempts: {failure_count}")
evaluate_expression()