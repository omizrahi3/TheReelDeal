/**
 * The UserManagement package handles the features of a user
 */
package UserManagement;

/**
 * Represents a type of user that has different privileges than a regular user
 * @author Anthony
 * @version 1.0
 */
public class Administrator extends User {
    
    /**
     * Constructs an admin that has a name, username, and password
     * @param name The screen name for the admin within the app
     * @param username The login name for the admin to access the app
     * @param password The admin's password
     */
    public Administrator(String name, String username, String password) {
        super(name, username, password, true);
    }
}
