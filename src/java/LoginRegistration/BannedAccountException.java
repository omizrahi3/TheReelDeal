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
public class BannedAccountException extends Exception {
   
    public BannedAccountException(String message) {
        super(message);
    }
    
    public BannedAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
