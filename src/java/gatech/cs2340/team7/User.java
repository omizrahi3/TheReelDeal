/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User {
    
    private String realName;
    public String newString;
    @ManagedProperty(value="#{userAccount}")
    private Account account;
    private Profile myProfile;
    //private List<Message> myMessages;
    
    /**
     * Basic constructor
     */
    public User() {
        account = new Account();
    }
    
    /**
     * Constructor that sets the account on instantiation
     * @param account account to set
     */
    public User(Account account) {
        this.account = account;
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
