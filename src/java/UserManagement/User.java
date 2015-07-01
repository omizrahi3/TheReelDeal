/**
 * The UserManagement package handles the features of a user
 */
package UserManagement;

import LoginRegistration.BannedAccountException;
import LoginRegistration.LockedAccountException;
import gatech.cs2340.team7.ControlHub;
import com.rottentomatoes.ReelDealRating;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Represents the user of the application The Reel Deal
 * Contains their Account and Profile
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User implements Serializable {
    
    private Account account;
    private Profile profile;
    private HashMap<String, ReelDealRating> movieRatings;
    
    //Feature that could be added later
    //private List<Message> myMessages;
    
    /**
     * Constructs a user with no name who possesses a new account and profile
     */
    public User() {
        this(null, new Account(), new Profile());
    }
    
    /**
     * Constructs a user with a specified name, username, password, and admin status
     * @param name The birth name of the user
     * @param username The screen name of the user
     * @param password The password credential that grants account access
     * @param admin Whether the user has admin privileges
     */
    public User(String name, String username, String password, boolean admin) {
        this(name, new Account(username, admin), new Profile());
    }
    
    /**
     * Determines if the user has admin privileges
     * @return isAdmin Whether the user's account has admin features
     */
    public boolean isAdmin() {
        return account.isAdmin();
    }
    
    /**
     * Constructs a user with a specified name, account, and profile
     * @param name The birth name of the user
     * @param account The user's account
     * @param profile The user's profile
     */
    public User(String name, Account account, Profile profile) {
        this.account = account;
        this.profile = profile;
        this.profile.setName(name);
        this.movieRatings = new HashMap<>();
    }
    
    /**
     * Attempts to log the user into their account 
     * If the loginPageURL fails, it notifies the user on the web page
     * @throws LockedAccountException Handles a locked out user
     * @throws BannedAccountException Handles a banned user 
     */
    public void loginToAccount() throws LockedAccountException,
            BannedAccountException {
        try {
            account.login();
        } catch (LockedAccountException | BannedAccountException accountException) {
            throw accountException;
        }
    }
    
    /**
     * Locks the account and prints a message recording that action
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public String lock() {
        System.out.println("Locking user " + this.getUsername());
        account.lock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Unlocks the account and prints a message recording that action
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public String unlock() {
        System.out.println("Unlocking user " + this.getUsername());
        account.unlock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Bans the user from account access and prints a message on that act
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public String ban() {
        System.out.println("Banning user " + this.getUsername());
        account.ban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Unbans the user from account access and prints a message on that act
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public String unban() {
        System.out.println("Unbanning user " + this.getUsername());
        account.unban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Logs the user out of the application
     * @return indexPageURL The xhtml page navigation token
     */
    public String logout() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ControlHub.indexPageURL;
    }
    
    /**
     * Determines the status of the account in terms of ban and lock
     * @return account.getStatus The status of the user's account
     */
    public String getAccountStatus() {
        return account.getStatus();
    }
    
    /**
     * Creates a rating for a movie selected by the user
     * @param movieId The ID of the film
     * @param newRating The user's rating based on The Reel Deal rating system
     */
    public void newMovieRating(String movieId, ReelDealRating newRating) {
        movieRatings.put(movieId, newRating);
        ControlHub.getInstance().userUpdate();
    }
    
    /**
     * Determines whether the user has rated a particular movie
     * @param movieId The ID of the film
     * @return Whether a rating was given
     */
    public boolean hasRatedMovie(String movieId) {
        return (movieRatings.get(movieId) != null);
    }
    
    /**
     * Getter method for a rated movie
     * @param movieId The ID of the film
     * @return rating The Reel Deal rating the user gave
     */
    public ReelDealRating getMovieReviewFor(String movieId) {
        ReelDealRating rating = movieRatings.get(movieId);
        rating.assertReels(rating.getValue());
        return rating;
    }

    /**
     * Getter method for the birth name of the user
     * @return profile.getName The user's birth name
     */
    public String getName() {
        return this.profile.getName();
    }
    
    /**
     * Getter method for the account of the user
     * @return account The user's account
     */
    public Account getAccount() {
        return account;
    }
    
    /**
     * Getter method for the profile of the user
     * @return profile The user's profile
     */
    public Profile getProfile() {
        return profile;
    }
    
    /**
     * Setter for the name of the user
     * @param name The user's name
     */
    public void setName(String name) {
        this.profile.setName(name);
    }
    
    /**
     * Setter for the account of the user
     * @param myAccount The user's account
     */
    public void setAccount(Account myAccount) {
        this.account = myAccount;
    }
    
    /**
     * Setter for the user's profile
     * @param profile The user's profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    /**
     * Getter for the user's major
     * @return The user's major
     */
    public String getMajor() {
        return profile.getMajor();
    }
    
    /**
     * Setter for the user's major
     * @param major The user's major
     * @return major + akjaisdj A string holding the major plus a set ending
     */
    public void setMajor(String major) {
        profile.setMajor(major);
        System.out.println(major + "akjaisdj");
    }
    
    /**
     * Getter for the username
     * @return account.getUsername The user's profile name
     */
    public String getUsername() {
        return account.getUsername();
    }
    
    /**
     * Setter for the username
     * @param username The user's profile name
     */
    public void setUsername(String username) {
        this.account.setUsername(username);
    }
    
    /**
     * Determines the ban status of the user's account
     * @return Whether the account is banned
     */
    public boolean isBanned() {
        return account.isBanned();
    }
    
    /**
     * Setter method for the ban status of the user's account
     * @param banned The ban status of the account to change to
     */
    public void setBanned(boolean banned) {
        account.setBanned(banned);
    }
    
    /**
     * Determines the lock status of the user's account
     * @return Whether the user is locked out of their account
     */
    public boolean isLocked() {
        return account.isLocked();
    }
    
    /**
     * Setter method for the account lock status
     * @param locked The lock status of the account to change to
     */
    public void setLocked(boolean locked) {
        account.setLocked(locked);
    }

    /**
     * Getter method for the movie rating assigned by the user
     * @return movieRatings The given movie rating attached to a movie ID
     */
    public HashMap<String, ReelDealRating> getMovieRatings() {
        return movieRatings;
    }

    /**
     * Setter method for the movie rating assigned by the user
     * @param movieRatings The given movie rating attached to a movie ID
     */
    public void setMoveRatings(HashMap<String, ReelDealRating> movieRatings) {
        this.movieRatings = movieRatings;
    }
}
