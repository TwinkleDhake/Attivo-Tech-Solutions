""" Q4. Write a recursive function to generate all permutations of a given string.
Input: "abc"
Output: ["abc", "acb", "bac", "bca", "cab", "cba"] """
def permute(s):
    if len(s) == 1:
        return [s]
    permutations = []
    for i in range(len(s)):
        rest = s[:i] + s[i+1:]
        for p in permute(rest):
            permutations.append(s[i] + p)
    return permutations
result = permute("abc")
print(result)