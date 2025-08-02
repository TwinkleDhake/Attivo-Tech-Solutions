// Q3. Write a program that triggers and catches a NullPointerException.
public class ExceptionHandlingNullPointerException {
    public static void main(String[] args) {
        try {
            String text = null; // Declare and initialize a String reference to null
            int length = text.length();  // Try to call a method on the null reference, 
            //throw NullPointerException
            System.out.println("Length of the string: " + length); // line will not be reached
        } catch (NullPointerException e) {
            // catch and handle the NullPointerException
            System.out.println("Caught a NullPointerException!");
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}