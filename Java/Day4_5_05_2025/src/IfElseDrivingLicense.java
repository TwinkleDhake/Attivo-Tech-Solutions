import java.util.Scanner;
public class IfElseDrivingLicense {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = new String();
            System.out.println("Enter your name: ");
            System.out.println("Enter Your Age");
            int age = scanner.nextInt();

            if (age >= 18) {
                System.out.println(name + "You are eligible to apply for a driving licence.");
            }
            else {
                System.out.println(name + "You are NOT eligible. Minimum age is 18.");
            }
        }
    }
}