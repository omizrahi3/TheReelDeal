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
@ManagedBean(name = "accountAccessAttempt", eager = true)
@SessionScoped
public class AccountAccessAttempt {
    
    protected String username;
    protected String password;
    
    /**
     * Clear all data. This occurs after an account access
     *     has been made.
     */
    public void clearData() {
        this.username = "";
        this.password = "";
    }
    
    /**
     * Get username
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Get password 
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Set username
     * @param username username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Set password
     * @param password password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}