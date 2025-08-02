// Q5. Create and use a custom exception class.
public class ExceptionHandlingCustomException {
    // custom exception class
    static class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
    // throws the custom exception if input is invalid
    public static void validateAge(int age) throws MyCustomException {
        if (age < 18) {
            throw new MyCustomException("Age must be 18 or older. Provided: " + age);
        } else {
            System.out.println("Age is valid: " + age);
        }
    }
    public static void main(String[] args) {
        try {
            validateAge(21);  // Valid input
            validateAge(15);  // Will throw exception
        } catch (MyCustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}