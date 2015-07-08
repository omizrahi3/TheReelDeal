/**
 * Handles the features of a user.
 */
package usermanagement;

import java.io.Serializable;
import loginregistration.BannedAccountException;
import loginregistration.LockedAccountException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Represents a user's account-specific data.
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "account", eager = true)
@SessionScoped
public class Account implements Serializable {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 4063661824855772967L;

    /**
     * max number of flagged comments.
     */
    public static final int MAX_NUMBER_FLAGGED_COMMENTS = 2;

    /**
     * username associated with the account.
     */
    private String username;

    /**
     * boolean describing logged in status of account.
     */
    private boolean loggedIn;

    /**
     * boolean describing locked status of account.
     */
    private boolean locked;

    /**
     * boolean describing banned status of account.
     */
    private boolean banned;

    /**
     * boolean describing admin status of account.
     */
    private boolean admin;

    /**
     * number of flagged comments associated with the account.
     */
    private int numberFlaggedComments;

    /**
     * Constructs an empty account.
     */
    public Account() {
        this(null, false);
    }

    /**
     * Constructs an account with all relevant members belonging to an account.
     * @param newUsername Username for the new account
     * @param newAdmin Whether the account belongs to an admin
     */
    public Account(final String newUsername, final boolean newAdmin) {
        this.username = newUsername;
        this.loggedIn = false;
        this.locked = false;
        this.banned = false;
        this.admin  = newAdmin;
        this.numberFlaggedComments = 0;
    }

    /**
     * Blocks the user from the account if necessary.
     * Else validates the login attempt.
     * @throws LockedAccountException if the account is locked.
     * @throws BannedAccountException if the account is locked.
     */
    public final void login() throws LockedAccountException,
            BannedAccountException {
        assertAccountStatus();
        if (banned) {
            System.out.print("This account is banned!");
            throw new BannedAccountException(
                    "Account is banned by an administrator!");
        } else if (locked) {
            System.out.print("This account is locked!");
            throw new LockedAccountException(
                    "Account is locked by an administrator!");
        }
        loggedIn = true;
    }

    /**
     * Assert that the account is locked if the number of flagged comments
     * exceeds the maximum allowed. Ideally, this method will be expanded
     * in future implementations, to account for different factors that could
     * affect the accounts locked/unlocked status
     */
    public final void assertAccountStatus() {
        System.out.println("Account has " + this.numberFlaggedComments
            + " flagged comments");
        if (numberFlaggedComments > MAX_NUMBER_FLAGGED_COMMENTS) {
            locked = true;
        }
    }

    /**
     * Checks and returns the status of the account.
     * @return new String A string stating the status
     */
    public final String getStatus() {
        if (admin) {
            return "Administrator";
        } else if (banned) {
            return "Banned";
        } else if (locked) {
            return "Locked";
        } else {
            return "Active";
        }
    }

    /**
     * Alters the status of the account to "locked".
     */
    public final void lock() {
        locked = true;
        banned = false;
    }

    /**
     * Alters the status of the account to "unlocked".
     */
    public final void unlock() {
        locked = false;
        banned = false;
    }

    /**
     * Alters the status of the account to "banned".
     */
    public final void ban() {
        banned = true;
        locked = true;
    }

    /**
     * Alters the status of the account to "unbanned".
     */
    public final void unban() {
        banned = false;
    }

    /**
     * Getter method for the username of the account.
     * @return username The user who possesses the account
     */
    public final String getUsername() {
        return this.username;
    }

    /**
     * Getter method for login status.
     * @return loggedIn Whether the account is logged in
     */
    public final boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Getter method for account locking status.
     * @return locked Whether the account is locked
     */
    public final boolean isLocked() {
        return locked;
    }

    /**
     * Setter method for the username associated with the account.
     * @param newUsername New username for the account
     */
    public final void setUsername(final String newUsername) {
        this.username = newUsername;
    }

    /**
     * Setter method for the login state of the account.
     * @param newLoggedIn State of login to change to
     */
    public final void setLoggedIn(final boolean newLoggedIn) {
        this.loggedIn = newLoggedIn;
    }

    /**
     * Setter method for the locked state of the account.
     * @param newLocked State of account lock to change to
     */
    public final void setLocked(final boolean newLocked) {
        this.locked = newLocked;
    }

    /**
     * Determines if the account user is an admin.
     * @return admin Whether the account belongs to an admin
     */
    public final boolean isAdmin() {
        return admin;
    }

    /**
     * Setter method for the admin state of the account.
     * @param newAdmin State of user privileges to change to
     */
    public final void setAdmin(final boolean newAdmin) {
        this.admin = newAdmin;
    }

    /**
     * Getter method for user banishment status.
     * @return banned Whether the user holding the account is banned
     */
    public final boolean isBanned() {
        return banned;
    }

    /**
     * Setter method for user banishment status.
     * @param newBanned State of account ban to change to
     */
    public final void setBanned(final boolean newBanned) {
        this.banned = newBanned;
    }

    /**
     * Getter for the number of flagged comments the account has received.
     * @return Number of flagged comments associated with the account
     */
    public final int getNumberFlaggedComments() {
        return numberFlaggedComments;
    }

    /**
     * Setter for the number of flagged comments the account has received.
     * @param newNumberFlaggedComments Number of flagged comments
     *        associated with the account
     */
    public final void setNumberFlaggedComments(
            final int newNumberFlaggedComments) {
        this.numberFlaggedComments = newNumberFlaggedComments;
    }



}