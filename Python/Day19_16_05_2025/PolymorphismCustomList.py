""" Q8. Create a class CustomList that mimics Python's built-in list behavior for indexing, slicing, and iteration. 
Override the __getitem__() and __iter__() methods. 
Demonstrate polymorphism by using the CustomList object interchangeably with a Python list. """
class CustomList:
    def __init__(self, data):
        self.data = data
    def __getitem__(self, index):
        return self.data[index]
    def __iter__(self):
        return iter(self.data)
    def __repr__(self):
        return f"CustomList({self.data})"
def print_elements(collection):
    for i, item in enumerate(collection):
        print(f"Element {i}: {item}")
py_list = [10, 20, 30, 40, 50]
custom = CustomList([100, 200, 300, 400, 500])
print("Indexing:", custom[2])      
print("Slicing:", custom[1:4])
print("\nIterating over CustomList:")
for item in custom:
    print(item)
print("\nUsing polymorphic function with Python list:")
print_elements(py_list)
print("\nUsing polymorphic function with CustomList:")
print_elements(custom)