/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Handles the validation of a user's login credentials
 * Extension of abstract class AccountAccessAttempt.
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login {

    /**
     * Username to uniquely identify the user to login.
     */
    private String username;

    /**
     * Password to use in attempting to login the user.
     */
    private String password;

    /**
     * Validates a login attempt using the provided
     * map between valid users and their passwords.
     * @param passwords HashMap of passwords to verify the provided password
     * @return Indication of login success
     */
    public final boolean checkLogin(final Map<String, String> passwords) {
        boolean loginCheck = false;
        if (passwords == null) {
            loginCheck = false;
        } else {
            if (password != null && username != null) {
                if (password.equals(passwords.get(username))) {
                    loginCheck = true;
                } else if (username.length() == 0) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Error", "Please enter username."));
                    loginCheck = false;
                } else if (password.length() == 0) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Error", "Please enter password."));
                    loginCheck = false;
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error", "Incorrect"
                                            + " username or password!"));
                    loginCheck = false;
                }
            }
        }
        return loginCheck;
    }

    /**
     * Clears all data after an account access has been made.
     */
    public final void clearLoginData() {
        username = "";
        password = "";
    }

    /**
     * Getter method for username.
     * @return username The user's account name
     */
    public final String getUsername() {
        return username;
    }

    /**
     * Getter method for password.
     * @return password The user's password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Setter method for username.
     * @param newUsername The altered username
     */
    public final void setUsername(final String newUsername) {
        username = newUsername;
    }

    /**
     * Setter method for password.
     * @param newPassword The altered password
     */
    public final void setPassword(final String newPassword) {
        password = newPassword;
    }
}