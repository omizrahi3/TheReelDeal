/*
Custom exception for potential use.
 */
package gatech.cs2340.team7;

/**
 *
 * @author Anthony
 */
public class FailedUserOperationException extends Exception {
    
    /**
     * Throw an exception with the given message
     * @param msg Message to throw alongside the exception
     */
    public FailedUserOperationException(String msg) {
        super(msg);
    }
    
    /**
     * Throw an exception with the given cause
     * @param cause Cause to throw alongside the exception
     */
    public FailedUserOperationException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Throw an exception with the given message and cause
     * @param msg Message to throw alongside the exception
     * @param cause Cause to throw alongside the exception
     */
    public FailedUserOperationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}