/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;

import java.util.Comparator;

/**
 *
 * @author Jimmy
 */
public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie a, Movie b) {
        if (a.getAverageRating() - b.getAverageRating() < 0) {
            return 1;
        } else if (a.getAverageRating() - b.getAverageRating() > 0) {
            return -1;
        } else {
            return a.getTitle().compareTo(b.getTitle());
        }
    }
}
