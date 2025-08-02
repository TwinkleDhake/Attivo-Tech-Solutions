""" Q. Rectangle Pattern
*****
*   *
*   *
*   *
*****     """
rows = 5
for i in range(rows + 1):
    if i == 1 or i == rows:
        print("*" * rows)
    else:
        print("*" + (" "*(rows - 2)) + "*")