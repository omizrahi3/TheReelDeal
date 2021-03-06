/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

/**
 * Locks a user's account because of improper login credential input.
 * @author Anthony
 * @version 1.0
 */
public class LockedAccountException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1350192024329225098L;

    /**
     * Constructor for the exception that locks out the user.
     * @param message The "You are locked out" message relayed to the user
     */
    public LockedAccountException(final String message) {
        super(message);
    }

    /**
     * Constructor for the exception that locks out the user.
     * @param message The "You are locked out" message relayed to the user
     * @param cause The triggered error that leads to this exception call
     */
    public LockedAccountException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
