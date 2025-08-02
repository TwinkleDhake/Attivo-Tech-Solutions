""" Q9. Create a Python program that attempts to read a file and process its content. 
The file contains numbers, one per line. Your program should:
Retry reading the file up to 3 times in case of a FileNotFoundError.
Catch ValueError if a line in the file cannot be converted to an integer.
Compute and print the sum of all numbers in the file.
Use a finally block to close the file handle and print a success or failure message. """
def read_and_sum_numbers(filename, max_retries=3):
    for attempt in range(1, max_retries + 1):
        try:
            with open(filename, 'r') as file:
                total = 0
                for line_num, line in enumerate(file, start=1):
                    try:
                        total += int(line.strip())
                    except ValueError:
                        print(f"Line {line_num}: Invalid number '{line.strip()}'")
                print(f"Sum of valid numbers: {total}")
                print("File read and processed successfully.")
                break
        except FileNotFoundError:
            print(f"Attempt {attempt}: File '{filename}' not found.")
            if attempt == max_retries:
                print("Failed to read file after 3 attempts.")
        finally:
            print(f"Attempt {attempt} complete.\n")
read_and_sum_numbers("numbers.txt")