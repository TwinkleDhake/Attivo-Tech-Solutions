import java.util.Scanner;
public class IfElseTriangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first angel: ");
            int angle1 = scanner.nextInt();
            
            System.out.print("Enter Second angel: ");
            int angle2 = scanner.nextInt();
            
            System.out.print("Enter third angel: ");
            int angle3 = scanner.nextInt();
            
            if (angle1 + angle2 + angle3 == 180){
                System.out.println("Valid Triangle");
            } else {
                System.out.println("Invalid Triangle");
            }
        }
    }
    
}