""" Q. Mirror Right Triangle Pattren

"""
"""rows = int(input("enter the number of rows you  want to print: "))

#1ST TRIANGLE
for i in range(1, rows + 1):
    stars = "*" * (2 * i - 1)
    print(stars)

row2 = int(input("enter the number of rows you  want to print: "))

#2ND TRIANGLE
for j in range(1, rows + 1):
    stars = "*" * (2 * j - 1)
    print(stars)"""
rows = 5
for i in range(1, rows + 1):
    spaces = rows - i
    stars = i
    print(' ' * spaces + '*' * stars)