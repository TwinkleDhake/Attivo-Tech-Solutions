""" Q7. Create two classes, EvenNumbers and OddNumbers, both implementing an __iter__() method 
to generate an infinite sequence of even and odd numbers, respectively. 
Write a function that takes an iterable and prints the first n elements, showcasing polymorphism with iterables. """
class EvenNumbers:
    def __iter__(self):
        num = 0
        while True:
            yield num
            num += 2
class OddNumbers:
    def __iter__(self):
        num = 1
        while True:
            yield num
            num += 2
def print_first_n_elements(iterable, n):
    it = iter(iterable)
    for _ in range(n):
        print(next(it), end=' ')
    print()
print("First 10 even numbers:")
print_first_n_elements(EvenNumbers(), 10)
print("First 10 odd numbers:")
print_first_n_elements(OddNumbers(), 10)