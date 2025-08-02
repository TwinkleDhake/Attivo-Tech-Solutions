#Prime number is greater than 1 and divisible only by 1 and itself.
#checking for divisibility up to the square root of the number.
#if a divisor is found then it is not a prime and if no divisor is found then it is a prime
n = int(input("Enter the number n "))
def is_prime(n, divisor = 2):
    if n <= 1:
        return False
    elif divisor > n // 2:
        return True
    elif n % divisor == 0:
        return False
    else:
        return is_prime(n, divisor + 1)
if is_prime(n):
    print(n, "is a prime number.")
else:
    print(n, "is not a prime number.")