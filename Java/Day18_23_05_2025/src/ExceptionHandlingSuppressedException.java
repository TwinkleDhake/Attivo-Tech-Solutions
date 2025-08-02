/* Q7. Suppressing Exceptions: Demonstrate suppressed exceptions using try-with-resources.
Output:
Caught Exception: Primary Exception
Suppressed Exception: Exception during resource closing */

public class ExceptionHandlingSuppressedException {
    static class Resource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Exception during resource closing"); // throw an exception during resource closing
        }
    }
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            throw new Exception("Primary Exception"); // throw a primary exception inside try block
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage()); 
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed Exception: " + suppressed.getMessage());  // print suppressed exceptions
            }
        }
    }
}