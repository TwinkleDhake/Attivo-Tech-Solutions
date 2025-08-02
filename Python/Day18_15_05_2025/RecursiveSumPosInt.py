""" Q1. Write a recursive function to find the sum of digits of a given positive integer.
Input: 12345
Output: 15 (1 + 2 + 3 + 4 + 5) """
def sum(n):
    if (n < 10):
        return n
    return n % 10 + sum(n // 10)
num = 12345
print(f"sum of digits of {num} is: {sum(num)}")