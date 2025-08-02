""" Q8. Custom Thread Class
Implement a custom thread class by extending threading.Thread. 
The class should accept a string and print it in reverse. 
Create multiple threads using this class. """
import threading
class ReverseStringThread(threading.Thread):
    def __init__(self, input_str):
        threading.Thread.__init__(self)
        self.input_str = input_str
    def run(self):
        reversed_str = self.input_str[::-1]
        print(f"Original: {self.input_str} | Reversed: {reversed_str}")
n = int(input("Enter the number of strings: "))
threads = []
for i in range(n):
    user_input = input(f"Enter string {i + 1}: ")
    thread = ReverseStringThread(user_input)
    threads.append(thread)
    thread.start()
for thread in threads:
    thread.join()
print("All strings processed.")