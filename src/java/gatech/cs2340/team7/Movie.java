/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;
import java.util.ArrayList;
/**
 *
 * @author Jimmy
 */
public class Movie {
    
    private final String title;
    private final String genre;
    private ArrayList<Comment> comments;
    private ArrayList<Rating> ratings;
    
    /**
     * constructor for a movie object
     * 
     * @param title title of the movie
     * @param genre genre of the movie
     */
    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
        comments = new ArrayList<Comment>();
        ratings = new ArrayList<Rating>();
    }
    
    /**
     * getter method for movie title
     * 
     * @return movie title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * getter method for movie genre
     * 
     * @return movie genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * getter method for movie comments
     * 
     * @return movie comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }
    
    /**
     * getter method for movie ratings
     * 
     * @return movie ratings
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }
    
    /**
     * method for adding a rating to a movie
     * 
     * @param rating 
     */
    public void rate(Rating rating) {
        ratings.add(rating);
    }
    
    /**
     * method for adding a comment to a movie
     * 
     * @param comment 
     */
    public void comment(Comment comment) {
        comments.add(comment);
    }
    
    /**
     * method calculating the average rating of the movie over all Users
     * returns 0 if no ratings
     * 
     * @return average rating
     */
    public double getAverageRating() {
        double sum = 0;
        for (Rating r: ratings) {
            sum += r.getValue();
        }
        
         if (ratings.size() == 0) {
            return 0;
        } else {
            return sum / ratings.size();
        }
    }
    
    /**
     * method calculating the average rating of a movie by users of a specific major
     * Returns 0 if no ratings
     * 
     * @param major major to filter raters by
     * @return major specific raters.
     */
    public double getMajorSpecificRating(String major) {
        double sum = 0;
        int numOfUsers = 0;
        for (Rating r: ratings) {
            
            if (r.getAuthor().getProfile().getMajor() == major) {
                sum += r.getValue();
                numOfUsers++;
            }
        }
        
        if (numOfUsers == 0) {
            return 0;
        } else {
            return sum / numOfUsers;
        }
    }
}
