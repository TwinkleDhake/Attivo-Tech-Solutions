# Q1. Fibonacci Sequence
n = int(input("Enter the Number of Terms: "))
a, b = 0, 1
i = 0
while i < n:
    print(a)
    a, b = b, a + b
    i = i + 1