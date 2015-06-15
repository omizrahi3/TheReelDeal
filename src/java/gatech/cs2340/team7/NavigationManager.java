/*
Class that currently only holds static references to xhtml page names;
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
    
    // Static constant strings for ease of xhtml page navigation
    public static final String success = "success?faces-redirect=true";
    
    public static final String error = "error?faces-redirect=true";
    
    public static final String login = "login?faces-redirect=true";
    
    public static final String register = "register?faces-redirect=true";
    
    public static final String index = "index?faces-redirect=true";
    
    public static final String editProfile = "editProfile?faces-redirect=true";
    
    public static final String movieSearch = "movieSearch?faces-redirect=true";
    
    public String getSuccess() {
        return success;
    }
}