/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

import usermanagement.Account;
import usermanagement.Profile;
import usermanagement.User;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Handles the registration process for a new user
 * Extension of abstract class AccountAcessAttempt.
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "registration", eager = true)
@SessionScoped
public class Registration implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4801635537738571062L;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String passwordRepeat;
    /**
     *
     */
    private String major;
    /**
     *
     */
    private MajorChooserMenu majorChooser;
    /**
     *
     */
    private boolean validRegistration;

    /**
     * Username to uniquely identify the user to login.
     */
    private String username;

    /**
     * Password to use in attempting to login the user.
     */
    private String password;

    /**
     * Constructs a major menu as part of registration.
     */
    public Registration() {
        majorChooser = new MajorChooserMenu();
    }

    /**
     * Creates a new valid user
     * Only called after registration data has been validated.
     * @return new User A user with a name, account, and profile
     */
    public final User registerNewUser() {
        return new User(name,
                new Account(username, false),
                new Profile(name, major));
    }

    /**
     * Checks the validity of the registration data
     * Determines whether the data is valid or not.
     * @param users List of users to check existence of desired username
     * @return validRegistration Whether registration data is valid
     */
    public final boolean checkNewUserRegistration(final Map<String,
            User> users) {
        // check if username already exists
        if (usernameExists(username, users)) {
            // tell the user that username already exists
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error", "Username already exists!"));
             validRegistration = false;
        } else if (passwordsMatch()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Success!", "Preparing your profile..."));
            validRegistration = true;
        } else {
            // tell the user that the passwords don't match
            // OPTIONAL: check for numbers as well as letters in password
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error", "Passwords do not match!"));
             validRegistration = false;
        }
        return validRegistration;
    }

    /**
     * Determines if a given user already exists in the user list.
     * @param tmpUsername User to check for
     * @param users HashMap of valid preexisting users
     * @return Indication of the user's preexistence in the user list
     */
    public final boolean usernameExists(final String tmpUsername,
            final Map<String,
            User> users) {
        if (tmpUsername == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        }
        return users.containsKey(username);
    }

    /**
     * Determines whether the password and repeated password match.
     * @return Indication of whether the password and repeated password match
     */
    public final boolean passwordsMatch() {
        return password.equals(passwordRepeat);
    }

    /**
     * Clears all data after an account has been made.
     */
    public final void clearRegistrationData() {
        this.name = "";
        this.username = "";
        this.password = "";
        this.passwordRepeat = "";
        this.major = "";
        this.validRegistration = false;
    }

    /**
     * Getter method for the name of the prospective user.
     * @return name The name of the prospective user
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter method for the repeated password of the prospective account.
     * @return passwordRepeat The repeated password for the prospective account
     */
    public final String getPasswordRepeat() {
        return passwordRepeat;
    }

    /**
     * Setter method for user major.
     * @return major
     */
    public final String getMajor() {
        return major;
    }

    /**
     * Getter method for the major selection menu for a prospective user.
     * @return majorChooser The major menu for a prospective user
     */
    public final MajorChooserMenu getMajorChooser() {
        return majorChooser;
    }

    /**
     * Getter method for validity of registration data.
     * @return validRegistration Whether registration data is valid
     */
    public final boolean isValidRegistration() {
        return validRegistration;
    }

    /**
     * Setter method for the name of the prospective user.
     * @param newName The name of the prospective user
     */
    public final void setName(final String newName) {
        name = newName;
    }

    /**
     * Setter method for the repeated password of the prospective account.
     * @param repeatPassword The repeated password of the prospective account
     */
    public final void setPasswordRepeat(final String repeatPassword) {
        passwordRepeat = repeatPassword;
    }

    /**
     * Setter method for the major of the prospective user.
     * @param setMajor The major of the prospective user
     */
    public final void setMajor(final String setMajor) {
        major = setMajor;
    }

    /**
     * Setter method for the major menu of the prospective user.
     * @param choose The major menu of the prospective user
     */
    public final void setMajorChooser(final MajorChooserMenu choose) {
        majorChooser = choose;
    }

    /**
     * Setter method for validity of registration data.
     * @param valid Whether registration data is valid
     */
    public final void setValidRegistration(final boolean valid) {
        validRegistration = valid;
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
     * @param userName The altered username
     */
    public final void setUsername(final String userName) {
        username = userName;
    }

    /**
     * Setter method for password.
     * @param pword The altered password
     */
    public final void setPassword(final String pword) {
        password = pword;
    }
}