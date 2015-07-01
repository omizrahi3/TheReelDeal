/**
 * The LoginRegistration package handles logging into the app The Reel Deal
 * as well as registering for an account to access the app The Reel Deal
 */
package LoginRegistration;

/**
 * Locks a user's account because of improper login credential input
 * @author Anthony
 * @version 1.0
 */
public class LockedAccountException extends Exception {
    
    /**
     * Constructor for the exception that locks out the user
     * @param message The "You are locked out" message relayed to the app user
     */
    public LockedAccountException(String message) {
        super(message);
    }
    
    /**
     * Constructor for the exception that locks out the user
     * @param message The "You are locked out" message relayed to the app user
     * @param cause The triggered error that leads to this exception call
     */
    public LockedAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
