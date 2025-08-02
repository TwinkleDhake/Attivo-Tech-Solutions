""" Q3. Given a nested tuple nested = (1, (2, 3, 4), 5, (6, 7, (8, 9))), write a program to:
Extract the last element of the first inner tuple (2, 3, 4).
Extract the second element of the nested inner tuple (8, 9). """
nested = (1, (2, 3, 4), 5, (6, 7, (8, 9)))
last_of_first_inner = nested[1][-1]
second_of_deep_nested = nested[3][2][1]
print("Last element of the first inner tuple:", last_of_first_inner)
print("Second element of the nested inner tuple:", second_of_deep_nested)