// Q1. Write a program that calculates the area of a shape based on the user's choice:
import java.util.Scanner;
public class SwitchUserShape {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose a shape to calculate area: ");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("Enter your choice (1 - 3): ");
            int choice = scanner.nextInt();

            //switch (choice) {
                //case 1: //Circle
                    //System.out.println("Enter the Radius of the Circle");
                    //double radius = scanner.nextDouble();
                    //double circleArea = Math.PI * radius * radius;
                    //System.out.println("Area of the Circle: " + circleArea);
                    //break;
                //case 2: //Rectangle
                    //System.out.println("Enter the Length of the Rectangle");
                    //double length = scanner.nextDouble();
                    //System.out.println("Enter the width of the Rectangle");
                    //double width = scanner.nextDouble();
                    //double rectangleArea = length * width;
                    //System.out.println("Area of the Rectangle: " + rectangleArea);
                    //break;
                //case 3: //Triangle
                    //System.out.println("Enter the base of the Triangle");
                    //double base = scanner.nextDouble();
                    //System.out.println("Enter the height of the Triangle");
                    //double height = scanner.nextDouble();
                    //double triangleArea = 0.5 * base * height;
                    //System.out.println("Area of the Rectangle: " + triangleArea);
                    //break;
                //default:
                    //System.out.println("Invalid choice!");
            //}
            switch (choice) {
                case 1 -> {
                    //Circle
                    System.out.println("Enter the Radius of the Circle");
                    double radius = scanner.nextDouble();
                    double circleArea = Math.PI * radius * radius;
                    System.out.println("Area of the Circle: " + circleArea);
                }
                case 2 -> {
                    //Rectangle
                    System.out.println("Enter the Length of the Rectangle");
                    double length = scanner.nextDouble();
                    System.out.println("Enter the width of the Rectangle");
                    double width = scanner.nextDouble();
                    double rectangleArea = length * width;
                    System.out.println("Area of the Rectangle: " + rectangleArea);
                }
                case 3 -> {
                    //Triangle
                    System.out.println("Enter the base of the Triangle");
                    double base = scanner.nextDouble();
                    System.out.println("Enter the height of the Triangle");
                    double height = scanner.nextDouble();
                    double triangleArea = 0.5 * base * height;
                    System.out.println("Area of the Rectangle: " + triangleArea);
                }
                default -> System.out.println("Invalid choice!");
            }
            scanner.close();
        }
    }
    
}
