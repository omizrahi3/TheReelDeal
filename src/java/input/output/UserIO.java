/**
 * Handles persistence within the web application The Reel Deal.
 */
package input.output;

import usermanagement.User;
import gatech.cs2340.team7.ControlHub;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * IO handling for valid users who have access to the application.
 * @author ODell
 * @version 1.0
 */
public class UserIO implements Serializable {

    /**
     * Reads in a file holding login credential info and creates a usable HashMap
     * @return users A HashMap containing users
     */
    public static HashMap<String, User> readFile() {
        HashMap<String, User> users = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.SAVE_PATH + "users.bin"));
            users = (HashMap<String, User>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    /**
     * Writes a file that holds user related data
     * @param users A Map containing user names
     */
    public static void WriteToFile(Map<String, User> users) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.SAVE_PATH + "users.bin"));
            os.writeObject(users);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
