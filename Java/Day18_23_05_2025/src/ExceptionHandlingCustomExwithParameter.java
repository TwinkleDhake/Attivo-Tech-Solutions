/* Q8. Custom Exception with Parameters: Create a custom exception that accepts a message and a cause.
Output:
Caught Custom Exception: CustomException: Division by zero is not allowed
Caused by: / by zero */

class CustomException extends Exception { // custom exception class
    public CustomException(String message, Throwable cause) {
        super(message, cause); // call superclass constructor with message and cause
    }
}
public class ExceptionHandlingCustomExwithParameter {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // simulate an error (division by zero)
        } catch (CustomException e) {
            System.out.println("Caught Custom Exception: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
    }
    public static int divide(int a, int b) throws CustomException {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new CustomException("Division by zero is not allowed", e); // wrap original exception in a custom exception
        }
    }
}