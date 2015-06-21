/*
MovieManager class to handle all movie data processing and maintenance
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;
import com.rottentomatoes.ReelDeelReview;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
     */
    public MovieManager(List<Movie> newDVDReleases,
            List<Movie> newTheaterReleases, List<Movie> searchResultMovies,
            Movie selectedMovie) {
        this.newDVDReleases = newDVDReleases;
        this.newTheaterReleases = newTheaterReleases;
        this.searchResultMovies = searchResultMovies;
        this.selectedMovie = selectedMovie;
    }
    
    /**
     * Assert that all movie data is correctly set for user readability
     */
    public void assertDataFidelity() {
        this.newDVDReleases.stream().forEach((movie) -> {movie.assertDataFidelity();});
        this.newTheaterReleases.stream().forEach((movie) -> {movie.assertDataFidelity();});
        if (searchResultMovies != null) {
            this.searchResultMovies.stream().forEach((movie) -> {movie.assertDataFidelity();});
        }
        
    }
    
    public void movieSelected(String name) {
        // TODO fix this horrendous algorithm (make lists into maps keyed by movie name
        this.searchResultMovies.stream().filter((m) -> (m.getTitle().equals(name))).forEach((m) -> {
            System.out.println("Selected movie: " + m.getTitle());
            this.selectedMovie = m;
        });
        this.newDVDReleases.stream().filter((m) -> (m.getTitle().equals(name))).forEach((m) -> {
            System.out.println("Selected movie: " + m.getTitle());
            this.selectedMovie = m;
        });
        this.newTheaterReleases.stream().filter((m) -> (m.getTitle().equals(name))).forEach((m) -> {
            System.out.println("Selected movie: " + m.getTitle());
            this.selectedMovie = m;
        }); // TODO handle case of not finding movie
    }
    
    public void addReview(ReelDeelReview newReview) {
        if (selectedMovie == null) {
            throw new java.util.NoSuchElementException("No Selected Movie!");
        }
        selectedMovie.addReelDeelReview(newReview);        
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
        searchResultMovies.stream().forEach((m) -> {m.assertDataFidelity();});
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
    
    
}
