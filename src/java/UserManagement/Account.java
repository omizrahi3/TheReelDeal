/**
 * The UserManagement package handles the features of a user
 */
package UserManagement;

import java.io.Serializable;
import LoginRegistration.BannedAccountException;
import LoginRegistration.LockedAccountException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Represents a user's account-specific data
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "account", eager = true)
@SessionScoped
public class Account implements Serializable {
    
    private String username;
    private boolean loggedIn;
    private boolean locked;
    private boolean banned;
    private boolean admin;
    
    /**
     * Constructs an empty account
     */
    public Account() {
        this(null, false);
    }
    
    /**
     * Constructs an account with all relevant members belonging to an account
     * @param username Username for the new account
     * @param admin Whether the account belongs to an admin
     */
    public Account(String username, boolean admin) {
        this.username = username;
        this.loggedIn = false;
        this.locked = false;
        this.banned = false;
        this.admin  = admin;
    }
    
    /**
     * Blocks the user from the account if necessary
     * Else validates the login attempt
     * @throws LockedAccountException if the account is locked
     * @throws BannedAccountException if the account is locked
     */
    public void login() throws LockedAccountException, BannedAccountException {
        // change this logic for checking account lock
        if (banned) {
            System.out.print("This account is banned!");
            throw new BannedAccountException(
                    "Account is banned by an administrator!");  
        } else if (locked) {
            System.out.print("This account is locked!");
            throw new LockedAccountException(
                    "Account is locked by an administrator!");
        }
        loggedIn = true;
    }
    
    /**
     * Checks and returns the status of the account
     * @return new String A string stating the status
     */
    public String getStatus() {
        if (admin) {
            return "Administrator";
        } else if (banned) {
            return "Banned";
        } else if (locked) {
            return "Locked";
        } else {
            return "Active";
        }
    }
    
    /**
     * Alters the status of the account to "locked"
     */
    public void lock() {
        locked = true;
        banned = false;
    }
    
    /**
     * Alters the status of the account to "unlocked"
     */
    public void unlock() {
        locked = false;
        banned = false;
    }
    
    /**
     * Alters the status of the account to "banned"
     */
    public void ban() {
        banned = true;
        locked = true;
    }
    
    /**
     * Alters the status of the account to "unbanned"
     */
    public void unban() {
        banned = false;
    }
    
    /**
     * Getter method for the username of the account
     * @return username The user who possesses the account
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Getter method for login status
     * @return loggedIn Whether the account is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    /**
     * Getter method for account locking status
     * @return locked Whether the account is locked
     */
    public boolean isLocked() {
        return locked;
    }
    
    /**
     * Setter method for the username associated with the account
     * @param username New username for the account
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Setter method for the login state of the account
     * @param loggedIn State of login to change to
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    /**
     * Setter method for the locked state of the account
     * @param locked State of account lock to change to
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    /**
     * Determines if the account user is an admin
     * @return admin Whether the account belongs to an admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Setter method for the admin state of the account
     * @param admin State of user privileges to change to
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Getter method for user banishment status
     * @return banned Whether the user holding the account is banned
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Setter method for user banishment status
     * @param banned State of account ban to change to
     */
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    
}