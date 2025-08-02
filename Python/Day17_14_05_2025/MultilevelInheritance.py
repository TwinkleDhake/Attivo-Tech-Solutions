""" Q3. Multi-level Inheritance:
Implement a three-level inheritance hierarchy. 
Create a base class Vehicle with a method show_vehicle_info(). 
Derive a class Car that adds a method show_car_info(), and further 
derive a class SportsCar that adds a method show_sports_car_info(). 
Show how methods from all classes can be accessed from an instance of the SportsCar class."""
class Vehicle:
    def show_vehicle_info(self):
        print("This is a vehicle.")
class Car(Vehicle):
    def show_car_info(self):
        print("This is a car.")
class SportsCar(Car):
    def show_sports_car_info(self):
        print("This is a sports car.")
my_sports_car = SportsCar()
my_sports_car.show_vehicle_info()    
my_sports_car.show_car_info()           
my_sports_car.show_sports_car_info()