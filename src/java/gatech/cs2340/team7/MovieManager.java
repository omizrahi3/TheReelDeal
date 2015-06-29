/*
MovieManager class to handle all movie data processing and maintenance
 */
package gatech.cs2340.team7;

import IO.MovieIO;
import com.rottentomatoes.Movie;
import com.rottentomatoes.ReelDealRating;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import UserManagement.User;
import UserManagement.Profile;
import UserManagement.Account;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author Anthony
 */
@ManagedBean(name = "movieManager", eager = true)
@SessionScoped
public class MovieManager {

    private HashMap<String, Movie> searchResultMovies;
    private HashMap<String, Movie> newDVDReleases;
    private HashMap<String, Movie> newTheaterReleases;
    private Movie selectedMovie;
    private ReelDealRating activeUserRating;
    private HashMap<String, Movie> ratedMovies;
    
    // for display
    private List<Movie> searchResultMovieList;
    private List<Movie> newDVDReleaseList;
    private List<Movie> newTheaterReleaseList;
    
    /**
     * Empty Constructor
     */
    public MovieManager() {
        this(new HashMap<>(), new HashMap<>(), null, null);  
    }
    
    /**
     * Data members with DVD and in-theater releases specified
     * @param newDVDReleases
     * @param newTheaterReleases 
     */
    public MovieManager(List<Movie> newDVDReleases, List<Movie> newTheaterReleases) {
        this(new HashMap<>(), new HashMap<>(), null, null);
    }
    
    /**
     * Constructor with all data members specified
     * @param newTheaterReleases
     * @param newDVDReleases
     * @param searchResultMovies
     * @param selectedMovie
     */
    public MovieManager(HashMap<String, Movie> newDVDReleases,
            HashMap<String, Movie> newTheaterReleases,
            HashMap<String, Movie> searchResultMovies,
            Movie selectedMovie) {
        this.newDVDReleases = newDVDReleases;
        this.newTheaterReleases = newTheaterReleases;
        this.searchResultMovies = searchResultMovies;
        this.selectedMovie = selectedMovie;
        this.activeUserRating = new ReelDealRating();
        this.newDVDReleaseList = new ArrayList<>();
        this.newTheaterReleaseList = new ArrayList<>();
        this.searchResultMovieList = new ArrayList<>();
        //ratedMovies = new HashMap<>();
        ratedMovies = MovieIO.readFile();
    }
    
    private void buildRatings() {
        // Create dummy author
        Profile csProfile = new Profile("csGuy", "Computer Science");
        Account csAccount = new Account();
        User csMajor = new User("", csAccount, csProfile);
        
        // Use random number generator to generate random review values
        Random rand = new Random(System.currentTimeMillis());
        
        // Give each movie in the new DVD's list 10 random reviews
        for (HashMap.Entry entry : newDVDReleases.entrySet()) {
            Movie curMovie = (Movie) entry.getValue();
            for (int i = 0; i < 10; ++i) {
                curMovie.addReelDealRating(new ReelDealRating(csMajor,
                    rand.nextInt(3) + 1, // random number 1-4 inclusive
                    "")); // blank comment)
            }
            ratedMovies.put((String) entry.getKey(), curMovie);
        }
    }
    
    /**
     * Assert that all movie data is correctly set for user readability
     */
    public void assertDefaultValuesOfUndefData() {
        this.newDVDReleases.values().stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        this.newTheaterReleases.values().stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        if (searchResultMovies != null) {
            this.searchResultMovies.values().stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
        }
        
    }
    
    public void movieSelected(String id) {
        Movie tempMovie;
        if ((tempMovie = newDVDReleases.get(id)) != null) {
            System.out.println("Selected movie: " + tempMovie.getTitle());
            selectedMovie = tempMovie;            
        } else if ((tempMovie = newTheaterReleases.get(id)) != null) {
            System.out.println("Selected movie: " + tempMovie.getTitle());
            selectedMovie = tempMovie;   
        } else if (searchResultMovies != null &&
                (tempMovie = searchResultMovies.get(id)) != null) {
            System.out.println("Selected movie: " + tempMovie.getTitle());
            selectedMovie = tempMovie;   
        } else {
            throw new java.util.NoSuchElementException(
                    "Selected Movie with id " + id + " not found!");
        }
        // Recognize if an existing rated movie is selected
        if ((tempMovie = ratedMovies.get(id)) != null) {
            selectedMovie = tempMovie;
            System.out.println(selectedMovie.getTitle() + " has been selected" +
                " and is recognized as already in ratedMovies.");
            User author = ControlHub.getInstance().getActiveUser();
            
            // If the active user has already made a review for this movie
            //   display the existing review, and allow for editing
            if (author.hasRatedMovie(selectedMovie.getId())) {
                System.out.println("Showing existing author review");
                activeUserRating = author.getMovieReviewFor(selectedMovie.getId());
            }
            //selectedMovie.setReelDealRatings(ratedMovies.get(id).getReelDealRatings());
        }
    }
    
    /**
     * Add the new Reel Deal rating to the selected movie
     * @return 
     */
    public String addRating() {
        if (selectedMovie == null) {
            throw new java.util.NoSuchElementException("No Selected Movie!");
        }
        
        // Create a ReelDealRating for the selected movie
        User author = ControlHub.getInstance().getActiveUser();
        ReelDealRating ratingToBeSet = new ReelDealRating(activeUserRating);
        ratingToBeSet.setAuthor(author);
        
        System.out.println("Reels of rating to be saved");
        for (String s : ratingToBeSet.getReels()) {
            System.out.println(s);
        }

        // If this is the movie's first ReelDeal rating, add the movie
        //   to the collection of rated movies
        // Else, add the rating to the existing rated movie
        Movie existingMovie = ratedMovies.get(selectedMovie.getId());
        if (existingMovie == null) {
            // Movie's first review, add it to the rated movies collection
            ratedMovies.put(selectedMovie.getId(), selectedMovie);
        } else {
            existingMovie.addReelDealRating(ratingToBeSet);
        }
        
        // Add or update the user's record of the rating
        author.newMovieRating(selectedMovie.getId(), ratingToBeSet);
        
        
        // Save the new state of the rated movie collection
        ControlHub.getInstance().saveState();
        activeUserRating.clearData();
        return ControlHub.postReviewPageURL;
    }
    
    public void saveState() {
        System.out.println("Saving state of movies");
        MovieIO.WriteToFile(ratedMovies);
    }
    
    /**
     * Get movies returned by REST query
     * @return 
     */
    public HashMap<String, Movie> getSearchResultMovies() {
        return searchResultMovies;
    }
    
    /**
     * Get movies returned by REST query
     * @return 
     */
    public List<Movie> getSearchResultMoviesList() {
        return new ArrayList<>(searchResultMovies.values());
    }

    /**
     * Set movies returned by REST query
     * @param searchResultMovies 
     */
    public void setSearchResultMovies(HashMap<String, Movie> searchResultMovies) {
        this.searchResultMovieList = (List<Movie>) searchResultMovies.values();
        this.searchResultMovies = searchResultMovies;
        System.out.println("Search Results");
        searchResultMovies.values().stream().forEach((m) -> {m.assertDefaultValuesOfUndefData();});
    }
    
    /**
     * Set movies returned by REST query
     * @param searchResultMovies 
     */
    public void setSearchResultMovies(List<Movie> searchResultMovies) {
        this.searchResultMovieList = searchResultMovies;
        this.searchResultMovies = new HashMap<>();
        searchResultMovies.stream().forEach((movie) -> {
            this.searchResultMovies.put(movie.getId(), movie);
        });
        this.searchResultMovies.values().stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
    }

    /**
     * Get new DVD releases
     * @return 
     */
    public HashMap<String, Movie> getNewDVDReleases() {
        return newDVDReleases;
    }
    
    /**
     * Get new DVD releases
     * @return 
     */
    public List<Movie> getNewDVDReleasesList() {
        return new ArrayList<>(newDVDReleases.values());
    }

    /**
     * Set new DVD releases
     * @param newDVDReleases 
     */
    public void setNewDVDReleases(HashMap<String, Movie> newDVDReleases) {
        this.newDVDReleases = newDVDReleases;
        this.newDVDReleaseList = (List<Movie>) newDVDReleases.values();
    }
    
    /**
     * Set new DVD releases
     * @param newDVDReleases 
     */
    public void setNewDVDReleases(List<Movie> newDVDReleases) {
        this.newDVDReleaseList = newDVDReleases;
        newDVDReleases.stream().forEach((movie) -> {
            this.newDVDReleases.put(movie.getId(), movie);
        });
    }

    /**
     * Get new theater releases
     * @return 
     */
    public HashMap<String, Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }
    
    /**
     * Get new theater releases
     * @return 
     */
    public List<Movie> getNewTheaterReleasesList() {
        return new ArrayList<>(newTheaterReleases.values());
    }

    /**
     * Set new in-theater releases
     * @param newTheaterReleases 
     */
    public void setNewTheaterReleases(HashMap<String, Movie> newTheaterReleases) {
        this.newTheaterReleases = newTheaterReleases;
        this.newTheaterReleaseList = (List<Movie>) newTheaterReleases.values();
    }
    
    /**
     * Set new in-theater releases
     * @param newTheaterReleases 
     */
    public void setNewTheaterReleases(List<Movie> newTheaterReleases) {
        this.newTheaterReleaseList = newTheaterReleases;
        newTheaterReleases.stream().forEach((movie) -> {
            this.newTheaterReleases.put(movie.getId(), movie);
        });
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
     * Get the new or existing Reel Deal rating
     * @return new Reel Deal rating
     */
    public ReelDealRating getActiveUserRating() {
        return activeUserRating;
    }

    /**
     * Set the new or existing Reel Deal rating
     * @param newRating new Reel Deal rating
     */
    public void setActiveUserRating(ReelDealRating newRating) {
        this.activeUserRating = newRating;
    }
    
    
    public LinkedHashMap<String, Movie> sortMoviesByRating(HashMap<String, Movie> movies) {
        List movieList = new LinkedList(movies.entrySet());
        Collections.sort(movieList, new MovieRatingComparator());
        LinkedHashMap<String, Movie> sortedMovies = new LinkedHashMap<>();
        for (Iterator it = movieList.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMovies.put((String) entry.getKey(), (Movie) entry.getValue());
        }
        return sortedMovies;
    }
    
    public Movie getRecommendation() {
        LinkedHashMap<String, Movie> sortedMovieList = sortMoviesByRating(newDVDReleases); //TODO: change to all rated movies instead of DVD releases
        Set movies = sortedMovieList.entrySet();
        Iterator moviesIterator = movies.iterator();
        if (!moviesIterator.hasNext()) {
            throw new java.util.NoSuchElementException("Empty map returned from sort!");
        }
        return (Movie)((HashMap.Entry)moviesIterator.next()).getValue();
    }
    
    public Movie getRecommendation(String major) {
        System.out.println("Getting recommendation based on major: " + major);
        float highestRating = 0;
        Movie recommendedMovie = new Movie();   //TODO: This is an empty movie. If no ratings, this is returned. Handle this better
        for (Movie m : newDVDReleases.values()) { //TODO: change to all rated movies instead of DVD releases
            float curRating = m.getMajorSpecificRating(major);
            if (curRating > highestRating) {
                highestRating = curRating;
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

    public HashMap<String, Movie> getRatedMovies() {
        return ratedMovies;
    }
    
    public List<Movie> getRatedMoviesList() {
        return new ArrayList<>(ratedMovies.values());
    }

    public void setRatedMovies(HashMap<String, Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
    
    
}
