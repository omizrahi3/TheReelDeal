/*
 * The gatech.cs2340.team7 package contains various overarching manager
 * handles for directing the control and flow of the application
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;

import java.util.Comparator;
import java.util.Map;

/**
 * Comparator that defines comparison of Movie objects by their Reel Deal
 * rating numerical score
 * @author Jimmy
 */
public class MovieRatingComparator implements Comparator<Object> {
    @Override
    public int compare(Object a, Object b) {
        Movie movieA = ((Movie)((Map.Entry)a).getValue());
        Movie movieB = ((Movie)((Map.Entry)b).getValue());
        float result = Float.parseFloat(movieA.getAverageRating()) - 
                Float.parseFloat(movieB.getAverageRating()); 
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return 1;
        } else {
            return movieA.getTitle().compareTo(movieB.getTitle());
        }
    }
}
