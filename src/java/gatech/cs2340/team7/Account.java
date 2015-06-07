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
    private String aboutMe;
    //private Image img;
    private boolean loggedIn;
    private boolean locked;
    
    public Account() {
        aboutMe = "";
        loggedIn = false;
        locked = false;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getAboutMe() {
        return this.aboutMe;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public boolean isLocked() {
        return locked;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    public void login() {
        
        if (locked) {
            locked = false;
        }
        loggedIn = true;
    }
    
}
