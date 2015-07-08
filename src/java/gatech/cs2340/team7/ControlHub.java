/*
 * Contains various overarching manager
 * handles for directing the control and flow of the application.
 */
package gatech.cs2340.team7;

import usermanagement.User;
import usermanagement.UserManager;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Coordinates between the UserManager and RottenTomatoesDataManager.
 *
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "controlHub", eager = true)
@SessionScoped
public class ControlHub implements Serializable {

    /**
     * XHTML URL for the registration page.
     */
    public static final String REGISTER_URL
            = "register?faces-redirect=true";

    /**
     * XHTML URL for the profile editing page.
     */
    public static final String EDIT_PROFILE_URL
            = "editProfile?faces-redirect=true";

    /**
     * XHTML URL for the user home page.
     */
    public static final String USER_HOME_URL
            = "userDashboard?faces-redirect=true";

    /**
     * XHTML URL for the login page.
     */
    public static final String LOGIN_URL
            = "login?faces-redirect=true";

    /**
     * XHTML URL for the index page.
     */
    public static final String INDEX_URL
            = "index?faces-redirect=true";

    /**
     * XHTML URL for the movie hub page.
     */
    public static final String MOVIE_HUB_URL
            = "movieHub?faces-redirect=true";

    /**
     * XHTML URL for the post review page.
     */
    public static final String POST_REVIEW_URL
            = "postReview?faces-redirect=true";

    /**
     * XHTML URL for the error page.
     */
    public static final String ERROR_URL
            = "error?faces-redirect=true";

    /**
     * XHTML URL for the movie detail page.
     */
    public static final String MOVIE_DETAIL_URL
            = "movieDetailedView?faces-redirect=true";

    /**
     * XHTML URL for the administrator home page.
     */
    public static final String ADMIN_HOME_URL
            = "adminDashboard?faces-redirect=true";

    /**
     * Path for loading/saving object persistence files.
     */
    public static final String SAVE_PATH
            = "C:\\Users\\Anthony\\Desktop\\Temp\\";

    /**
     * Controller for all users.
     */
    private UserManager userManager;

    /**
     * Controller for all movies.
     */
    private MovieManager movieManager;

    /**
     * Controller for all Rotten Tomatoes data processing.
     */
    private RottenTomatoesDataManager dataManager;

    /**
     * Singleton instance of this class.
     */
    private static ControlHub instance = null;

    /**
     * A constructor used to defeat instantiation of the controller.
     */
    private ControlHub() {

    }

    /**
     * Creates an instance of the ControlHub.
     *
     * @return instance A private instantiation of the ControlHub
     */
    public static ControlHub getInstance() {
        if (instance == null) {
            instance = new ControlHub();
        }
        return instance;
    }

    /**
     * Determines which home page URL to provide depending on
     * administrator status.
     *
     * @param isAdmin Whether the user is an administrator
     * @return The appropriate XHTML information for the home page
     */
    public static String dashboardPageURL(
            final boolean isAdmin) {
        String dashboardPageURL;
        if (isAdmin) {
            dashboardPageURL = ADMIN_HOME_URL;
        } else {
            dashboardPageURL = USER_HOME_URL;
        }
        return dashboardPageURL;
    }

    /**
     * Determines which home page URL to provide depending on
     * administrator status.
     *
     * @return The appropriate XHTML information for the home page
     */
    public String activeUserDashboardPageURL() {
        String activeUserDash;
        if (userManager.getActiveUser().isAdmin()) {
            activeUserDash = ADMIN_HOME_URL;
        } else {
            activeUserDash = USER_HOME_URL;
        }
        return activeUserDash;
    }

    /**
     * Writes to an output file the most current user list.
     */
    public void userUpdate() {
        userManager.saveState();
    }

    /**
     * Writes to an output file the most current user list as well as
     * the movies that users rated.
     */
    public void saveState() {
        dataManager.saveState();
        userManager.saveState();
    }

    /**
     * Getter method for the active user.
     *
     * @return The active user
     */
    public User getActiveUser() {
        return userManager.getActiveUser();
    }

    /**
     * Getter method for the user manager.
     *
     * @return userManager The user manager
     */
    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * Setter method for the user manager.
     *
     * @param newUserManager The user manager
     */
    public void setUserManager(final UserManager newUserManager) {
        this.userManager = newUserManager;
    }

    /**
     * Setter method for the movie manager.
     *
     * @param newMovieManager The movie manager
     */
    public void setMovieManager(final MovieManager newMovieManager) {
        this.movieManager = newMovieManager;
    }

    /**
     * Getter method for the movie manager.
     *
     * @return movieManager The movie manager
     */
    public MovieManager getMovieManager() {
        if (movieManager == null) {
            movieManager = new MovieManager();
        }
        return movieManager;
    }

    /**
     * Getter method for the data manager.
     *
     * @return dataManager The data manager
     */
    public RottenTomatoesDataManager getDataManager() {
        return dataManager;
    }

    /**
     * Setter method for the data manager.
     *
     * @param newDataManager The data manager
     */
    public void setDataManager(
            final RottenTomatoesDataManager newDataManager) {
        this.dataManager = newDataManager;
    }

    /**
     * Getter method for the INDEX_URL page string.
     *
     * @return INDEX_URL The page string
     */
    public String getIndexUrl() {
        return INDEX_URL;
    }

    /**
     * Getter method for the REGISTER_URL page string.
     *
     * @return REGISTER_URL The page string
     */
    public String getRegisterUrl() {
        return REGISTER_URL;
    }

    /**
     * Getter method for the edit profile page string.
     *
     * @return EDIT_PROFILE_URL The page string
     */
    public String getEditProfileUrl() {
        return EDIT_PROFILE_URL;
    }

    /**
     * Getter method for the movie hub page string.
     *
     * @return MOVIE_HUB_URL The page string
     */
    public String getMovieHubUrl() {
        return MOVIE_HUB_URL;
    }

    /**
     * Getter method for the USER_HOME_URL page string.
     *
     * @return USER_HOME_URL The page string
     */
    public String getUserHomeUrl() {
        return USER_HOME_URL;
    }

    /**
     * Getter method for the post review page string.
     *
     * @return POST_REVIEW_URL The page string
     */
    public String getPostReviewUrl() {
        return POST_REVIEW_URL;
    }

    /**
     * Getter method for the movie detailed view page string.
     *
     * @return MOVIE_DETAIL_URL The page string
     */
    public String getMovieDetailUrl() {
        return MOVIE_DETAIL_URL;
    }

    /**
     * Getter method for the LOGIN_URL page string.
     *
     * @return LOGIN_URL The page string
     */
    public String getLoginUrl() {
        return LOGIN_URL;
    }

    /**
     * Getter method for the ERROR_URL page string.
     *
     * @return ERROR_URL The page string
     */
    public String getErrorUrl() {
        return ERROR_URL;
    }

    /**
     * Writes to an output file the movies that users rated.
     */
    public void movieUpdate() {
        movieManager.saveState();
    }
}
