package classes;

public class UserAlreadyExistsException extends Exception {
    /**
     * @param message Nachricht
     */
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}