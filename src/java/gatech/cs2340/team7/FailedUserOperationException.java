/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
