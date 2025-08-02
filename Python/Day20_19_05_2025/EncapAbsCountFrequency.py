""" Q2. Create a program that reads a string input, counts the frequency of each character, and prints it in sorted order. 
Use a class StringAnalyzer with methods to perform these tasks, and demonstrate encapsulation and abstraction. """
class StringAnalyzer:
    def __init__(self, input_string):
        self.__input_string = input_string 
        self.__char_freq = {}        
    def analyze(self):
        """Analyzes character frequency."""
        for char in self.__input_string:
            self.__char_freq[char] = self.__char_freq.get(char, 0) + 1
    def get_sorted_frequency(self):
        """Returns sorted character frequency as a list of tuples."""
        return sorted(self.__char_freq.items())
    def display_frequencies(self):
        """Displays character frequencies in sorted order."""
        for char, freq in self.get_sorted_frequency():
            print(f"'{char}': {freq}")
user_input = input("Enter a string: ")
analyzer = StringAnalyzer(user_input)
analyzer.analyze()
analyzer.display_frequencies()