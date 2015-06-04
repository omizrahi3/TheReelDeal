/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jimmy
 */
@ManagedBean(name = "navigationManager", eager = true)
@RequestScoped
public class NavigationManager {
    
    public static String success() {
        return "success?faces-redirect=true";
    }
    
    public static String error() {
        return "error?faces-redirect=true";
    }
    
    public static String login() {
        return "login?faces-redirect=true";
    }
    
    public static String register() {
        return "register?faces-redirect=true";
    }
    
    public static String index() {
        return "index?faces-redirect=true";
    }
    
}
