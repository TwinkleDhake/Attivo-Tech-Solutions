""" Q3. You are given a: 𝑚 × 𝑛
m×n grid. You can only move right or down. Write a recursive function to count the number of paths from the top-left to the bottom-right corner.
Input: m = 3, n = 3
Output: 6 """
def count_paths(m, n):
    if m == 1 or n == 1:
        return 1
    return count_paths(m - 1, n) + count_paths(m, n - 1)
print(count_paths(3,3))