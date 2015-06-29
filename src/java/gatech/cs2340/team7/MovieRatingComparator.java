/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Jimmy
 */
/*
            public int compare(Object o1, Object o2) {
                return ((Comparable)((Map.Entry) (o1)).getValue()).compareTo(
                        ((Map.Entry) (o2)).getValue());    
            }
*/
public class MovieRatingComparator implements Comparator<Object> {
    @Override
    public int compare(Object a, Object b) {
        Movie movieA = ((Movie)((Map.Entry)a).getValue());
        Movie movieB = ((Movie)((Map.Entry)b).getValue());
        float result = movieA.getAverageRating() - movieB.getAverageRating(); 
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return 1;
        } else {
            return movieA.getTitle().compareTo(movieB.getTitle());
        }
        /*
        if (a.getAverageRating() - b.getAverageRating() < 0) {
            return 1;
        } else if (a.getAverageRating() - b.getAverageRating() > 0) {
            return -1;
        } else {
            return a.getTitle().compareTo(b.getTitle());
        }
        */
    }
}
