/*
Account class to represents a user's account-specific data.
 */
package UserManagement;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anthony
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
     * Empty constructor
     */
    public Account() {
        this(null, false);
    }
    
    /**
     * Constructor specifying all relevant members for the new account
     * @param username Username for the new account
     * @param admin Is an administrator?
     */
    public Account(String username, boolean admin) {
        this.username = username;
        this.loggedIn = false;
        this.locked = false;
        this.banned = false;
        this.admin  = admin;
    }
    
    /**
     * Login to the account
     * @throws Exception if the account is locked by an admin
     */
    public void login() throws Exception {
        // change this logic for checking account lock
        if (locked) {
            // TODO throw more accurate exception
            System.out.print("This account is locked!");
            throw new Exception("Account is locked by an administrator!");
        }
        loggedIn = true;
    }
    
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
    
    public void lock() {
        locked = true;
        banned = false;
    }
    
    public void unlock() {
        locked = false;
        banned = false;
    }
    
    public void ban() {
        banned = true;
        locked = true;
    }
    
    public void unban() {
        banned = false;
    }
    
    /**
     * Get username for the account
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Get whether the account is logged in
     * @return Whether the account is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    /**
     * Get whether the account is locked
     * @return Whether the account is locked
     */
    public boolean isLocked() {
        return locked;
    }
    
    /**
     * Set the username for the account
     * @param username New username for the account
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Set the login state of the account
     * @param loggedIn State of login to change to
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    /**
     * Set the locked state of the account
     * @param locked State of account lock to change to
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    
}