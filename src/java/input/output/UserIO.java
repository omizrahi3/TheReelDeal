/**
 * Handles persistence within the web application The Reel Deal.
 */
package input.output;

import com.google.inject.Inject;
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
public final class UserIO implements Serializable, IO {

    /**
     *
     */
    /**
     *
     */
    private static final long serialVersionUID = 480189657473802062L;

    /**
     * Reads in a file holding login credential
     * info and creates a usable HashMap.
     * @return users A HashMap containing users
     */
    public HashMap readFile() {
        HashMap<String, User> users = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.SAVE_PATH + "users.bin"));
            users = (HashMap<String, User>) is.readObject();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not read file");
        }
        return users;
    }

    /**
     * Writes a file that holds user related data.
     * @param users A Map containing user names
     */
    public void writeToFile(final HashMap data) {
        System.out.println("TESTING");
        try (ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.SAVE_PATH
                            + "users.bin"));) {
            os.writeObject(data);
            os.close();
        } catch (IOException e) {
            System.out.println("Could not save file");
        }
    }
}
