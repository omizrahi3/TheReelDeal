/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;
import com.rottentomatoes.ReelDealRating;
import com.rottentomatoes.Ratings;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Jimmy
 */
public class MovieManagerTest {
    
    ArrayList listOfMovies = new ArrayList();
    
    public MovieManagerTest() {
    }
   
    @Before
    public void setUp() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        Movie movie4 = new Movie();
        Movie movie5 = new Movie();
        Movie movie6 = new Movie();
        Movie movie7 = new Movie();
        Movie movie8 = new Movie();
        Movie movie9 = new Movie();
        Movie movie10 = new Movie();
        
        movie1.setTitle("A Great Movie");
        movie2.setTitle("B Awful Movie");
        movie3.setTitle("C Meh Movie");
        movie4.setTitle("D Meh Movie");
        movie5.setTitle("E Good Movie");
        movie6.setTitle("F Meh Movie");
        movie7.setTitle("G Okay Movie");
        movie8.setTitle("H Great Movie");
        movie9.setTitle("I Awful Movie");
        movie10.setTitle("J Awful Movie");
        
        ReelDealRating greatRating = new ReelDealRating();
        greatRating.setValue(4);
        ReelDealRating goodRating = new ReelDealRating();
        goodRating.setValue(3);
        ReelDealRating okayRating = new ReelDealRating();
        okayRating.setValue(2);
        ReelDealRating mehRating = new ReelDealRating();
        mehRating.setValue(1);
        ReelDealRating awfulRating = new ReelDealRating();
        awfulRating.setValue(0);
        
        movie1.addReelDealRating(greatRating);
        movie1.addReelDealRating(greatRating);
        movie1.addReelDealRating(goodRating);
        movie1.addReelDealRating(greatRating);
        movie1.addReelDealRating(goodRating);
        movie1.addReelDealRating(goodRating);
        movie1.addReelDealRating(okayRating);
        
        movie2.addReelDealRating(awfulRating);
        movie2.addReelDealRating(okayRating);
        movie2.addReelDealRating(mehRating);
        movie2.addReelDealRating(awfulRating);
        movie2.addReelDealRating(awfulRating);
        
        movie3.addReelDealRating(awfulRating);
        movie3.addReelDealRating(mehRating);
        movie3.addReelDealRating(awfulRating);
        movie3.addReelDealRating(goodRating);
        movie3.addReelDealRating(okayRating);
        movie3.addReelDealRating(mehRating);
        movie3.addReelDealRating(mehRating);
        
        movie4.addReelDealRating(goodRating);
        movie4.addReelDealRating(greatRating);
        movie4.addReelDealRating(greatRating);
        movie4.addReelDealRating(okayRating);
        
        movie5.addReelDealRating(goodRating);
        movie5.addReelDealRating(greatRating);
        movie5.addReelDealRating(greatRating);
        movie5.addReelDealRating(okayRating);
        
        movie6.addReelDealRating(mehRating);
        movie6.addReelDealRating(awfulRating);
        movie6.addReelDealRating(okayRating);
        movie6.addReelDealRating(okayRating);
        movie6.addReelDealRating(mehRating);
        
        movie7.addReelDealRating(okayRating);
        
        movie9.addReelDealRating(awfulRating);
        
        movie10.addReelDealRating(awfulRating);
        
        listOfMovies.add(movie1);
        listOfMovies.add(movie2);
        listOfMovies.add(movie3);
        listOfMovies.add(movie4);
        listOfMovies.add(movie5);
        listOfMovies.add(movie6);
        listOfMovies.add(movie7);
        listOfMovies.add(movie8);
        listOfMovies.add(movie9);
        listOfMovies.add(movie10);
        
        
    }

    /**
     * Test of sortMoviesByRating method, of class MovieManager.
     */
    @Test
    public void testSortMoviesByRating() {
        System.out.println("sortMoviesByRating");
        List<Movie> movies = listOfMovies;
        MovieManager instance = new MovieManager();
        List<Movie> result = instance.sortMoviesByRating(movies);

        for (Movie m : result) {
            System.out.println(m.getTitle() + " " + m.getAverageRating());
        }
        
    }

    /**
     * Test of getReccomendation method, of class MovieManager.
     */
    @Test
    public void testGetReccomendation() {
        System.out.println("getReccomendation");
        String major = "";
        MovieManager instance = new MovieManager();
        instance.setNewDVDReleases(listOfMovies);
        
        Movie result = instance.getReccomendation();
        System.out.println(result.getTitle() + " " + result.getAverageRating());
    }

}
