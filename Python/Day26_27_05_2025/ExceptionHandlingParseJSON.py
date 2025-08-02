# Q7. Write a Python script to handle exceptions when parsing a JSON file using the json library.
import json
def parse_json_file(filename):
    try:
        with open(filename, 'r') as file:
            data = json.load(file)
    except FileNotFoundError:
        print(f"Error: The file '{filename}' was not found.")
    except json.JSONDecodeError as e:
        print(f"Error: Failed to parse JSON - {e}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
    else:
        print("JSON parsed successfully!")
        print("Data:", data)
    finally:
        print("Parsing attempt finished.\n")
parse_json_file("valid.json")
parse_json_file("invalid.json")  
parse_json_file("missing.json")  