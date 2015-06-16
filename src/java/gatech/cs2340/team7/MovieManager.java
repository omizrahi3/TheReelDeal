/*
MovieManager class to handle all movie data processing and maintenance
 */
package gatech.cs2340.team7;

import com.rottentomatoes.Movie;
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
    
    /**
     * Empty Constructor
     */
    public MovieManager() {
        this(new ArrayList<>(), new ArrayList<>(), null);  
    }
    
    /**
     * Data members with DVD and in-theater releases specified
     * @param newDVDReleases
     * @param newTheaterReleases 
     */
    public MovieManager(List<Movie> newDVDReleases, List<Movie> newTheaterReleases) {
        this(new ArrayList<>(), new ArrayList<>(), null);
    }
    
    /**
     * Constructor with all data members specified
     * @param newTheaterReleases
     * @param newDVDReleases
     * @param searchResultMovies
     */
    public MovieManager(List<Movie> newTheaterReleases,
            List<Movie> newDVDReleases, List<Movie> searchResultMovies) {
        this.searchResultMovies = newTheaterReleases;
        this.newDVDReleases = newDVDReleases;
        this.newTheaterReleases = searchResultMovies;
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
}
