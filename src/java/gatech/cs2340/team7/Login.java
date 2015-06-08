/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login extends AccountAccessAttempt {
    
    public Login() {
        
    }
    
    /**
     * Validate the login attempt, using the provided list of users
     * and map of users to passwords
     * @param users List of users to check existence of user to login
     * @param passwords Map of passwords to verify the user's provided password
     * @return Indication of login success
     */
    public boolean checkLogin(List<User> users, HashMap<String, String> passwords) {
        System.out.println("Login attempt with username <" + username + "> "
            + " and password <" + password + ">");
        boolean passwordMatch = password.equals(passwords.get(username));
        
        if (passwordMatch) {
            return true;
        } else if (username.length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Please enter username."));
            return false;           
        } else if (password.length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Please enter password."));
            return false;              
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Incorrect username or password!"));
            return false;
        }
    }
}