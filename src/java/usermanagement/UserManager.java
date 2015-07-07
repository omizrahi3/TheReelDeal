/**
 * Handles the features of a user.
 */
package usermanagement;

import input.output.PasswordIO;
import input.output.UserIO;
import loginregistration.BannedAccountException;
import loginregistration.LockedAccountException;
import loginregistration.Registration;
import loginregistration.Login;
import gatech.cs2340.team7.ControlHub;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Controls and handles all users and their actions
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "userManager", eager = true)
@ApplicationScoped
public class UserManager implements Serializable {
    
    // Map holding all users, keyed by their username
    private HashMap<String, User> allUsers;
    
    // Map holding all passwords, keyed by the associated username
    private final HashMap<String, String> passwords;
    
    // Handle for processing all login attempts
    private Login login;
    
    // Handle for processing all registration attempts
    private Registration registration;
    
    // Reference to the current active user
    private User activeUser;
    
    /**
     * Constructs a user manager which handles user status and login credentials
     */
    public UserManager() {
        allUsers = new HashMap<>();
        login = new Login();
        registration = new Registration();
        activeUser = null;
        
        // Read in persisted user/password data
        allUsers = UserIO.readFile();
        passwords = PasswordIO.readFile();
        
        // Create hard-coded administrator to demonstrate admin privileges
        allUsers.put("boss", new Administrator("Da Boss", "boss", "bossPassword"));
        passwords.put("boss", "bossPassword");
        
        // Update the ControlHub with this instance
        ControlHub.getInstance().setUserManager(this);
    }
    
    /**
     * Navigates to the edit profile page
     * @return page name for XHTML navigation
     */
    public String getEditProfilePage() {
        return ControlHub.EDIT_PROFILE_URL;
    }

    /**
     * Saves edits to profile
     * @return home page name for XTML navigation
     */
    public String editProfileSuccess() {
        saveState();
        return ControlHub.dashboardPageURL(activeUser.isAdmin());
    }
    
    /**
     * Navigates the user back to the home page
     * @return home page name for XTML navigation
     */
    public String getUserHomePage() {
        return ControlHub.dashboardPageURL(activeUser.isAdmin());
    }
    
    /**
     * Attempts to log in an existing user
     * @return next XHTML page URL to display
     */
    public String loginExistingUser() {
        User userToLogin = allUsers.get(login.getUsername());
        String nextPage = null;
        if (userToLogin == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Failed",
                        "Username Does Not Exist! Please register for an " +
                        "account."));
        } else if (login.checkLogin(passwords) && processLogin(userToLogin)) {
            nextPage = ControlHub.dashboardPageURL(userToLogin.isAdmin());
        }
        return nextPage;
    }
    
    /**
     * Attempts to log the user into their account
     * Handles cases where the user is banned or locked out
     * @param user The user logging into The Reel Deal
     * @return Whether the user successfully logged in
     */
    private boolean processLogin(User user) {
        try {
            activeUser.loginToAccount();
            login.clearData();
            activeUser = user;
            return true;
        } catch (BannedAccountException |
                LockedAccountException accountException) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Failed",
                        accountException.getMessage() +
                        "! Please contact the administrator"
                        + " at aagnone3@gatech.edu.")); // constant member
            return false;
        }
    }
    
    /**
     * Registers a new user within the system
     * @return the user's home page to navigate to (if registration is successful)
     */
    public String registerNewUser() {
        String nextPage = null;
        if (registration.checkNewUserRegistration(allUsers)) {
            // Registration USER_HOME_URL, create the user, account, and profile
            System.out.println("Successful registration attempt!");
            User newUser = registration.registerNewUser();
            addUser(newUser);
            processLogin(newUser);
            // Add the user->password mapping
            passwords.put(registration.getUsername(), registration.getPassword());
            registration.clearData();
            saveState();
            nextPage = ControlHub.USER_HOME_URL;
        } else {
            System.out.println("Failed registration attempt!");
        }
        return nextPage;
    }
    
    /**
     * Adds the user to the valid user list
     * @param u The user to add to the list
     */
    public void addUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else {
            allUsers.put(u.getUsername(), u);
            System.out.println("Added new user. Updated user list:");
        }
    }
    
    /**
     * Removes the user from the user list (and therefore the entire system)
     * @param u The user to remove from the list
     */
    public void removeUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else {
            allUsers.remove(u.getUsername());
        }
    }
    
    /**
     * Writes to an output file the most current user list
     */
    public void saveState() {
        System.out.println("Saving state of users.");
        UserIO.WriteToFile(allUsers);
        PasswordIO.WriteToFile(passwords);
    }
    
    /**
     * Getter method for the LOGIN_URL handle
     * @return login The LOGIN_URL handle
     */
    public Login getLogin() {
        return login;
    }
    
    /**
     * The getter method for the registration handle
     * @return registration The registration handle
     */
    public Registration getRegistration() {
        return registration;
    }
    
    /**
     * Getter method for the current active user
     * @return activeUser The active user
     */
    public User getActiveUser() {
        return activeUser;
    }

    /**
     * Setter method for the LOGIN_URL handle
     * @param login The new LOGIN_URL handle
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * Setter method for the registration handle
     * @param registration The new registration handle
     */
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    
    /**
     * Setter method for the active user
     * @param activeUser The active user
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    /**
     * Getter method for a map holding all valid users
     * @return allUsers The users registered with the application
     */
    public HashMap<String, User> getAllUsers() {
        return allUsers;
    }
    
    /**
     * Getter method for a list holding all valid users
     * @return An array list holding all users
     */
    public List<User> getAllUsersAsList() {
        return new ArrayList<>(allUsers.values());
    }

    /**
     * Setter method for the map holding all valid users
     * @param allUsers The users registered with the application
     */
    public void setAllUsers(HashMap<String, User> allUsers) {
        this.allUsers = allUsers;
    }
}
