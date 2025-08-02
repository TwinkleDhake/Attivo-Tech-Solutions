# Q2. Print Vowels in a String (give the string of your own , dont take any user input)
str = "Twinkle"
vowels = "aeiouAEIOU"
print("Vowels in String: ")
for char in str:
    if char in vowels:
        print(char, end= '')