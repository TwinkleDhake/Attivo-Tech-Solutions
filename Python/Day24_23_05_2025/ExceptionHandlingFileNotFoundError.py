# Q3. Write a script that catches a FileNotFoundError when trying to read a non-existent file.
def read_file():
    try:
        filename = input("Enter the filename to read: ")
        with open(filename, 'r') as file:
            content = file.read()
            print("file content:\n", content)
    except FileNotFoundError:
        print("Error: The file was not found. Please check the filename and try again.")
read_file() # Run