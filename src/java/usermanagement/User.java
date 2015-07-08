/**
 * Handles the features of a user.
 */
package usermanagement;

import loginregistration.BannedAccountException;
import loginregistration.LockedAccountException;
import gatech.cs2340.team7.ControlHub;
import com.rottentomatoes.ReelDealRating;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Represents the user of the application The Reel Deal.
 * Contains their Account and Profile
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User implements Serializable {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 803944453811308236L;

    /**
     * user's account.
     */
    private Account account;

    /**
     * user's profile.
     */
    private Profile profile;

    /**
     * user's movie ratings.
     */
    private HashMap<String, ReelDealRating> movieRatings;

    //Feature that could be added later
    //private List<Message> myMessages;

    /**
     * Constructs a user with no name who possesses a new account and profile.
     */
    public User() {
        this(null, new Account(), new Profile());
    }

    /**
     * Constructs a user with a specified name, username, password, and admin
     * status.
     * @param name The birth name of the user
     * @param username The screen name of the user
     * @param admin Whether the user has admin privileges
     */
    public User(final String name, final String username, final boolean admin) {
        this(name, new Account(username, admin), new Profile());
    }

    /**
     * Determines if the user has admin privileges.
     * @return isAdmin Whether the user's account has admin features
     */
    public final boolean isAdmin() {
        return account.isAdmin();
    }

    /**
     * Constructs a user with a specified name, account, and profile.
     * @param name The birth name of the user
     * @param newAccount The user's account
     * @param newProfile The user's profile
     */
    public User(final String name, final Account newAccount,
            final Profile newProfile) {
        this.account = newAccount;
        this.profile = newProfile;
        this.profile.setName(name);
        this.movieRatings = new HashMap<>();
    }

    /**
     * Attempts to log the user into their account.
     * If the LOGIN_URL fails, it notifies the user on the web page
     * @throws LockedAccountException Handles a locked out user
     * @throws BannedAccountException Handles a banned user
     */
    public final void loginToAccount() throws LockedAccountException,
            BannedAccountException {
        try {
            countNumberOfFlaggedComments();
            account.login();
        } catch (LockedAccountException
                | BannedAccountException accountException) {
            throw accountException;
        }
    }

    /**
     * Count the number of the user's comments that have been flagged by
     * other users.
     */
    public final void countNumberOfFlaggedComments() {
        int numberFlagged = 0;
        for (ReelDealRating rating : movieRatings.values()) {
            if (rating.isFlagged()) {
                ++numberFlagged;
            } else {
                System.out.println("Rating " + rating.getComment()
                    + " is not flagged.");
            }
        }
        System.out.println("Account has " + numberFlagged
            + " flagged comments");
        account.setNumCommentFlags(numberFlagged);
    }

    /**
     * Locks the account and prints a message recording that action.
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public final String lock() {
        System.out.println("Locking user " + this.getUsername());
        account.lock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Unlocks the account and prints a message recording that action.
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public final String unlock() {
        System.out.println("Unlocking user " + this.getUsername());
        account.unlock();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Bans the user from account access and prints a message on that act.
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public final String ban() {
        System.out.println("Banning user " + this.getUsername());
        account.ban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Unbans the user from account access and prints a message on that act.
     * @return activeUserDashboardPageURL The home screen of the user
     */
    public final String unban() {
        System.out.println("Unbanning user " + this.getUsername());
        account.unban();
        ControlHub.getInstance().userUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Logs the user out of the application.
     * @return INDEX_URL The xhtml page navigation token
     */
    public final String logout() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return ControlHub.INDEX_URL;
    }

    /**
     * Determines the status of the account in terms of ban and lock.
     * @return account.getStatus The status of the user's account
     */
    public final String getAccountStatus() {
        return account.getStatus();
    }

    /**
     * Creates a rating for a movie selected by the user.
     * @param movieId The ID of the film
     * @param newRating The user's rating based on The Reel Deal rating system
     */
    public final void newMovieRating(final String movieId,
            final ReelDealRating newRating) {
        movieRatings.put(movieId, newRating);
        ControlHub.getInstance().userUpdate();
    }

    /**
     * Determines whether the user has rated a particular movie.
     * @param movieId The ID of the film
     * @return Whether a rating was given
     */
    public final boolean hasRatedMovie(final String movieId) {
        return movieRatings.containsKey(movieId);
    }

    /**
     * Getter method for a rated movie.
     * @param movieId The ID of the film
     * @return rating The Reel Deal rating the user gave
     */
    public final ReelDealRating getMovieReviewFor(final String movieId) {
        ReelDealRating rating = movieRatings.get(movieId);
        rating.assertReels(rating.getValue());
        return rating;
    }

    /**
     * Getter method for the birth name of the user.
     * @return profile.getName The user's birth name
     */
    public final String getName() {
        return this.profile.getName();
    }

    /**
     * Getter method for the account of the user.
     * @return account The user's account
     */
    public final Account getAccount() {
        return account;
    }

    /**
     * Getter method for the profile of the user.
     * @return profile The user's profile
     */
    public final Profile getProfile() {
        return profile;
    }

    /**
     * Setter for the name of the user.
     * @param name The user's name
     */
    public final void setName(final String name) {
        this.profile.setName(name);
    }

    /**
     * Setter for the account of the user.
     * @param myAccount The user's account
     */
    public final void setAccount(final Account myAccount) {
        this.account = myAccount;
    }

    /**
     * Setter for the user's profile.
     * @param newProfile The user's profile
     */
    public final void setProfile(final Profile newProfile) {
        this.profile = newProfile;
    }

    /**
     * Getter for the user's major.
     * @return The user's major
     */
    public final String getMajor() {
        return profile.getMajor();
    }

    /**
     * Setter for the user's major.
     * major + akjaisdj A string holding the major plus a set ending
     * @param major The user's major
     */
    public final void setMajor(final String major) {
        profile.setMajor(major);
        System.out.println(major + "akjaisdj");
    }

    /**
     * Getter for the username.
     * @return account.getUsername The user's profile name
     */
    public final String getUsername() {
        return account.getUsername();
    }

    /**
     * Setter for the username.
     * @param username The user's profile name
     */
    public final void setUsername(final String username) {
        this.account.setUsername(username);
    }

    /**
     * Determines the ban status of the user's account.
     * @return Whether the account is banned
     */
    public final boolean isBanned() {
        return account.isBanned();
    }

    /**
     * Setter method for the ban status of the user's account.
     * @param banned The ban status of the account to change to
     */
    public final void setBanned(final boolean banned) {
        account.setBanned(banned);
    }

    /**
     * Determines the lock status of the user's account.
     * @return Whether the user is locked out of their account
     */
    public final boolean isLocked() {
        return account.isLocked();
    }

    /**
     * Setter method for the account lock status.
     * @param locked The lock status of the account to change to
     */
    public final void setLocked(final boolean locked) {
        account.setLocked(locked);
    }

    /**
     * Getter method for the movie rating assigned by the user.
     * @return movieRatings The given movie rating attached to a movie ID
     */
    public final HashMap<String, ReelDealRating> getMovieRatings() {
        return movieRatings;
    }

    /**
     * Setter method for the movie rating assigned by the user.
     * @param newMovieRatings The given movie rating attached to a movie ID
     */
    public final void setMovieRatings(
            final HashMap<String, ReelDealRating> newMovieRatings) {
        this.movieRatings = newMovieRatings;
    }


    /**
     * Update an existing Reel Deal rating with the given rating.
     * @param movieId Identifier used to store the rating
     * @param newRating New rating to use
     */
    public final void updateMovieRating(final String movieId,
            final ReelDealRating newRating) {
        if (movieRatings.containsKey(movieId)) {
            movieRatings.replace(movieId, newRating);
        }
     }
}
