/**
 * The LoginRegistration package handles logging into the app The Reel Deal
 * as well as registering for an account to access the app The Reel Deal
 */
package LoginRegistration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Stores/clears the password and username used for login attempt
 * Abstract class to be inherited by Login and Registration classes
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "accountAccessAttempt", eager = true)
@SessionScoped
public abstract class AccountAccessAttempt {
    
    protected String username;
    protected String password;
    
    /**
     * Clears all data after an account access has been made
     */
    public void clearData() {
        this.username = "";
        this.password = "";
    }
    
    /**
     * Getter method for username
     * @return username The user's account name
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Getter method for password 
     * @return password The user's password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Setter method for username
     * @param username The altered username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Setter method for password
     * @param password The altered password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}