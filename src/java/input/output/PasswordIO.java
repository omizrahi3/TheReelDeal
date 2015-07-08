/**
 * Handles persistence within the web application The Reel Deal.
 */
package input.output;

import gatech.cs2340.team7.ControlHub;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * IO handling for passwords needed to get into the app.
 * @author ODell
 * @version 1.0
 */
public final class PasswordIO implements Serializable {

    /**
     *
     */
    private PasswordIO() {

    }
    /**
     *
     */
    private static final long serialVersionUID = 480163338657802062L;
    /**
     * Reads in a file holding login credential info and
     * creates a usable HashMap.
     * @return passwords A HashMap containing passwords
     */
    public static HashMap<String, String> readFile() {
        HashMap<String, String> passwords = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.SAVE_PATH
                            + "passwords.bin"));
            passwords = (HashMap<String, String>) is.readObject();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File did not open");
        }
        return passwords;
    }

    /**
     * Writes a file that holds password related data.
     * @param passwords A Map containing passwords
     */
    public static void writeToFile(final Map<String, String> passwords) {
        try (ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.SAVE_PATH
                            + "passwords.bin"));) {
            os.writeObject(passwords);
            os.close();
        } catch (IOException e) {
            System.out.println("Could not save file");
        }
    }
}
