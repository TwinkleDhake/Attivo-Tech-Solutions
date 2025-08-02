# Q5. Write a Python function that raises a RuntimeError and catches it in the calling function.
def exception_handle_runtime_error():
    raise RuntimeError("Something went wrong in exception handling runtime error!")
def calling_function():
    try:
        print("Calling exception handling runtime error.")
        exception_handle_runtime_error()
    except RuntimeError as e:
        print("Caught a RuntimeError in calling_function:")
        print("Error message:", str(e))
calling_function()