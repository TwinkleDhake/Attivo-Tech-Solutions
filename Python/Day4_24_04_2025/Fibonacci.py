# Q4. Fibonacci
n = int(input("Enter the Number of Terms: "))
a, b = 0, 1

print("Fibonacci: ")
for _ in range(n):
    print(a)
    a, b = b, a + b
