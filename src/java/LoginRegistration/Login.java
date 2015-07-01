/**
 * The LoginRegistration package handles logging into the app The Reel Deal
 * as well as registering for an account to access the app The Reel Deal
 */
package LoginRegistration;

import UserManagement.User;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Handles the validation of a user's login credentials
 * Extension of abstract class AccountAccessAttempt
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login extends AccountAccessAttempt {
    
    /**
     * Validates a login attempt using the provided 
     * map between valid users and their passwords
     * @param passwords HashMap of passwords to verify the provided password
     * @return Indication of login success
     */
    public boolean checkLogin(HashMap<String, String> passwords) {
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