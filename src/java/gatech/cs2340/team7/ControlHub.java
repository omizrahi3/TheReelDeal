/**
 * The gatech.cs2340.team7 package holds controllers
 */
package gatech.cs2340.team7;

import UserManagement.User;
import UserManagement.UserManager;
import java.io.Serializable;

/**
 * Coordinates between the UserManager and RottenTomatoesDataManager
 * @author Anthony
 * @version 1.0
 */
public class ControlHub implements Serializable {
    
    // Static constant strings for ease of xhtml page navigation
    public static final String registerPageURL          = "register?faces-redirect=true";
    public static final String editProfilePageURL       = "editProfile?faces-redirect=true";
    public static final String userDashboardPageURL     = "userDashboard?faces-redirect=true";
    public static final String loginPageURL             = "login?faces-redirect=true";
    public static final String indexPageURL             = "index?faces-redirect=true";
    public static final String movieHubPageURL          = "movieHub?faces-redirect=true";
    public static final String postReviewPageURL        = "postReview?faces-redirect=true";
    public static final String errorPageURL             = "error?faces-redirect=true";
    public static final String movieDetailedViewPageURL = "movieDetailedView?faces-redirect=true";
    public static final String adminDashboardPageURL    = "adminDashboard?faces-redirect=true";
    
    public static final String pathToDataPersistence    = "C:\\Users\\Anthony\\Desktop\\Temp\\";
    
    // Instance data members
    private UserManager userManager;
    private MovieManager movieManager;
    private RottenTomatoesDataManager dataManager; // TODO should be a more generic DataManager type
    private static ControlHub instance = null;
    
    /**
     * A constructor used to defeat instantiation of the controller
     */
    protected ControlHub() {
        // to defeat instantiation
    }
    
    /**
     * Creates an instance of the ControlHub
     * @return instance A private instantiation of the ControlHub
     */
    public static ControlHub getInstance() {
        if (instance == null) {
            instance = new ControlHub();
        }
        return instance;
    }
    
    /**
     * Determines which home page URL to provide depending on admin status
     * @param isAdmin Whether the user is an admin
     * @return The appropriate XHTML information for the home page
     */
    public static String dashboardPageURL(boolean isAdmin) {
        return (isAdmin ? adminDashboardPageURL : userDashboardPageURL);
    }
    
    /**
     * Determines which home page URL to provide depending on admin status
     * @return The appropriate XHTML information for the home page
     */
    public String activeUserDashboardPageURL() {
        return (userManager.getActiveUser().isAdmin() ? adminDashboardPageURL :
                userDashboardPageURL);
    }
    
    /**
     * Writes to an output file the most current user list
     */
    public void userUpdate() {
        userManager.saveState();
    }
    
    /**
     * Writes to an output file the most current user list
     * as well as the movies that users rated
     */
    public void saveState() {
        dataManager.saveState();
        userManager.saveState();
    }
    
    /**
     * Constructs a ControlHub with a specified userManager and movieManager
     * @param userManager The user controller
     * @param movieManager The movie controller
     */
    public ControlHub(UserManager userManager, MovieManager movieManager) {
        this.userManager = userManager;
        this.movieManager = movieManager;
    }
    
    /**
     * Getter method for the active user
     * @return The active user
     */
    public User getActiveUser() {
        return userManager.getActiveUser();
    }

    /**
     * Getter method for the user manager
     * @return userManager The user manager
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * Setter method for the user manager
     * @param userManager The user manager
     */
    public void setUserManager(UserManager userManager) {
        System.out.println("Setting user mgt to " + userManager);
        this.userManager = userManager;
    }
    
    
    /**
     * Setter method for the movie manager
     * @param movieManager The movie manager
     */
    public void setMovieManager(MovieManager movieManager) {
        System.out.println("Setting movie mgt to " + movieManager);
        this.movieManager = movieManager;
    }
    
    /**
     * Getter method for the movie manager
     * @return movieManager The movie manager
     */
    public MovieManager getMovieManager() {
        if (movieManager == null) {
            movieManager = new MovieManager();
        }
        return movieManager;
    }

    /**
     * Getter method for the data manager
     * @return dataManager The data manager
     */
    public RottenTomatoesDataManager getDataManager() {
        return dataManager;
    }

    /**
     * Setter method for the data manager
     * @param dataManager The data manager
     */
    public void setDataManager(RottenTomatoesDataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * Getter method for the indexPageURL page string
     * @return indexPageURL The page string
     */
    public String getIndexPageURL() {
        return indexPageURL;
    }

    /**
     * Getter method for the registerPageURL page string
     * @return registerPageURL The page string
     */
    public String getRegisterPageURL() {
        return registerPageURL;
    }

    /**
     * Getter method for the edit profile page string
     * @return editProfilePageURL The page string
     */
    public String getEditProfilePageURL() {
        return editProfilePageURL;
    }

    /**
     * Getter method for the movie hub page string
     * @return movieHubPageURL The page string
     */
    public String getMovieHubPageURL() {
        return movieHubPageURL;
    }

    /**
     * Getter method for the userDashboardPageURL page string
     * @return userDashboardPageURL The page string
     */
    public String getUserDashboardPageURL() {
        return userDashboardPageURL;
    }

    /**
     * Getter method for the post review page string
     * @return postReviewPageURL The page string
     */
    public String getPostReviewPageURL() {
        return postReviewPageURL;
    }

    /**
     * Getter method for the movie detailed view page string
     * @return movieDetailedViewPageURL The page string
     */
    public String getMovieDetailedViewPageURL() {
        return movieDetailedViewPageURL;
    }

    /**
     * Getter method for the loginPageURL page string
     * @return loginPageURL The page string
     */
    public String getLoginPageURL() {
        return loginPageURL;
    }

    /**
     * Getter method for the errorPageURL page string
     * @return errorPageURL The page string
     */
    public String getErrorPageURL() {
        return errorPageURL;
    }
    
    /**
     * Writes to an output file the movies that users rated
     */
    public void movieUpdate() {
        movieManager.saveState();
    }
}
