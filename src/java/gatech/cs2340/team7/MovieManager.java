/*
MovieManager class to handle all movie data processing and maintenance
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;
import com.rottentomatoes.ReelDealRating;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import UserManagement.User;
import UserManagement.Profile;
import UserManagement.Account;
import java.util.HashSet;


/**
 *
 * @author Anthony
 */
@ManagedBean(name = "movieManager", eager = true)
@SessionScoped
public class MovieManager {

    private List<Movie> searchResultMovies;
    private List<Movie> newDVDReleases;
    private List<Movie> newTheaterReleases;
    private Movie selectedMovie;
    private ReelDealRating newRating;
    private List<Movie> ratedMovies;
    
    /**
     * Empty Constructor
     */
    public MovieManager() {
        this(new ArrayList<>(), new ArrayList<>(), null, null);  
    }
    
    /**
     * Data members with DVD and in-theater releases specified
     * @param newDVDReleases
     * @param newTheaterReleases 
     */
    public MovieManager(List<Movie> newDVDReleases, List<Movie> newTheaterReleases) {
        this(new ArrayList<>(), new ArrayList<>(), null, null);
    }
    
    /**
     * Constructor with all data members specified
     * @param newTheaterReleases
     * @param newDVDReleases
     * @param searchResultMovies
     * @param selectedMovie
     */
    public MovieManager(List<Movie> newDVDReleases,
            List<Movie> newTheaterReleases, List<Movie> searchResultMovies,
            Movie selectedMovie) {
        this.newDVDReleases = newDVDReleases;
        this.newTheaterReleases = newTheaterReleases;
        this.searchResultMovies = searchResultMovies;
        this.selectedMovie = selectedMovie;
        this.newRating = new ReelDealRating();
        ratedMovies = new ArrayList();
    }
    
    private void buildRatings() {
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
        
        ReelDealRating[] ratingTypes = new ReelDealRating[5];
        ratingTypes[0] = awfulRating;
        ratingTypes[1] = mehRating;
        ratingTypes[2] = okayRating;
        ratingTypes[3] = goodRating;
        ratingTypes[4] = greatRating;
        
        ReelDealRating csRating = new ReelDealRating();
        csRating.setValue(3);
        Profile csProfile = new Profile("csGuy", "Computer Science");
        Account csAccount = new Account();
        User csMajor = new User("", csAccount, csProfile);
        csRating.setAuthor(csMajor);
        
        for (int i = 0; i < newDVDReleases.size(); i++) {
            ratedMovies.add(newDVDReleases.get(i));
            ratedMovies.get(i).addReelDealRating(ratingTypes[i % 5]);
        }
        
        ratedMovies.get(2).addReelDealRating(csRating);
    }
    
    /**
     * Assert that all movie data is correctly set for user readability
     */
    public void assertDefaultValuesOfUndefData() {
        this.newDVDReleases.stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        this.newTheaterReleases.stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        if (searchResultMovies != null) {
            this.searchResultMovies.stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        }
        
    }
    
    public void movieSelected(String name) {
        // TODO fix this horrendous algorithm (make lists into maps keyed by movie name)
        for (Movie m : newDVDReleases) {
            if (m.getTitle().equals(name)) {
                System.out.println("Selected movie: " + m.getTitle());
                selectedMovie = m;
                return;
            }
        }
        for (Movie m : newTheaterReleases) {
            if (m == null) {System.out.println("null movie");}
            else if (m.getTitle().equals(name)) {
                System.out.println("Selected movie: " + m.getTitle());
                selectedMovie = m;
                return;
            }
        }
        if (searchResultMovies != null) {
            for (Movie m : searchResultMovies) {
                if (m.getTitle().equals(name)) {
                    System.out.println("Selected movie: " + m.getTitle());
                    selectedMovie = m;
                    return;
                }
            }
        }
        // TODO handle case of not finding movie
    }
    
    /**
     * Add the new Reel Deal rating to the selected movie
     * @return 
     */
    public String addRating() {
        newRating.setAuthor(ControlHub.getInstance().getActiveUser());
        System.out.println("Added review from " + newRating.getAuthor().getName() + " with " + newRating.getValue() +
                " reels and feedback: " + newRating.getComment());
        newRating.clearData();
        
        if (selectedMovie == null) {
            throw new java.util.NoSuchElementException("No Selected Movie!");
        }
        selectedMovie.addReelDealRating(newRating);
        return ControlHub.postReviewPageURL;
    }
    
    /**
     * Get movies returned by REST query
     * @return 
     */
    public List<Movie> getSearchResultMovies() {
        return searchResultMovies;
    }

    /**
     * Set movies returned by REST query
     * @param searchResultMovies 
     */
    public void setSearchResultMovies(List<Movie> searchResultMovies) {
        this.searchResultMovies = searchResultMovies;
        System.out.println("Search Results");
        searchResultMovies.stream().forEach((m) -> {m.assertDefaultValuesOfUndefData();});
    }

    /**
     * Get new DVD releases
     * @return 
     */
    public List<Movie> getNewDVDReleases() {
        return newDVDReleases;
    }

    /**
     * Set new DVD releases
     * @param newDVDReleases 
     */
    public void setNewDVDReleases(List<Movie> newDVDReleases) {
        this.newDVDReleases = newDVDReleases;
    }

    /**
     * Get new theater releases
     * @return 
     */
    public List<Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }

    /**
     * Set new in-theater releases
     * @param newTheaterReleases 
     */
    public void setNewTheaterReleases(List<Movie> newTheaterReleases) {
        this.newTheaterReleases = newTheaterReleases;
    }

    /**
     * Return selected movie for detailed view
     * @return selected movie handle
     */
    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    /**
     * Set selected movie for detailed view
     * @param selectedMovie 
     */
    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    /**
     * Get the new Reel Deal rating
     * @return new Reel Deal rating
     */
    public ReelDealRating getNewRating() {
        return newRating;
    }

    /**
     * Set the new Reel Deal rating
     * @param newRating new Reel Deal rating
     */
    public void setNewRating(ReelDealRating newRating) {
        this.newRating = newRating;
    }
    
    
    public List<Movie> sortMoviesByRating(List<Movie> movies) {
        List<Movie> movieList = new ArrayList(movies);
        Collections.sort(movieList, new MovieRatingComparator());
        return movieList;
    }
    
    public Movie getRecommendation() {
        List<Movie> sortedMovieList = sortMoviesByRating(newDVDReleases); //TODO: change to all rated movies instead of DVD releases
        return sortedMovieList.get(0);
    }
    
    public Movie getRecommendation(String major) {
        System.out.println(major);
       float max = 0;
       Movie recommendedMovie = new Movie();   //TODO: This is an empty movie. If no ratings, this is returned. Handle this better
        for (Movie m : newDVDReleases) { //TODO: change to all rated movies instead of DVD releases
            if (m.getMajorSpecificRating(major) > max) {
                max = m.getMajorSpecificRating(major);
                recommendedMovie = m;
            }
        }
        return recommendedMovie;
    }
    
    public String viewRecommendation() {
        buildRatings();
        selectedMovie = getRecommendation();
        return "movieDetailedView?faces-redirect=true";
    }
    
    public String viewRecommendation(String major) {
        buildRatings();
        selectedMovie = getRecommendation(major);
        return "movieDetailedView?faces-redirect=true";
    }
}
