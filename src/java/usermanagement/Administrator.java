/**
 * Handles the features of a user.
 */
package usermanagement;

/**
 * Represents a type of user that has different privileges than a regular user
 * @author Anthony
 * @version 1.0
 */
public class Administrator extends User {
    
    /**
     * Constructs an administrator that has a name, username, and password
     * @param name The screen name for the administrator 
     * within the application
     * @param username The login name for the administrator 
     * to access the application
     * @param password The administrator's password
     */
    public Administrator(String name, String username, String password) {
        super(name, username, password, true);
    }
}
