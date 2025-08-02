# Q2. Write a Python function that handles IndexError when accessing elements of a list.
def access_list_element():
    items = ['apple', 'banana', 'cherry']
    try:
        index = int(input("Enter an index to access (0 to 2): "))
        print(f"Item at index {index}: {items[index]}")
    except IndexError:
        print("Error: The index is out of range. Please enter a valid index (0, 1, or 2).")
    except ValueError:
        print("Error: Please enter a valid integer.")
access_list_element() # run