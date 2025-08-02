import java.util.Scanner;

public class IfElseEvenOdd {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number to check even or odd");
            int number = scanner.nextInt();
            if(number%2==0){
                System.out.println("The number is even");
            }
            else{
                System.out.println("the number is odd");
            }
        }
    }
}