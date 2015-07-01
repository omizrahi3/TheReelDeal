/**
 * The LoginRegistration package handles logging into the app The Reel Deal
 * as well as registering for an account to access the app The Reel Deal
 */
package LoginRegistration;

import UserManagement.Account;
import UserManagement.Profile;
import UserManagement.User;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Handles the registration process for a new user
 * Extension of abstract class AccountAcessAttempt
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "registration", eager = true)
@SessionScoped
public class Registration extends AccountAccessAttempt implements Serializable {
    
    private String name;
    private String passwordRepeat;
    private String major;
    private MajorChooserMenu majorChooser;
    boolean validRegistration;
    
    /**
     * Constructs a major menu as part of registration
     */
    public Registration() {
        majorChooser = new MajorChooserMenu();
    }
    
    /**
     * Creates a new valid user
     * Only called after registration data has been validated
     * @return new User A user with a name, account, and profile
     */
    public User registerNewUser() {
        System.out.println("Creating account for " + name +
                " with username " + username);
        return new User(name, new Account(username, false), new Profile(name, major));
    }
    
    /**
     * Checks the validity of the registration data
     * Determines whether the data is valid or not
     * @param users List of users to check existence of desired username
     * @return validRegistration Whether registration data is valid
     */
    public boolean checkNewUserRegistration(HashMap<String, User> users) {
        // check if username already exists
        if (usernameExists(username, users)) {
            // tell the user that username already exists
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username already exists!"));
             validRegistration = false;
        } else if (!passwordsMatch()) {
            // tell the user that the passwords don't match
            // OPTIONAL: check for numbers as well as letters in password
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Passwords do not match!"));
             validRegistration = false;
        } else {
            System.out.println("Major chosen: <" + major + ">");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Preparing your profile..."));
            validRegistration = true;
        }
        return validRegistration;
    }
    
    /**
     * Determines if a given user already exists in the user list
     * @param username User to check for
     * @param users HashMap of valid preexisting users
     * @return Indication of the user's preexistence in the user list 
     */
    public boolean usernameExists(String username, HashMap<String, User> users) {
        if (username == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        }
        return users.containsKey(username);
    }
    
    /**
     * Determines whether the password and repeated password match
     * @return Indication of whether the password and repeated password match
     */
    public boolean passwordsMatch() {
        return password.equals(passwordRepeat);
    }
    
    /**
     * Clears all data after an account has been made
     */
    @Override
    public void clearData() {
        super.clearData();
        this.name = "";
        this.passwordRepeat = "";
        this.major = "";
        this.validRegistration = false;
    }
    /**
     * Getter method for the name of the prospective user
     * @return name The name of the prospective user
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter method for the repeated password of the prospective account
     * @return passwordRepeat The repeated password for the prospective account
     */
    public String getPasswordRepeat() {
        return passwordRepeat;
    }
    
    /**
     * Getter method for the major of the prospective user
     * @return major The major of the prospective user
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Getter method for the major selection menu for a prospective user
     * @return majorChooser The major menu for a prospective user
     */
    public MajorChooserMenu getMajorChooser() {
        return majorChooser;
    }
    
    /**
     * Getter method for validity of registration data
     * @return validRegistration Whether registration data is valid
     */
    public boolean isValidRegistration() {
        return validRegistration;
    }
    
    /**
     * Setter method for the name of the prospective user
     * @param name The name of the prospective user
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter method for the repeated password of the prospective account
     * @param passwordRepeat The repeated password of the prospective account
     */
    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    /**
     * Setter method for the major of the prospective user
     * @param major The major of the prospective user
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /**
     * Setter method for the major menu of the prospective user
     * @param majorChooser The major menu of the prospective user
     */
    public void setMajorChooser(MajorChooserMenu majorChooser) {
        this.majorChooser = majorChooser;
    }
    
    /**
     * Setter method for validity of registration data
     * @param validRegistration Whether registration data is valid
     */
    public void setValidRegistration(boolean validRegistration) {
        this.validRegistration = validRegistration;
    }
}