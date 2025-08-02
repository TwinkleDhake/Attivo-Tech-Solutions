// Q3. Write a program to handle a checked exception (e.g., IOException) using try-catch.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ExceptionHandlingCheckedExIOEx {
        public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            System.out.println("Reading file contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Failed to close the file: " + e.getMessage());
            }
        }
    }
}