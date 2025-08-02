# Q4. Write a Python script to demonstrate the use of else in try-except blocks.
def access_list_element(list, index):
    try:
        element = list[index]
    except IndexError as e:
        print("Exception caught!")
        print(f"Error: {e}")
    else:
        print("Element access successful.")
        print(f"Element at index {index}: {element}")
    finally:
        print("Execution of try-except-else-finally block complete.\n")
print("Test Case 1: Valid index")
access_list_element([10, 20, 30, 40], 2)
print("Test Case 2: Invalid index")
access_list_element([10, 20, 30, 40], 5)