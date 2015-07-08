/*
 * Contains various overarching manager
 * handles for directing the control and flow of the application.
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;

import java.util.Comparator;
import java.util.Map;

/**
 * Comparator that defines comparison of Movie objects by their Reel Deal rating
 * numerical score.
 *
 * @author Jimmy
 */
public class MovieRatingComparator implements Comparator<Object> {

    @Override
    public final int compare(final Object left, final Object right) {
        final Movie movieA = ((Movie) ((Map.Entry) left).getValue());
        final Movie movieB = ((Movie) ((Map.Entry) right).getValue());
        final float comparison = Float.parseFloat(movieA.getAverageRating())
                - Float.parseFloat(movieB.getAverageRating());
        int result;
        if (comparison < 0) {
            result = 1;
        } else if (comparison > 0) {
            result = 1;
        } else {
            result = movieA.getTitle().compareTo(movieB.getTitle());
        }
        return result;
    }
}
