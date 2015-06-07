/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "userManager", eager = true)
@SessionScoped
public class UserManager {
    
    private List<User> userList; // change to hash table for faster lookup?
    private HashMap<String, String> passwords;
    private Login login;
    private Registration registration;
    private User activeUser;
    
    public UserManager() {
        System.out.println("Hello from UserManager constructor");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("UserManager.init()");
        userList = new ArrayList();
        userList.add(new User());
        userList.get(0).getAccount().setUsername("user");
        
        passwords = new HashMap<>();
        passwords.put("user", "password");
        login = new Login();
        registration = new Registration();
    }
    
    protected User userWithUsername(String username) throws Exception {
        for (User user : userList) {
            if (username.equals(user.getAccount().getUsername())) {
                return user;
            }
        }
        throw new Exception("Logged in a non-existent User!\nUsername: " + username);
    }
    
    public String loginExistingUser() throws Exception {
        String username = login.getUsername();
        String password = login.getPassword();
        System.out.println("Login attempt with username <" + username + "> "
            + " and password <" + password + ">");
        boolean passwordMatch = password.equals(passwords.get(username));
        
        if (passwordMatch) {
            System.out.println("Login success!");
            activeUser = userWithUsername(username);
            return NavigationManager.success;
        } else if (username.length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Please enter username."));
            return null;           
        } else if (password.length() == 0) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Please enter password."));
            return null;              
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Incorrect username or password!"));
            return null;
        }
    }
    
    public void registerNewUser() {
        // check if username already exists
        if (usernameExists(registration.getUsername())) {
            // tell the user that username already exists
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username already exists!"));
        } else if (!passwordsMatch()) {
            // tell the user that the passwords don't match
            // OPTIONAL: check for numbers as well as letters in password
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Passwords do not match!"));
        } else {
            System.out.println("Major chosen: <" + registration.getMajor() + ">");
            // Successful registration. Create the user's profile
            System.out.println("Successful user registration!");
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Preparing your profile..."));            
        }
        
    }
    
    /**
     * Add the user to the list
     * @param u User to add
     * @throws FailedUserOperationException
     */
    public void addUser(User u) throws FailedUserOperationException{
        if (u == null) {
            throw new IllegalArgumentException("Cannot input null data!");
        } else if (!userList.add(u)) {
            throw new FailedUserOperationException("Failed to add user to the user list!");
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
     * Returns whether the given user already exists in the user list
     * @param username User to check for
     * @return Indication of the user's preexistence in the user list 
     */
    public boolean usernameExists(String username) {
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
    
    public boolean passwordsMatch() {
        return registration.getPassword().equals(registration.getPasswordRepeat());
    }
    
    public Login getLogin() {
        return login;
    }
    
    public Registration getRegistration() {
        return registration;
    }
    
    public User getActiveUser() {
        return activeUser;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
