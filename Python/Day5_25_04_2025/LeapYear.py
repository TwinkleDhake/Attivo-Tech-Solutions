#If the year is divisible by 4 (leap year) and divisible by 100 (not a leap year) or divisible by 400 (leap year).
#if it is divisible by 100 and 400 then it is a leap year.
#If a year is divisible by 100 and 4, then If it is not divisible by 400, then it is NOT a leap year. and If it is also divisible by 400, then it is a leap year.
year = int(input("Enter a Year: "))
if(year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)):
    print(f"{year} is a leap year.")
else:
    print(f"{year} is not a leap year.")