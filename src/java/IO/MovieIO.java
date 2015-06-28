/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import com.rottentomatoes.Movie;
import gatech.cs2340.team7.MovieManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ODell
 */
public class MovieIO implements Serializable {
    
    public static List<Movie> readFile() {
       List<Movie> movies = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("/Users/ODell/movies.bin"));
            movies = (List<Movie>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }
    
    public static void WriteToFile(List<Movie> m) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("/Users/ODell/movies.bin"));
            os.writeObject(m);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
