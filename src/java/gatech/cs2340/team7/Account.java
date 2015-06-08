/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "account", eager = true)
@SessionScoped
public class Account {
    
    private String username;
    //private Image img;
    private boolean loggedIn;
    private boolean locked;
    
    /**
     * Empty constructor
     */
    public Account() {
        this(null);
    }
    
    /**
     * Constructor specifying all relevant members for the new account
     * @param username Username for the new account
     */
    public Account(String username) {
        this.username = username;
        this.loggedIn = false;
        this.locked = false;
    }
    
    /**
     * Login to the account
     */
    public void login() throws Exception {
        // change this logic for checking account lock
        if (locked) {
            // TODO throw more accurate exception
            throw new Exception("Account is locked by an administrator!");
        }
        loggedIn = true;
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
}
