/**
 * Handles persistence within the web application The Reel Deal.
 */
package input.output;

import com.google.inject.Inject;
import com.rottentomatoes.Movie;
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
 * IO handling for various collections of movie info used by the app.
 * @author ODell
 * @version 1.0
 */
public final class MovieIO implements Serializable, IO {

    /**
     *
     */
    /**
     *
     */
    private static final long serialVersionUID = 4801633306273802062L;
    /**
     * Reads in a file holding movie related data and creates a usable HashMap.
     * @return movies A HashMap containing movies and their information
     */
    public HashMap readFile() {
       HashMap<String, Movie> movies = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.SAVE_PATH + "movies.bin"));
            movies = (HashMap<String, Movie>) is.readObject();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not read file");
        }
        return movies;
    }

    /**
     * Writes a file that holds movie related data.
     * @param m A Map connecting movie info to its movie
     */
    public void writeToFile(final HashMap data) {
        try (ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.SAVE_PATH
                            + "movies.bin"));) {
            os.writeObject(data);
        } catch (IOException e) {
            System.out.println("Could not save file");
        }
    }
}
