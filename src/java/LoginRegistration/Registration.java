/*
Registration class to handle aspect of a new user's registration. This class
extends the abstract AccountAcessAttempt.
 */
package LoginRegistration;

import UserManagement.Account;
import UserManagement.Profile;
import UserManagement.User;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anthony
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
     * Constructor
     */
    public Registration() {
        majorChooser = new MajorChooserMenu();
    }
    
    /**
     * Create a new user.
     * NOTE: This method will only be called after registration data
     *       has been validated
     * @return new User with relevant data populated
     */
    public User registerNewUser() {
        System.out.println("Creating account for " + name +
                " with username " + username);
        return new User(name, new Account(username), new Profile(name, major));
    }
    
    /**
     * Check the validity of the registration data, and return whether
     * data is valid or not
     * @param users List of users to check existence of desired username
     * @return Whether registration data is valid
     */
    public boolean checkNewUserRegistration(List<User> users) {
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
     * Returns whether the given user already exists in the user list
     * @param username User to check for
     * @return Indication of the user's preexistence in the user list 
     */
    public boolean usernameExists(String username, List<User> userList) {
        if (username == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        }
        
        for (User u : userList) {
            if (username.equals(u.getAccount().getUsername())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Determine whether the password and repeated password match
     * @return Indication of whether the password and repeated password match
     */
    public boolean passwordsMatch() {
        return password.equals(passwordRepeat);
    }
    
    @Override
    public void clearData() {
        super.clearData();
        this.name = "";
        this.passwordRepeat = "";
        this.major = "";
        this.validRegistration = false;
    }
    /**
     * Get name of the prospective user
     * @return name of the prospective user
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get repeated password for the prospective account
     * @return repeated password for the prospective account
     */
    public String getPasswordRepeat() {
        return passwordRepeat;
    }
    
    /**
     * Get the major of the prospective user
     * @return major of the prospective user
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Get the major chooser MajorChooserMenu of the prospective user
     * @return major chooser MajorChooserMenu of the prospective user
     */
    public MajorChooserMenu getMajorChooser() {
        return majorChooser;
    }
    
    /**
     * Get whether registration data is valid
     * @return whether registration data is valid
     */
    public boolean isValidRegistration() {
        return validRegistration;
    }
    
    /**
     * Set the name of the prospective user
     * @param name name of the prospective user
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the repeated password of the prospective account
     * @param passwordRepeat repeated password of the prospective account
     */
    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    /**
     * Set the major of the prospective user
     * @param major major of the prospective user
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /**
     * Set the major chooser for the prospective user
     * @param majorChooser major choose for the prospective user
     */
    public void setMajorChooser(MajorChooserMenu majorChooser) {
        this.majorChooser = majorChooser;
    }
    
    /**
     * Set the validity of the attempted registration
     * @param validRegistration validity of the attempted registration
     */
    public void setValidRegistration(boolean validRegistration) {
        this.validRegistration = validRegistration;
    }
}