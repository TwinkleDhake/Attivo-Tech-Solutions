// Q8. Write a program that compares RuntimeException with checked exceptions.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExceptionHandlingRuntimeWithCheckedExComparison {
    public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("File opened successfully.");
        }
    }
    public static void parseNumber(String input) {
        int number = Integer.parseInt(input);
        System.out.println("Parsed number: " + number);
    }
    public static void main(String[] args) {
        try {
            readFile("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
        try {
            parseNumber("java");
        } catch (NumberFormatException e) {
            System.out.println("Caught runtime exception: " + e.getMessage());
        }
        System.out.println("About to call parseNumber with invalid input without try-catch...");
        parseNumber("packt");
        System.out.println("This line will not be printed because of uncaught runtime exception.");
    }
}