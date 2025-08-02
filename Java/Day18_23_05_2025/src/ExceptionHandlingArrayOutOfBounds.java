// Q4. Handle an out-of-bounds access for an array.
public class ExceptionHandlingArrayOutOfBounds {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30}; // array with 3 elements is created
            System.out.println("Accessing out-of-bounds element: " + numbers[4]); // accessing the 5th element (index 4), which does not exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException!"); // handle the out-of-bounds access
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}