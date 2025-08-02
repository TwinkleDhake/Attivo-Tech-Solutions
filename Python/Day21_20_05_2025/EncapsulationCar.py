""" Q2. Create a class Car with a private method __engine_start that prints "Engine started".
Add a public method start_car that calls __engine_start.
Demonstrate how the start_car method can be used to access the private method. """
class Car:
    def __engine_start(self):
        print("Engine started")
    def start_car(self):
        self.__engine_start()
my_car = Car()
my_car.start_car()