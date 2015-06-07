/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "registration", eager = true)
@SessionScoped
public class Registration {
    private String realName;
    private String username;
    private String password;
    private String passwordRepeat;
    private String major;
    private MajorMenuView majorChooser;
    
    public Registration() {
        System.out.println("Instantiating MajorMenuView object from Registration constructor.");
        majorChooser = new MajorMenuView();
    }
    
    public String getRealName() {
        return realName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getPasswordRepeat() {
        return passwordRepeat;
    }
    
    public String getMajor() {
        return major;
    }
    
    public MajorMenuView getMajorChooser() {
        return majorChooser;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setMajorChooser(MajorMenuView majorChooser) {
        this.majorChooser = majorChooser;
    }
}
