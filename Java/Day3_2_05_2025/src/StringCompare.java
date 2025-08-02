import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a name: ");
            String str1 = scanner.nextLine();
            System.out.print("Enter a name: ");
            String str2 = scanner.nextLine();
            System.out.println("Using equals(): " + str1.equals(str2));
            System.out.println("Using equalsIgnoreCase(): " + str1.equalsIgnoreCase(str2));
        }
    }
}
