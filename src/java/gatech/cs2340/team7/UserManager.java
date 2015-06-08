/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    
    public String loginExistingUser() throws Exception {
        if (login.checkLogin(userList, passwords)) {
            System.out.println("Login success!");
            activeUser = userWithUsername(login.getUsername());
            return NavigationManager.success;
        } else {
            System.out.println("Login failed!");
            return null;
        }
    }
    
    public String registerNewUser() {
        if (registration.registerNewUser(userList)) {
            System.out.println("Successful registration attempt!");
            return NavigationManager.success;
        } else {
            System.out.println("Failed registration attempt!");
            return null;
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
