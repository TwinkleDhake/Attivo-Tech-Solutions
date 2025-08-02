""" Q. Hollow Pyramid Pattern
     *
    * *
   *   *
  *     *
  *******     """
rows = 5
for i in range(1, rows):
    print(' ' * (rows - i), end='')
    if i == 1:
        print('*')
    else:
        print('*' + ' ' * (2 * i - 3) + '*')
print('*' * (2 * rows - 1))