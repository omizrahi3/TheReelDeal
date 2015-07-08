/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Stores/clears the password and username used for login attempt
 * Abstract class to be inherited by Login and Registration classes.
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "accountAccessAttempt", eager = true)
@SessionScoped
public abstract class AccountAccessAttempt {
    /**
     *
     */
    private static String username;
    /**
     *
     */
    private static String password;

    /**
     * Clears all data after an account access has been made.
     */
    public static final void clearData() {
        username = "";
        password = "";
    }

    /**
     * Getter method for username.
     * @return username The user's account name
     */
    public static final String getUsername() {
        return username;
    }

    /**
     * Getter method for password.
     * @return password The user's password
     */
    public static final String getPassword() {
        return password;
    }

    /**
     * Setter method for username.
     * @param userName The altered username
     */
    public static final void setUsername(final String userName) {
        username = userName;
    }

    /**
     * Setter method for password.
     * @param pword The altered password
     */
    public static final void setPassword(final String pword) {
        password = pword;
    }
}