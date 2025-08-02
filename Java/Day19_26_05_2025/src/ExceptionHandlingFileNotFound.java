// Q4. Handle a FileNotFoundException by attempting to open a non-existent file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExceptionHandlingFileNotFound {
    public static void main(String[] args) {
        File file = new File("non_existent_file.txt");
        try {
            try (Scanner reader = new Scanner(file)
            ) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            System.out.println("Exception message: " + e.getMessage());
        }
        System.out.println("Program continues after exception handling.");
    }
}