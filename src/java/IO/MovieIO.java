/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
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
 *
 * @author ODell
 */
public class MovieIO implements Serializable {
    
    public static HashMap<String, Movie> readFile() {
       HashMap<String, Movie> movies = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.pathToDataPersistence + "movies.bin"));
            movies = (HashMap<String, Movie>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }
    
    public static void WriteToFile(Map<String, Movie> m) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.pathToDataPersistence + "movies.bin"));
            os.writeObject(m);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
