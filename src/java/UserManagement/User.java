/*
User class to represent the human user, and contain his/her Account and Profile.
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

@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User implements Serializable {
    
    private Account account;
    private Profile profile;
    private HashMap<String, ReelDealRating> movieRatings;
    //private List<Message> myMessages;
    
    /**
     * Constructor
     */
    public User() {
        this(null, new Account(), new Profile());
    }
    
    public User(String name, String username, String password, boolean admin) {
        this(name, new Account(username, admin), new Profile());
    }
    
    public boolean isAdmin() {
        return account.isAdmin();
    }
    
    /**
     * Constructor specifying all members for a new user
     * @param name name of user
     * @param account Account for user
     * @param profile Profile for user
     */
    public User(String name, Account account, Profile profile) {
        this.account = account;
        this.profile = profile;
        this.profile.setName(name);
        this.movieRatings = new HashMap<>();
    }
    
    /**
     * Attempt to log the user into his/her account. If the loginPageURL fails,
 notify the user on the web page
     * @throws LockedAccountException
     * @throws BannedAccountException
     */
    public void loginToAccount() throws LockedAccountException,
            BannedAccountException {
        try {
            account.login();
        } catch (LockedAccountException | BannedAccountException accountException) {
            throw accountException;
        }
    }
    
    public String lock() {
        System.out.println("Locking user " + this.getUsername());
        account.lock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    public String unlock() {
        System.out.println("Unlocking user " + this.getUsername());
        account.unlock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    public String ban() {
        System.out.println("Banning user " + this.getUsername());
        account.ban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    public String unban() {
        System.out.println("Unbanning user " + this.getUsername());
        account.unban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Logout of the user's account
     * @return indexPageURL.xhtml page navigation token
     */
    public String logout() {  
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ControlHub.indexPageURL;
    }
    
    public String getAccountStatus() {
        return account.getStatus();
    }
    
    public void newMovieRating(String movieId, ReelDealRating newRating) {
        movieRatings.put(movieId, newRating);
        ControlHub.getInstance().userUpdate();
    }
    
    public boolean hasRatedMovie(String movieId) {
        return (movieRatings.get(movieId) != null);
    }
    
    public ReelDealRating getMovieReviewFor(String movieId) {
        ReelDealRating rating = movieRatings.get(movieId);
        rating.assertReels(rating.getValue());
        return rating;
    }

    /**
     * Get the name of the user
     * @return user's name
     */
    public String getName() {
        return this.profile.getName();
    }
    
    /**
     * Get the account of the user
     * @return user's account
     */
    public Account getAccount() {
        return account;
    }
    
    /**
     * Return the user's profile
     * @return user's profile
     */
    public Profile getProfile() {
        return profile;
    }
    
    /**
     * Set the name of the user
     * @param name user's name
     */
    public void setName(String name) {
        this.profile.setName(name);
    }
    
    /**
     * Set the account of the user
     * @param myAccount user's account
     */
    public void setAccount(Account myAccount) {
        this.account = myAccount;
    }
    
    /**
     * Set the user's profile
     * @param profile user's profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    /**
     * Return the user's major
     * @return major
     */
    public String getMajor() {
        return profile.getMajor();
    }
    
    /**
     * set the user's major
     * @return major
     */
    public void setMajor(String major) {
        profile.setMajor(major);
        System.out.println(major + "akjaisdj");
    }
    
    public String getUsername() {
        return account.getUsername();
    }
    
    public void setUsername(String username) {
        this.account.setUsername(username);
    }
    
    public boolean isBanned() {
        return account.isBanned();
    }
    
    public void setBanned(boolean banned) {
        account.setBanned(banned);
    }
    
    public boolean isLocked() {
        return account.isLocked();
    }
    
    public void setLocked(boolean locked) {
        account.setLocked(locked);
    }

    public HashMap<String, ReelDealRating> getMovieRatings() {
        return movieRatings;
    }

    public void setMoveRatings(HashMap<String, ReelDealRating> movieRatings) {
        this.movieRatings = movieRatings;
    }
}
