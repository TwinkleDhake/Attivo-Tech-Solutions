# Q5. For the tuple nums = (1, 2, 3, 4, 5, 6, 7), calculate the sum of the last three numbers using negative indexing.
nums = (1, 2, 3, 4, 5, 6, 7)
last_three_sum = sum(nums[-3:])
print("Sum of the last three numbers:", last_three_sum)