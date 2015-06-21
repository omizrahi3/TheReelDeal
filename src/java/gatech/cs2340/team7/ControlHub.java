/*
 * Control hub to coordinate between the UserManager and RottenTomatoesDataManager
 */
package gatech.cs2340.team7;

import UserManagement.UserManager;

/**
 *
 * @author Anthony
 */
public class ControlHub {
    private UserManager userManager;
    private RottenTomatoesDataManager dataManager; // TODO should be a more generic DataManager type
    
    /**
     * Empty constructor
     */
    public ControlHub() {
        
    }
    
    
}
