/*
Class to handle REST interfacing with the Rotten Tomatoes website
 */
package gatech.cs2340.team7;

import com.google.gson.Gson;
import com.rottentomatoes.*; // TODO don't import all

import java.util.List;

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
      
    public RottenTomatoesDataManager() {
        query = new RESTQuery();
        movieManager = new MovieManager();
        updateNewReleasesLists();
    }
    
    public RottenTomatoesData JSONToPOJO(String rawData) {
        Gson gson = new Gson();
        return gson.fromJson(rawData, RottenTomatoesData.class);        
    }
    
    public void updateNewReleasesLists() {
        query.setQueryURL(BASE_API_URI + NEW_DVD_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" + APIKey);
        movieManager.setNewDVDReleases(JSONToPOJO(query.processQuery()).getMovies());
        
        query.setQueryURL(BASE_API_URI + NEW_THEATER_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" + APIKey);
        movieManager.setNewTheaterReleases(JSONToPOJO(query.processQuery()).getMovies());
    }
    
    public String queryForMovie() {
        if (RESTQuery.validQueryToken(queryToken)) {
            query.setQueryURL(BASE_API_URI + MOVIE_SEARCH_URLTOK +
                    "?q=" + queryToken +
                    "&page_limit=10&page=1&apikey=" + APIKey);
            RottenTomatoesData data = JSONToPOJO(query.processQuery());
            movieManager.setSearchResultMovies(JSONToPOJO(query.processQuery()).getMovies());
            showSearchData = true;
            queryToken = "";
            return NavigationManager.movieSearch;
        }
        queryToken = "";
        return null;
    }
    
    public String getQueryToken() {
        return queryToken;
    }

    public void setQueryToken(String queryToken) {
        this.queryToken = queryToken;
    }

    public RESTQuery getQuery() {
        return query;
    }

    public void setQuery(RESTQuery query) {
        this.query = query;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }
    
    /**
     * Return whether to dispalay search results
     * @return 
     */
    public boolean isShowSearchData() {
        return showSearchData;
    }

    /**
     * Set whether to display search results
    */
    public void setShowSearchData(boolean showData) {
        this.showSearchData = showData;
    }
}
