/*
UserManager class that controls and handles all users and their actions.
 */
package UserManagement;

import IO.PasswordIO;
import IO.UserIO;
import LoginRegistration.BannedAccountException;
import LoginRegistration.LockedAccountException;
import LoginRegistration.Registration;
import LoginRegistration.Login;
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
 *
 * @author Anthony
 */
@ManagedBean(name = "userManager", eager = true)
@ApplicationScoped
public class UserManager implements Serializable {
    private HashMap<String, User> allUsers;
    private final HashMap<String, String> passwords;
    private Login login;
    private Registration registration;
    private User activeUser;
    
    
    /**
     * Constructor
     */
    public UserManager() {
        allUsers = new HashMap<>();
        passwords = PasswordIO.readFile();
        login = new Login();
        registration = new Registration();
        activeUser = null;
        allUsers = UserIO.readFile();
        
        // Create hard-coded administrator to demonstrate privileges
        allUsers.put("boss", new Administrator("Da Boss", "boss", "bossPassword"));
        passwords.put("boss", "bossPassword");
        
        // Update the ControlHub with this instance
        ControlHub.getInstance().setUserManager(this);
    }
    
    /**
     * Navigate to the edit profile page
     * @return page name for XHTML navigation
     */
    public String editProfile() {
        return ControlHub.editProfilePageURL;
    }

    public String editProfileSuccess() {
        saveUserInfo();
        return ControlHub.dashboardPageURL(activeUser.isAdmin());
    }
    
    public String backHome() {
        return ControlHub.dashboardPageURL(activeUser.isAdmin());
    }
    
    /**
     * Attempt to log in an existing user
     * @return page name for XHTML navigation (if applicable)
     * @throws Exception if user is locked
     */
    public String loginExistingUser() throws Exception {
        User userToLogin = allUsers.get(login.getUsername());
        if (userToLogin == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Failed",
                        "User Does Not Exist!"));
        } else if (login.checkLogin(passwords) && processLogin(userToLogin)) {
            return ControlHub.dashboardPageURL(userToLogin.isAdmin());
        }
        return null;
    }
    
    public void printUsers() {
        System.out.println("Current users:");
        allUsers.values().stream().forEach((u) -> {
            System.out.println(u.getAccount().getUsername() + ": " + 
                    passwords.get(u.getAccount().getUsername()));
        });   
    }
    
    private boolean processLogin(User user) {
        System.out.println("Processing login for " + user.getName());
        activeUser = user;
        try {
            activeUser.loginToAccount();
            login.clearData();
            return true;
        } catch (BannedAccountException bannedException) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Failed",
                        "Account is banned! Please contact the administrator"));
            return false;
        } catch (LockedAccountException lockedException) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Failed",
                        "Account is locked! Please contact the administrator"));
            return false;
        }
    }
    
    /**
     * Register a new user
     * @return new page to navigation to (if registration is successful)
     */
    public String registerNewUser() {
        if (registration.checkNewUserRegistration(allUsers)) {
            // Registration userDashboardPageURL, create the user, account, and profile
            System.out.println("Successful registration attempt!");
            User newUser = registration.registerNewUser();
            addUser(newUser);
            processLogin(newUser);
            saveUserInfo();
            // Add the user->password mapping
            passwords.put(registration.getUsername(), registration.getPassword());
            PasswordIO.WriteToFile(passwords);
            registration.clearData();
            return ControlHub.userDashboardPageURL;
        } else {
            System.out.println("Failed registration attempt!");
            return null;
        }
    }
    
    /**
     * Add the user to the list
     * @param u User to add
     */
    public void addUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else {
            allUsers.put(u.getUsername(), u);
            System.out.println("Added new user. Updated user list:");
            allUsers.values().stream().forEach((user) -> {
                System.out.println("- " + user.getAccount().getUsername());
            });
        }
        
    }
    
    /**
     * Removes the user from the user list (and therefore the entire system)
     * @param u User to remove
     */
    public void removeUser(User u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else {
            allUsers.remove(u);
        }
    }
    
    public void saveUserInfo() {
        System.out.println("Saving state of users");
        UserIO.WriteToFile(allUsers);
    }
    
    /**
     * Return the loginPageURL handle
     * @return loginPageURL handle
     */
    public Login getLogin() {
        return login;
    }
    
    /**
     * Return the registration handle
     * @return registration handle
     */
    public Registration getRegistration() {
        return registration;
    }
    
    /**
     * Return the current active user
     * @return active user
     */
    public User getActiveUser() {
        return activeUser;
    }

    /**
     * Set the loginPageURL handle
     * @param login new loginPageURL handle
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * Set the registration handle
     * @param registration new registration handle
     */
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    
    /**
     * Set the active user
     * @param activeUser active user
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public HashMap<String, User> getAllUsers() {
        return allUsers;
    }
    
    public List<User> getAllUsersAsList() {
        System.err.println("Returning list of users with size " + allUsers.values().size());
        return new ArrayList<>(allUsers.values());
    }

    public void setAllUsers(HashMap<String, User> allUsers) {
        this.allUsers = allUsers;
    }
}
