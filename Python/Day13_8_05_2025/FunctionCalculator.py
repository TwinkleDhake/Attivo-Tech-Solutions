""" Q1. Write a calculator program using function in python. 
using: min(), max(), len(), sum(), type(), range(), dict(), list(), tuple(), set(), print() """
def calculator():
    print("Welcome to the Python Calculator!")
    operation = {
        '1': 'Add',
        '2': 'Subtract',
        '3': 'Multiply',
        '4': 'Divide',
        '5': 'Summary Stats'
    }
    print("\n Select operation:")
    for key, value in operation.items():
        print(f"{key}, {value}")
        choice = input("Enter choice (1/2/3/4/5): ")
        if choice in ('1','2','3','4'):
            nums = list()
            count = int(input("How many numbers do you want to use? "))
            for i in range(count):
                val = float(input(f"Enter number {i + 1}: "))
                if choice == '1':
                    result = sum(nums)
                elif choice == '2':
                    result = nums[0]
                    for n in nums[1:]:
                        result -= n
                elif choice == '3':
                    result = 1
                    for n in nums:
                        result *= n
                elif choice == '4':
                    result = nums[0]
                    try:
                        for n in nums[1:]:
                            result /= n
                    except ZeroDivisionError:
                        print("Error: Cannot divide by zero.")
        elif choice == '5':
            print(f"Numbers: {nums}")
            print(f"Sum: {sum(nums)}")
            print(f"Min: {min(nums)}")
            print(f"Max: {max(nums)}")
            print(f"Length: {len(nums)}")
            print(f"Average: {sum(nums)/len(nums)}")
    else:
        print("Invalid input. Please select a valid operation.")
calculator()