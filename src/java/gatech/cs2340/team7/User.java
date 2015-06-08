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
    
    private String realName;
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
     * @param realName Real name of user
     * @param account Account for user
     * @param profile Profile for user
     */
    public User(String realName, Account account, Profile profile) {
        this.realName = realName;
        this.account = account;
        this.profile = profile;
    }

    /**
     * Get the real name of the user
     * @return user's real name
     */
    public String getRealName() {
        return this.realName;
    }
    
    /**
     * Get the account of the user
     * @return user's account
     */
    public Account getAccount() {
        return account;
    }
    
    public Profile getProfile() {
        return profile;
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
     * Set the real name of the user
     * @param realName user's real name
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    /**
     * Set the account of the user
     * @param myAccount user's account
     */
    public void setAccount(Account myAccount) {
        this.account = myAccount;
    }
}
