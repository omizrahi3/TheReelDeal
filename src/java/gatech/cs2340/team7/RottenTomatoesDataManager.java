/*
Class to handle REST interfacing with the Rotten Tomatoes website
 */
package gatech.cs2340.team7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rottentomatoes.RottenTomatoesDTO;
import com.rottentomatoes.IntegerAdapter;
import java.io.Serializable;

import java.util.Map;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "rottenTomatoesDataManager", eager = true)
@ApplicationScoped
public class RottenTomatoesDataManager implements Serializable {
    
    public static final String BASE_API_URI = "http://api.rottentomatoes.com/api/public/v1.0";
    public static final String APIKey = "yedukp76ffytfuy24zsqk7f5";
    public static final String BOX_OFFICE_URLTOK = "/lists/movies/box_office.json";
    public static final String NEW_THEATER_RELEASE_URLTOK = "/lists/movies/in_theaters.json";
    public static final String NEW_DVD_RELEASE_URLTOK = "/lists/dvds/new_releases.json";
    public static final String MOVIE_SEARCH_URLTOK = "/movies.json";
    
    private String queryToken;
    private RESTQuery query;
    private MovieManager movieManager;
    private boolean showSearchData;
    private String selectedMovieTok;
    private final ControlHub controlHub;
      
    /**
     * Constructor
     */
    public RottenTomatoesDataManager() {
        System.out.println("New RottenTomatoesDataManager created");
        query = new RESTQuery();
        movieManager = new MovieManager();
        showSearchData = false;
        selectedMovieTok = "";
        updateNewReleasesLists();
        controlHub = ControlHub.getInstance();
        controlHub.setDataManager(this);
    }
    
    public String movieSelected() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        System.out.println("Movie selected: " + params.get("selectedMovie"));
        selectedMovieTok = params.get("selectedMovie");
        movieManager.movieSelected(selectedMovieTok);
        return ControlHub.movieDetailedViewPageURL;
    }
    
    /**
     * Convert the JSON data to a RottenTomatoesDTO object handle
     * @param rawData JSON data
     * @return RottenTomatoesDTO object handle
     */
    public RottenTomatoesDTO JSONToPOJO(String rawData) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Integer.class, new IntegerAdapter());
        Gson gson = builder.create();
        return gson.fromJson(rawData, RottenTomatoesDTO.class);        
    }
    
    /**
     * Obtain the most recent new releases (DVD and Theater) lists
     * and display them
     */
    public final void updateNewReleasesLists() {
        query.setQueryURL(BASE_API_URI + NEW_DVD_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" + APIKey);
        movieManager.setNewDVDReleases(JSONToPOJO(query.processQuery()).getMovies());
        
        query.setQueryURL(BASE_API_URI + NEW_THEATER_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" + APIKey);
        movieManager.setNewTheaterReleases(JSONToPOJO(query.processQuery()).getMovies());
        movieManager.assertDefaultValuesOfUndefData();
    }
    
    /**
     * Perform a query to Rotten Tomatoes for a specific keyword
     * @return data received from the HTTP query
     */
    public String queryForMovie() {
        if (RESTQuery.validQueryToken(queryToken)) {
            query.setQueryURL(BASE_API_URI + MOVIE_SEARCH_URLTOK +
                    "?q=" + queryToken +
                    "&page_limit=10&page=1&apikey=" + APIKey);
            movieManager.setSearchResultMovies(JSONToPOJO(query.processQuery()).getMovies());
            showSearchData = true;
            queryToken = "";
            return ControlHub.movieHubPageURL;
        }
        queryToken = "";
        return null;
    }
    
    /**
     * Get the query token
     * @return query token 
     */
    public String getQueryToken() {
        return queryToken;
    }

    /**
     * Set the query token
     * @param queryToken new query token
     */
    public void setQueryToken(String queryToken) {
        this.queryToken = queryToken;
    }

    /**
     * Get the query handle
     * @return query handle
     */
    public RESTQuery getQuery() {
        return query;
    }

    /**
     * Set the query handle
     * @param query query handle 
     */
    public void setQuery(RESTQuery query) {
        this.query = query;
    }

    /**
     * Get the movie manager handle
     * @return movie manager handle
     */
    public MovieManager getMovieManager() {
        return movieManager;
    }

    /**
     * Set the movie manager handle
     * @param movieManager movie manager handle
     */
    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }
    
    /**
     * Return whether to display search results
     * @return display or not
     */
    public boolean isShowSearchData() {
        return showSearchData;
    }
    
    /**
     * Set whether to display search data
     * @param showData search data display indication
     */
    public void setShowSearchData(boolean showData) {
        this.showSearchData = showData;
    }

    /**
     * Return the name of the selected movie for more info to be displayed
     * @return name of selected movie
     */
    public String getSelectedMovieTok() {
        return selectedMovieTok;
    }

    /**
     * Set the name of the selected movie for more info to be displayed
     * @param selectedMovieTok name of selected movie
     */
    public void setSelectedMovieTok(String selectedMovieTok) {
        this.selectedMovieTok = selectedMovieTok;
    }
}
