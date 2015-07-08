/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;
import java.util.HashMap;
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
public class Login extends AccountAccessAttempt {

    /**
     *
     */
    private boolean passwordMatch;

    /**
     * login constructor.
     */
    public Login() {
        passwordMatch = false;
    }
    /**
     * Validates a login attempt using the provided
     * map between valid users and their passwords.
     * @param passwords HashMap of passwords to verify the provided password
     * @return Indication of login success
     */
    public final boolean checkLogin(final HashMap<String, String> passwords) {
        if (passwords == null) {
            return false;
        }
        System.out.println("Login attempt with username <"
                + AccountAccessAttempt.getUsername() + "> "
            + " and password <" + AccountAccessAttempt.getPassword() + ">");
        passwordMatch = AccountAccessAttempt.getPassword().
                equals(passwords.get(AccountAccessAttempt.getUsername()));

        if (passwordMatch) {
            return true;
        } else if (AccountAccessAttempt.getUsername().length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Error", "Please enter username."));
            return false;
        } else if (AccountAccessAttempt.getPassword().length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Error", "Please enter password."));
            return false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error", "Incorrect username or password!"));
            return false;
        }
    }
}