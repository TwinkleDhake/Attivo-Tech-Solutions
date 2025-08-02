""" Q5. Multiple Inheritance:
Create two classes:
Class A with a method method_a() that prints "Method A from Class A."
Class B with a method method_b() that prints "Method B from Class B."
Create a derived class ClassC that inherits from both ClassA and ClassB. 
Demonstrate calling both methods from an instance of ClassC. """
class ClassA:
    def method_a(self):
        print("Method A from Class A.")
class ClassB:
    def method_b(self):
        print("Method B from Class B.")
class ClassC(ClassA, ClassB):
    pass
obj = ClassC()
obj.method_a() 
obj.method_b()