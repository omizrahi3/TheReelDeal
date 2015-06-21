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
    
    public static final String movieHub = "movieHub?faces-redirect=true";
    
    public static final String movieDetailedView = "movieDetailedView?faces-redirect=true";
    
    public static final String postReview = "postReview?faces-redirect=true";
    
    /**
     * Get the success page string
     * @return page string
     */
    public String getSuccess() {
        return success;
    }
    
    /**
     * Get the error page string
     * @return page string
     */
    public String getError() {
        return error;
    }

    /**
     * Get the login page string
     * @return page string
     */
    public String getLogin() {
        return login;
    }

    /**
     * Get the register page string
     * @return page string
     */
    public String getRegister() {
        return register;
    }

    /**
     * Get the index page string
     * @return page string
     */
    public String getIndex() {
        return index;
    }

    /**
     * Get the edit profile page string
     * @return page string
     */
    public String getEditProfile() {
        return editProfile;
    }

    /**
     * Get the movie hub page string
     * @return page string
     */
    public String getMovieHub() {
        return movieHub;
    }

    /**
     * Get the movie detailed view page string
     * @return page string
     */
    public String getMovieDetailedView() {
        return movieDetailedView;
    }

    /**
     * Get the post review page string
     * @return page string
     */
    public String getPostReview() {
        return postReview;
    }
    
}