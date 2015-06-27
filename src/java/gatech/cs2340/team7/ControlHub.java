/*
 * Control hub to coordinate between the UserManager and RottenTomatoesDataManager
 */
package gatech.cs2340.team7;

import UserManagement.User;
import UserManagement.UserManager;

/**
 *
 * @author Anthony
 */
public class ControlHub {
    
    // Static constant strings for ease of xhtml page navigation
    public static final String registerPageURL          = "register?faces-redirect=true";
    public static final String editProfilePageURL       = "editProfile?faces-redirect=true";
    public static final String successPageURL           = "success?faces-redirect=true";
    public static final String loginPageURL             = "login?faces-redirect=true";
    public static final String indexPageURL             = "index?faces-redirect=true";
    public static final String movieHubPageURL          = "movieHub?faces-redirect=true";
    public static final String postReviewPageURL        = "postReview?faces-redirect=true";
    public static final String errorPageURL             = "error?faces-redirect=true";
    public static final String movieDetailedViewPageURL = "movieDetailedView?faces-redirect=true";
    
    // Instance data members
    private UserManager userManager;
    private RottenTomatoesDataManager dataManager; // TODO should be a more generic DataManager type
    private static ControlHub instance = null;
    
    protected ControlHub() {
        // to defeat instantiation
    }
    
    public static ControlHub getInstance() {
        if (instance == null) {
            instance = new ControlHub();
        }
        return instance;
    }
    
    /**
     * Constructor
     * @param userManager UserManager
     */
    public ControlHub(UserManager userManager) {
        this.userManager = userManager;
    }
    
    /**
     * Return the active user
     * @return active user
     */
    public User getActiveUser() {
        return userManager.getActiveUser();
    }

    /**
     * Get the user manager
     * @return user manager
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * Set the user manager
     * @param userManager user manager
     */
    public void setUserManager(UserManager userManager) {
        System.out.println("Setting user mgt to " + userManager);
        this.userManager = userManager;
    }

    /**
     * Get the data manager
     * @return data manager
     */
    public RottenTomatoesDataManager getDataManager() {
        return dataManager;
    }

    /**
     * Set the data manager
     * @param dataManager data manager
     */
    public void setDataManager(RottenTomatoesDataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Get the indexPageURL page string
     * @return page string
     */
    public String getIndexPageURL() {
        return indexPageURL;
    }

    /**
     * Get the registerPageURL page string
     * @return page string
     */
    public String getRegisterPageURL() {
        return registerPageURL;
    }

    /**
     * Get the edit profile page string
     * @return page string
     */
    public String getEditProfilePageURL() {
        return editProfilePageURL;
    }

    /**
     * Get the movie hub page string
     * @return page string
     */
    public String getMovieHubPageURL() {
        return movieHubPageURL;
    }

    /**
     * Get the successPageURL page string
     * @return page string
     */
    public String getSuccessPageURL() {
        return successPageURL;
    }

    /**
     * Get the post review page string
     * @return page string
     */
    public String getPostReviewPageURL() {
        return postReviewPageURL;
    }

    /**
     * Get the movie detailed view page string
     * @return page string
     */
    public String getMovieDetailedViewPageURL() {
        return movieDetailedViewPageURL;
    }

    /**
     * Get the loginPageURL page string
     * @return page string
     */
    public String getLoginPageURL() {
        return loginPageURL;
    }

    /**
     * Get the errorPageURL page string
     * @return page string
     */
    public String getErrorPageURL() {
        return errorPageURL;
    }
    
    
    
    
}
