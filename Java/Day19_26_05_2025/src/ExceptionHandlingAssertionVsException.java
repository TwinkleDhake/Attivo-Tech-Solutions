// Q7. Write a program to differentiate between using assertions and exceptions for error handling.
public class ExceptionHandlingAssertionVsException {
    public static void validateUsernameException(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        System.out.println("Username is valid (exception method): " + username);
    }
    public static void checkUsernameAssertion(String username) {
        assert username != null : "Username is null (assertion failed)";
        assert username.length() >= 3 : "Username too short (assertion failed)";
        System.out.println("Username passed assertion checks: " + username);
        }
        public static void main(String[] args) {
        try {
            validateUsernameException("");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        checkUsernameAssertion("twinkle");  
        System.out.println("Program finished.");
    }
}