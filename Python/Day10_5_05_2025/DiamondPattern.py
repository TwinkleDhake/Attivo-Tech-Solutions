""" Q. Diamond Pattern
     *
    ***
   *****
  *******
 *********
  *******
   *****
    ***
     *      """
rows = 9
stars = rows // 2
for i in range(stars + 1):
    print(" " * (stars - i) + "*" * (2 * i + 1))
for i in range(stars - 1, -1, -1):
    print(" " * (stars - i) + "*" * (2 * i + 1))
