#Write a Python program to check if a year is a leap year. If it is a leap year: 
# Check if it is divisible by 100: If divisible by 400, print "Century Leap Year.
# "Otherwise, print "Regular Leap Year."

year = int(input("Enter a Year: "))
def check_leap_year(year):
    if(year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
        if year % 100 == 0:
            if year % 400 == 0:
                print(f"{year} is a Century Leap Year")
            else:
                print(f"{year} is not a Century leap year as it is not divisible by 400.")
        else:
            print(f"{year} is a Regular Leap Year") 
    else:
        print(f"{year} is not a leap year")
check_leap_year(year)