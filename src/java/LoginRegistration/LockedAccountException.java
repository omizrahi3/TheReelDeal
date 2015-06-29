/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginRegistration;

/**
 *
 * @author Anthony
 */
public class LockedAccountException extends Exception {
    
    public LockedAccountException(String message) {
        super(message);
    }
        
    public LockedAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
