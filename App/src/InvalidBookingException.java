/**
 * Use Case 9: Custom Exception
 *
 * Represents invalid booking scenarios.
 *
 * @version 9.0
 */
public class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}

