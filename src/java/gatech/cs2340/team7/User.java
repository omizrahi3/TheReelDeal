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
    
    public User() {
        account = new Account();
    }
    
    public User(Account account) {
        this.account = account;
    }

    public String getRealName() {
        return this.realName;
    }
    
    public Account getAccount() {
        return account;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public void setAccount(Account myAccount) {
        this.account = myAccount;
    }
    
    public String logout() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return NavigationManager.index;
    }  
}
