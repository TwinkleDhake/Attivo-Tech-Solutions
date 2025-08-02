/* Q4. Define an interface Movable with:
A method move().
Create two classes Car and Robot that implement Movable:
In Car, move() should print a message indicating the car is driving.
In Robot, move() should print a message indicating the robot is walking.
Write a main method to:
Store Car and Robot objects in a Movable array.
Iterate over the array and call move() on each object. */
interface Movable {
    void move();
}
class Car implements Movable {
    @Override
    public void move() {
        System.out.println("The car is driving.");
    }
}
class Robot implements Movable {
    @Override
    public void move() {
        System.out.println("The robot is walking.");
    }
}
public class CombinationMovable {
    public static void main(String[] args) {
        Movable[] movables = { new Car(), new Robot() };
        for (Movable m : movables) {
            m.move();
        }
    }
}