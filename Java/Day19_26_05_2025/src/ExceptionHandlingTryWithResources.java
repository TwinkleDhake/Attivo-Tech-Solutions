// Q6. Write a program to demonstrate the try-with-resources feature.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ExceptionHandlingTryWithResources {
    public static void main(String[] args) {
        String filePath = "untitled.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
        System.out.println("Program finished.");
    }
}