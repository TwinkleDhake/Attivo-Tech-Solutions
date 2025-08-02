"""Q3. Write a program using do while that repeatedly asks the user to input a number. 
The program should check whether the number is prime or not. Stop when the user enters -1."""
def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True
while True:
    num = int(input("Enter a number (-1 to stop): "))
    if num == -1:
        print("Existing program.")
        break
    if is_prime(num):
        print(f"{num} is a prime number.")
    else:
        print(f"{num} is not a prime number.")