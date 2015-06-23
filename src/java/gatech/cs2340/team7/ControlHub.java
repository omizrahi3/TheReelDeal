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
    
    
    
    
}
