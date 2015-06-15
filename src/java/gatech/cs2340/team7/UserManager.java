/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "userManager", eager = true)
@ApplicationScoped
public class UserManager {
   
    private final List<User> userList; // change to hash table for faster lookup?
    private final HashMap<String, String> passwords;
    private Login login;
    private Registration registration;
    private User activeUser;
    
    public UserManager() {
        userList = new ArrayList();
        passwords = new HashMap<>();
        login = new Login();
        registration = new Registration();
        activeUser = null;
        
        // Temporary addition of user until data persistence is added
        userList.add(new User());
        userList.get(0).getAccount().setUsername("user");
        passwords.put("user", "password");
    }
    
    public User userWithUsername(String username) throws Exception {
        for (User user : userList) {
            if (username.equals(user.getAccount().getUsername())) {
                return user;
            }
        }
        throw new Exception("Logged in a non-existent User!\nUsername: " + username);
    }
    
    public String editProfile() {
        return NavigationManager.editProfile;
    }
    
    public String loginExistingUser() throws Exception {
        if (login.checkLogin(userList, passwords)) {
            System.out.println("Login success!");
            activeUser = userWithUsername(login.getUsername());
            activeUser.loginToAccount();
            login.clearData();
            return NavigationManager.success;
        } else {
            System.out.println("Login failed!");
            System.out.println("Current users:");
            for (User u : userList) {
                System.out.println(u.getAccount().getUsername());
            }
            return null;
        }
    }
    
    public String registerNewUser() {
        if (registration.checkNewUserRegistration(userList)) {
            // Registration success, create the user, account, and profile
            System.out.println("Successful registration attempt!");
            User newUser = registration.registerNewUser();
            addUser(newUser);
            activeUser = newUser;
            
            // Add the user->password mapping
            passwords.put(registration.getUsername(), registration.getPassword());
            registration.clearData();
            return NavigationManager.success;
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
        } else if (!userList.add(u)) {
            System.out.println("Failed to add user to the user list!");
            // TODO actually notify the user of the failure
        } else {
            System.out.println("Added new user. Updated user list:");
            for (User user : userList) {
                System.out.println("- " + user.getAccount().getUsername());
            }
        }
        
    }
    
    /**
     * Removes the user from the user list (and therefore the entire system)
     * @param u User to remove
     * @throws FailedUserOperationException 
     */
    public void removeUser(User u) throws FailedUserOperationException {
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else if (!userList.remove(u)) {
            throw new FailedUserOperationException("Failed to add user to the user list!");
        }
    }
    
    /**
     * Return the login handle
     * @return login handle
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
     * Set the login handle
     * @param login new login handle
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
}