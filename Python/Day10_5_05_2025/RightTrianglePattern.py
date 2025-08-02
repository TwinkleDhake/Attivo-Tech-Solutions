""" Q. Right Triangle Pattern
*
***
*****
*******"""

rows = int(input("Enter the number of rows: "))
rows = 4
for i in range(1, rows + 1):
    print(" * " * i)

"""row=4
for i in range(1, row+ 1):
    spaces = ' ' * (4 - i)
    stars = '*' * (2 * i - 1)
    print(spaces + stars)

#right angle triangle
row=5
for i in range(row):
    print(i*"*")

# reverse of it
rows = 5
for i in range(rows, 0, -1):
    print('*' * i)"""