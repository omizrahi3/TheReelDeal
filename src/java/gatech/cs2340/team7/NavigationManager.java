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
    
    public static final String success = "success?faces-redirect=true";
    
    public static final String error = "error?faces-redirect=true";
    
    public static final String login = "login?faces-redirect=true";
    
    public static final String register = "register?faces-redirect=true";
    
    public static final String index = "index?faces-redirect=true";
}
