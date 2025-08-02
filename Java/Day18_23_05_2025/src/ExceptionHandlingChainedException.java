// Q6. Write a program to demonstrate chained exceptions using Throwable.initCause.
public class ExceptionHandlingChainedException {
    static void load() throws Exception { 
        throw new Exception("Root cause exception"); // throws the root cause exception
    } 
    static void process() throws Exception {
        try {
            load(); // catches root cause and throws another exception chaining the cause
        } catch (Exception e) {
            Exception chainedException = new Exception("Chained exception occurred"); // new exception and chain the caught exception as the cause is created
            chainedException.initCause(e);
            throw chainedException;
        }
    }
    public static void main(String[] args) {
        try {
            process();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}