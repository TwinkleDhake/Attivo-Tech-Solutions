/* Q3. Write a method named square that takes an integer as a parameter and returns its square. Call this method with the value 5 and print the result.
Create a method named area:
One version calculates the area of a rectangle given its length and width.
Another version calculates the area of a circle given its radius.
Test both versions.
 */
public class Squares {
    public static int square(int n) {
        return n * n;
    }
    public static double area(double length, double width) {
        return length * width;
    }
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {
        int num = 5;
        int squareResult = square(num);
        System.out.println("Square of " + num + " is: " + squareResult);
        double length = 10.0;
        double width = 5.0;
        System.out.println("Area of rectangle: " + area(length, width));
        double radius = 7.0;
        System.out.println("Area of circle: " + area(radius));
        }
}