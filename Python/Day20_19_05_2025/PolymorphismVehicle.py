""" Q5. Create a program where a base class Vehicle has methods start() and stop(). 
Create two subclasses, Car and Bike, and override the start() method to print specific messages. 
Use polymorphism to call the start() method for both classes. """
class Vehicle:
    def start(self):
        print("Vehicle is starting...")
    def stop(self):
        print("Vehicle is stopping...")
class Car(Vehicle):
    def start(self):
        print("Car engine is starting with a key ignition.")
class Bike(Vehicle):
    def start(self):
        print("Bike is starting with a kick or electric start.")
def start_vehicles(vehicle_list):
    for vehicle in vehicle_list:
        vehicle.start()
vehicles = [Car(), Bike(), Car()]
start_vehicles(vehicles)