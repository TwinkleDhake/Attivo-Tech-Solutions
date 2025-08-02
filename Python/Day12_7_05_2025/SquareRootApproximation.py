"""Q2. Square Root Approximation
Write a program to calculate the square root of a number using the Babylonian method. 
Use a do-while equivalent loop to refine the approximation until the difference between 
successive approximations is less than a specified tolerance."""
def babylonian_sqrt(number, tolerance=0.0001):
    guess = number / 2.0
    while True:
        new_guess = (guess + number / guess) / 2.0
        if abs(new_guess - guess) < tolerance:
            break
        guess = new_guess
    return new_guess
num = float(input("Enter a number: "))
result = babylonian_sqrt(num)
print(f"Approximate square root of {num} is {result}")