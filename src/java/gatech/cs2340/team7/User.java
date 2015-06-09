/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User {
    
    private String name;
    private Account account;
    private Profile profile;
    //private List<Message> myMessages;
    
    /**
     * Basic constructor
     */
    public User() {
        this(null, new Account(), new Profile());
    }
    
    /**
     * Constructor specifying all members for a new user
     * @param name name of user
     * @param account Account for user
     * @param profile Profile for user
     */
    public User(String name, Account account, Profile profile) {
        this.name = name;
        this.account = account;
        this.profile = profile;
    }
    
    /**
     * Attempt to log the user into his/her account. If the login fails,
     * notify the user on the web page
     */
    public void loginToAccount() {
        try {
            account.login();
        } catch (Exception e) {
            // TODO indicate on webpage the login failure due to account lock
            System.out.println("Login failed due to account lock!");
        }
    }
    
    /**
     * Logout of the user's account
     * @return index.xhtml page navigation token
     */
    public String logout() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return NavigationManager.index;
    }  

    /**
     * Get the name of the user
     * @return user's name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the account of the user
     * @return user's account
     */
    public Account getAccount() {
        return account;
    }
    
    /**
     * Return the user's profile
     * @return user's profile
     */
    public Profile getProfile() {
        return profile;
    }
    
    /**
     * Set the name of the user
     * @param name user's name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the account of the user
     * @param myAccount user's account
     */
    public void setAccount(Account myAccount) {
        this.account = myAccount;
    }
    
    /**
     * Set the user's profile
     * @param profile user's profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
