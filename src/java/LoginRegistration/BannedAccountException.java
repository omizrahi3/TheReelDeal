/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

/**
 * Blocks a banned user from accessing the app despite correct login credentials
 * @author Anthony
 * @version 1.0
 */
public class BannedAccountException extends Exception {
   
    /**
     * Constructor for the exception that blocks the banned user
     * @param message The "You are banned" message relayed to the app user
     */
    public BannedAccountException(String message) {
        super(message);
    }
    
    /**
     * Constructor for the exception that blocks the banned user
     * @param message The "You are banned" message relayed to the app user
     * @param cause The triggered error that leads to this exception call
     */
    public BannedAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
