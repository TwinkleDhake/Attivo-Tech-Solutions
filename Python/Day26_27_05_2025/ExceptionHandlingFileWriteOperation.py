# Q8. Develop a program that demonstrates exception handling in file write operations (e.g., insufficient disk space).
def write_to_file(filename, content):
    try:
        with open(filename, 'w') as file:
            file.write(content)
        print("File written successfully.")
    except IOError as e:
        print(f"An I/O error occurred while writing to the file: {e}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
    finally:
        print("Write operation complete.\n")
large_content = "A" * (10**9)  
write_to_file("test_output.txt", "Hello, world!")