/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

/**
 * Blocks a banned user from accessing the application
 * despite correct login credential.
 * @author Anthony
 * @version 1.0
 */
public class BannedAccountException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 6033229138280070606L;

    /**
     * Constructor for the exception that blocks the banned user.
     * @param message The "You are banned" message relayed to the user
     */
    public BannedAccountException(final String message) {
        super(message);
    }

    /**
     * Constructor for the exception that blocks the banned user.
     * @param message The "You are banned" message relayed to the user
     * @param cause The triggered error that leads to this exception call
     */
    public BannedAccountException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
