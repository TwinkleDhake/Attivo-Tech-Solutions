""" Q3. Write a program that takes an integer from the user and prints its prime factorization. 
Use a do-while equivalent loop to repeat the process for new integers until the user enters -1. """
while True:
    num = int(input("Enter an integer (-1 to quit): "))
    if num == -1:
        print("Goodbye!")
        break
    elif num < 2:
        print("Enter an integer greater than 1.")
    else:
        print("Prime factors of", num, "are: ", end="")
        i = 2
        first = True
        while i * i <= num:
            if num % i == 0:
                if not first:
                    print(" × ", end="")
                print(i, end="")
                num //= i
                first = False
            else:
                i += 1
        if num > 1:
            if not first:
                print(" × ", end="")
            print(num)
        else:
            print()