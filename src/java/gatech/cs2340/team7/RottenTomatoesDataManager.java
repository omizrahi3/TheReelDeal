/*
Class to handle REST interfacing with the Rotten Tomatoes website
 */
package gatech.cs2340.team7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rottentomatoes.RottenTomatoesData;
import com.rottentomatoes.IntegerAdapter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "rottenTomatoesDataManager", eager = true)
@SessionScoped
public class RottenTomatoesDataManager {
    
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
      
    /**
     * Constructor
     */
    public RottenTomatoesDataManager() {
        System.out.println("New RottenTomatoesDataManager created");
        query = new RESTQuery();
        movieManager = new MovieManager();
        updateNewReleasesLists();
    }
    
    /**
     * Convert the JSON data to a RottenTomatoesData object handle
     * @param rawData JSON data
     * @return RottenTomatoesData object handle
     */
    public RottenTomatoesData JSONToPOJO(String rawData) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Integer.class, new IntegerAdapter());
        Gson gson = builder.create();
        return gson.fromJson(rawData, RottenTomatoesData.class);        
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
            return NavigationManager.movieSearch;
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
}
