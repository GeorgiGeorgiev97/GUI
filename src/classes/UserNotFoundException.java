package classes;

public class UserNotFoundException extends Exception {
    /**
     * @param message Nachricht
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}