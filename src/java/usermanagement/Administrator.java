/**
 * Handles the features of a user.
 */
package usermanagement;

/**
 * Represents a type of user that has different privileges than a regular user.
 * @author Anthony
 * @version 1.0
 */
public class Administrator extends User {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7426584196403121323L;

    /**
     * Constructs an administrator that has a name, username, and password.
     * @param name The screen name for the administrator
     * within the application
     * @param username The login name for the administrator
     * to access the application
     */
    public Administrator(final String name, final String username) {
        super(name, username, true);
    }
}
