""" Q3. Write a program that implements a class CustomList to mimic Python's list, 
overriding __getitem__, __setitem__, and __delitem__ methods. Include a method to calculate the sum of all elements in the list. 
Demonstrate polymorphism by passing both CustomList and a regular list to the same function. """
class CustomList:
    def __init__(self, elements=None):
        self._data = elements if elements is not None else []
    def __getitem__(self, index):
        return self._data[index]
    def __setitem__(self, index, value):
        self._data[index] = value
    def __delitem__(self, index):
        del self._data[index]
    def append(self, value):
        self._data.append(value)
    def sum_elements(self):
        return sum(self._data)
    def __str__(self):
        return str(self._data)
def print_sum(collection):
    total = sum(collection)
    print(f"Sum of elements: {total}")
custom = CustomList([1, 2, 3, 4])
regular = [10, 20, 30]
print("Original CustomList:", custom)
custom[1] = 99
print("Modified CustomList:", custom)
del custom[2]
print("After deletion:", custom)
print_sum(custom)
print_sum(regular)
print("Sum using CustomList method:", custom.sum_elements())