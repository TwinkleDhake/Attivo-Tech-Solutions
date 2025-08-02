""" Q2. Power Calculation
Write a recursive function to calculate the power of a number 
Input: x = 2, n = 5
Output: 32 (2 raised to the power 5) """
def pow(x, n):
    if(n == 0):
        return 1
    return x * pow(x, n - 1)
x = 2
n = 5
print(f"Power of number {x} is {pow(x, n)}")