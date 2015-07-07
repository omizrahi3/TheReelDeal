/*
 * Contains various overarching manager
 * handles for directing the control and flow of the application.
 */
package gatech.cs2340.team7;

import input.output.MovieIO;
import com.rottentomatoes.Movie;
import com.rottentomatoes.ReelDealRating;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import usermanagement.User;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Stores and handles processing of all movie-related data
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
    
    /**
     * Empty Constructor
     */
    public MovieManager() {
        this(new HashMap<>(), new HashMap<>(), null, null);  
    }
    
    /**
     * Constructor with all data members specified
     * @param newTheaterReleases Collection of new theater releases
     * @param newDVDReleases Collection of new DVD releases
     * @param searchResultMovies Collection of movies from search results
     * @param selectedMovie Movie selected by user to see further information
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
        //ratedMovies = new HashMap<>();
        ratedMovies = MovieIO.readFile();
        ControlHub.getInstance().setMovieManager(this);
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
    
    /**
     * Use the given unique identifier to find the selected movie, depending on
     * which collection the movie is currently in
     * @param id Unique identifier for the selected movie
     * @return Page to navigate to after finding the movie
     */
    public String movieSelected(String id) {
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
            throw new java.util.NoSuchElementException("Movie with id " +
                    id + " not found!");
        }
        if (ratedMovies.get(id) != null) {
            selectedMovie.setReelDealRatings(ratedMovies.get(id).getReelDealRatings());
            User activeUser = ControlHub.getInstance().getActiveUser();
            if (activeUser.getMovieRatings().containsKey(id)) {
                //activeUserRating.assertReels(activeUser.getUserReels(id));
                activeUserRating = activeUser.getMovieReviewFor(selectedMovie.getId());
                activeUserRating.setDisplayDescriptor("Edit Your Review");
            }
        }
        return ControlHub.MOVIE_DETAIL_URL;
    }
    
    /**
     * Add the new Reel Deal rating to the selected movie
     * @return Page to navigate to after processing the addition
     */
    public String addRating() {
        if (selectedMovie == null) {
            throw new java.util.NoSuchElementException("No Selected Movie!");
        }
        User activeUser = ControlHub.getInstance().getActiveUser();
        activeUserRating.setAuthor(activeUser);
        ReelDealRating ratingToBeSet = new ReelDealRating(activeUserRating);
        if (activeUser.hasRatedMovie(selectedMovie.getId())) {
            activeUser.updateMovieRating(selectedMovie.getId(), ratingToBeSet);
            selectedMovie.updateMovieRating(activeUser, ratingToBeSet);
        } else {
            selectedMovie.addReelDealRating(
                    new ReelDealRating(activeUserRating));
            ratedMovies.put(selectedMovie.getId(), selectedMovie);
            activeUser.newMovieRating(selectedMovie.getId(),
                    new ReelDealRating(activeUserRating));
        }
        activeUserRating.clearData();
        ControlHub.getInstance().saveState();
        return ControlHub.POST_REVIEW_URL;
    }
    
    /**
     * Get movies returned by REST query
     * @return Collection of movies from search results, as a HashMap
     */
    public HashMap<String, Movie> getSearchResultMovies() {
        return searchResultMovies;
    }
    
    /**
     * Get movies returned by REST query
     * @return Collection of movies from search results, as a List
     */
    public List<Movie> getSearchResultMoviesList() {
        return new ArrayList<>(searchResultMovies.values());
    }

    /**
     * Set movies returned by REST query
     * @param searchResultMovies Collection of movies from search results
     */
    public void setSearchResultMovies(HashMap<String, Movie> searchResultMovies) {
        this.searchResultMovies = searchResultMovies;
        System.out.println("Search Results");
        searchResultMovies.values().stream().forEach((m) -> {m.assertDefaultValuesOfUndefData();});
    }
    
    /**
     * Set movies returned by REST query
     * @param searchResultMovies Collection of movies from search results
     */
    public void setSearchResultMovies(List<Movie> searchResultMovies) {
        this.searchResultMovies = new HashMap<>();
        searchResultMovies.stream().forEach((movie) -> {
            this.searchResultMovies.put(movie.getId(), movie);
        });
        this.searchResultMovies.values().stream().forEach((movie) -> {movie.assertDefaultValuesOfUndefData();});
    }

    /**
     * Get new DVD releases
     * @return New DVD releases
     */
    public HashMap<String, Movie> getNewDVDReleases() {
        return newDVDReleases;
    }
    
    /**
     * Get new DVD releases
     * @return New DVD releases
     */
    public List<Movie> getNewDVDReleasesList() {
        return new ArrayList<>(newDVDReleases.values());
    }

    /**
     * Set new DVD releases
     * @param newDVDReleases New DVD releases
     */
    public void setNewDVDReleases(HashMap<String, Movie> newDVDReleases) {
        this.newDVDReleases = newDVDReleases;
    }
    
    /**
     * Set new DVD releases
     * @param newDVDReleases New DVD releases
     */
    public void setNewDVDReleases(List<Movie> newDVDReleases) {
        newDVDReleases.stream().forEach((movie) -> {
            this.newDVDReleases.put(movie.getId(), movie);
        });
    }

    /**
     * Get new theater releases
     * @return New theater releases
     */
    public HashMap<String, Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }
    
    /**
     * Get new theater releases
     * @return New theater releases
     */
    public List<Movie> getNewTheaterReleasesList() {
        return new ArrayList<>(newTheaterReleases.values());
    }

    /**
     * Set new in-theater releases
     * @param newTheaterReleases New in-theater releases
     */
    public void setNewTheaterReleases(HashMap<String, Movie> newTheaterReleases) {
        this.newTheaterReleases = newTheaterReleases;
    }
    
    /**
     * Set new in-theater releases
     * @param newTheaterReleases New in-theater releases
     */
    public void setNewTheaterReleases(List<Movie> newTheaterReleases) {
        newTheaterReleases.stream().forEach((movie) -> {
            this.newTheaterReleases.put(movie.getId(), movie);
        });
    }

    /**
     * Return selected movie for detailed view
     * @return Handle for the selected movie
     */
    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    /**
     * Set selected movie for detailed view
     * @param selectedMovie Selected movie for more info to be displayed
     */
    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    /**
     * Get the new Reel Deal rating
     * @return New Reel Deal rating
     */
    public ReelDealRating getActiveUserRating() {
        return activeUserRating;
    }

    /**
     * Set the new Reel Deal rating
     * @param newRating new Reel Deal rating
     */
    public void setActiveUserRating(ReelDealRating newRating) {
        this.activeUserRating = newRating;
    }
    
    /**
     * Sort the collection of rated movies, by the Reel Deal numerical score
     * @param movies
     * @return 
     */
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
    
    /**
     * Return a recommended movie, based on the sorted Reel Deal scores 
     * @return Recommended movie
     */
    public Movie getRecommendation() {
        return getRecommendation("");
    }
    
    /**
     * Return a recommended movie, based on the sorted Reel Deal scores. Filter
     * by ratings done by members of the same major as the active user
     * @param major Major to filter sorting by
     * @return Recommended movie
     */
    public Movie getRecommendation(String major) {
        System.out.println("Getting recommendation based on major: " + major);
        float highestRating = 0;
        Movie recommendedMovie = null;
        for (Movie m : ratedMovies.values()) {
            float curRating = (major.length() > 0 ? 
                    m.getMajorSpecificRating(major) : 
                    Float.parseFloat(m.getAverageRating()));
            if (curRating > highestRating) {
                highestRating = curRating;
                recommendedMovie = m;
            }
        }
        return recommendedMovie;
    }
    
    /**
     * Show the recommendation
     * @return Page to navigate to after showing the recommendation
     */
    public String viewRecommendation() {
        return viewRecommendation("");
    }
    
    /**
     * Show the recommended movie, based on the major of the active user
     * @param major Major of the active user
     * @return Page to navigate to after showing the recommendation
     */
    public String viewRecommendation(String major) {
        String nextPage = null;
        // If there are rated movies, then get and show the recommendation.
        //   Otherwise, stay on the current page and show an error message
        if (ratedMovies.values().size() > 0) {
            System.out.println("Processing Recommendation.");
            selectedMovie = getRecommendation();
            nextPage = ControlHub.MOVIE_DETAIL_URL;
        } else {
            // Show error message
            System.out.println("No movies to rate.");
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", 
                            "There are no movies rated, so a recommendation cannot be given! " +
                            "Take some time to write some reviews, and then we can try again."));
        }
        return nextPage;
    }

    /**
     * Getter for the collection of movies rated through the Reel Deal
     * application
     * @return Collection of movies rated through the Reel Deal application
     */
    public HashMap<String, Movie> getRatedMovies() {
        return ratedMovies;
    }
    
    /**
     * Getter for the collection of movies rated through the Reel Deal
     * application, as a List
     * @return Collection of movies rated through the Reel Deal application
     */
    public List<Movie> getRatedMoviesList() {
        return new ArrayList<>(ratedMovies.values());
    }

    /**
     * Setter for the collection of movies rated through the Reel Deal
     * application
     * @param ratedMovies Collection of movies rated through the Reel Deal
     * application
     */
    public void setRatedMovies(HashMap<String, Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
    
    /**
     * Save the state of all movies to a binary file
     */
    public void saveState() {
        System.out.println("Saving state of users");
        MovieIO.WriteToFile(ratedMovies);
    }
    
    /**
     * Return to the movie hub page
     * @return 
     */
    public String backToMovieHub() {
        selectedMovie = new Movie();
        activeUserRating = new ReelDealRating();
        return ControlHub.MOVIE_HUB_URL;
    }
}
