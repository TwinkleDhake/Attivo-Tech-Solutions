""" Q5. Write a recursive function to compress a string by replacing consecutive repeated characters with their count.
Input: "aaabbcccc"
Output: "a3b2c4" """
def compress_recursive(s, index=0, count=1, result=""):
    if index == len(s) - 1:
        result += s[index] + (str(count) if count > 1 else "")
        return result
    if s[index] == s[index + 1]:
        return compress_recursive(s, index + 1, count + 1, result)
    else:
        result += s[index] + (str(count) if count > 1 else "")
        return compress_recursive(s, index + 1, 1, result)
input_str = "aaabbcccc"
output = compress_recursive(input_str)
print(output)