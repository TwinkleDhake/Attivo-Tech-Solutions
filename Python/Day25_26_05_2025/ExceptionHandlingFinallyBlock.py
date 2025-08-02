# Q3. Write a script to demonstrate the use of the finally block for cleanup actions.
def exception_handle_finally():
    try:
        file = open("funtitled.txt", "r")
        contents = file.read()
        print("File Contents:\n", contents)
    except FileNotFoundError:
        print("Error: The file was not found.")
    finally:
        try:
            file.close()
            print("File has been closed (from finally block).")
        except NameError:
            print("File was never opened, so nothing to close.")
exception_handle_finally()