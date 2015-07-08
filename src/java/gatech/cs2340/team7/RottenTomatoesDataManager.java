/*
 * Contains various overarching manager
 * handles for directing the control and flow of the application.
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
import javax.faces.context.FacesContext;

/**
 * Controls the maintenance and processing of all Rotten Tomatoes data
 *
 * @author Anthony
 */
@ManagedBean(name = "rottenTomatoesDataManager", eager = true)
@ApplicationScoped
public class RottenTomatoesDataManager implements Serializable {

    /**
     * Base string for all URL queries.
     */
    public static final String BASE_API_URI
            = "http://api.rottentomatoes.com/api/public/v1.0";

    /**
     * API key for all URL queries.
     */
    public static final String API_KEY
            = "yedukp76ffytfuy24zsqk7f5";

    /**
     * Base string for all box office URL queries.
     */
    public static final String BOX_OFFICE_URLTOK
            = "/lists/movies/box_office.json";

    /**
     * Base string for all new theater URL queries.
     */
    public static final String NEW_RELEASE_TOK
            = "/lists/movies/in_theaters.json";

    /**
     * Base string for all new DVD URL queries.
     */
    public static final String NEW_DVD_TOK
            = "/lists/dvds/new_releases.json";

    /**
     * Base string for all general movie search URL queries.
     */
    public static final String GEN_SEARCH_TOK
            = "/movies.json";

    /**
     * Query token for an individual URL query.
     */
    private String queryToken;

    /**
     * Handler for all REST API queries.
     */
    private RESTQuery query;

    /**
     * Controller for all movies.
     */
    private MovieManager movieManager;

    /**
     * Indicator for showing search data on the XHTML page.
     */
    private boolean showSearchData;

    /**
     * Token used to identify the movie selected by the user for movie
     * information or a Reel Deal rating.
     */
    private String selectedMovieTok;

    /**
     * Empty constructor that sets default data.
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public RottenTomatoesDataManager() {
        query = new RESTQuery();
        movieManager = new MovieManager();
        showSearchData = false;
        selectedMovieTok = "";
        updateNewReleasesLists();
        // ALWAYS have this be the final instruction in the constructor.
        ControlHub.getInstance().setDataManager(this);
    }

    /**
     * Get the selected movie token set by the JSF page, and notify the movie
     * manager that the movie has been selected.
     *
     * @return Next page to navigate to after notifying the movie manager that a
     * movie has been selected
     */
    public final String movieSelected() {
        Map<String, String> params;
        params = FacesContext.getCurrentInstance().getExternalContext()
                        .getRequestParameterMap();
        selectedMovieTok = params.get("selectedMovie");
        movieManager.movieSelected(selectedMovieTok);
        return ControlHub.MOVIE_DETAIL_URL;
    }

    /**
     * Convert the JSON data to a RottenTomatoesDTO object handle.
     *
     * @param rawData JSON data
     * @return RottenTomatoesDTO object handle
     */
    public final RottenTomatoesDTO fromJSONToPOJO(final String rawData) {
        Gson gson;
        GsonBuilder builder;
        builder = new GsonBuilder();
        builder.registerTypeAdapter(Integer.class, new IntegerAdapter());
        gson = builder.create();
        return gson.fromJson(rawData, RottenTomatoesDTO.class);
    }

    /**
     * Obtain the most recent new releases (DVD and Theater) lists and display
     * them.
     */
    public final void updateNewReleasesLists() {
        query.setQueryURL(BASE_API_URI + NEW_DVD_TOK
                + "?limit=16&country=us&apikey=" + API_KEY);
        movieManager.setNewDVDReleases(
                fromJSONToPOJO(query.processQuery()).getMovies());

        query.setQueryURL(BASE_API_URI + NEW_RELEASE_TOK
                + "?limit=16&country=us&apikey=" + API_KEY);
        movieManager.setNewTheaterReleases(
                fromJSONToPOJO(query.processQuery()).getMovies());
        movieManager.assertDefaultValuesOfUndefData();
    }

    /**
     * Perform a query to Rotten Tomatoes for a specific keyword.
     *
     * @return data received from the HTTP query
     */
    public final String queryForMovie() {
        if (RESTQuery.validQueryToken(queryToken)) {
            query.setQueryURL(BASE_API_URI + GEN_SEARCH_TOK
                    + "?q=" + queryToken
                    + "&page_limit=10&page=1&apikey=" + API_KEY);
            movieManager.setSearchResultMovies(
                    fromJSONToPOJO(query.processQuery()).getMovies());
            showSearchData = true;
            queryToken = "";
            return ControlHub.MOVIE_HUB_URL;
        }
        queryToken = "";
        return null;
    }

    /**
     * Get the query token.
     *
     * @return query token
     */
    public final String getQueryToken() {
        return queryToken;
    }

    /**
     * Set the query token.
     *
     * @param newQueryToken new query token
     */
    public final void setQueryToken(final String newQueryToken) {
        this.queryToken = newQueryToken;
    }

    /**
     * Get the query handle.
     *
     * @return query handle
     */
    public final RESTQuery getQuery() {
        return query;
    }

    /**
     * Set the query handle.
     *
     * @param newQuery query handle
     */
    public final void setQuery(final RESTQuery newQuery) {
        this.query = newQuery;
    }

    /**
     * Save the state of the movie manager to a binary file.
     */
    public final void saveState() {
        movieManager.saveState();
    }

    /**
     * Get the movie manager handle.
     *
     * @return movie manager handle
     */
    public final MovieManager getMovieManager() {
        return movieManager;
    }

    /**
     * Set the movie manager handle.
     *
     * @param newMovieManager movie manager handle
     */
    public final void setMovieManager(final MovieManager newMovieManager) {
        this.movieManager = newMovieManager;
    }

    /**
     * Return whether to display search results.
     *
     * @return display or not
     */
    public final boolean isShowSearchData() {
        return showSearchData;
    }

    /**
     * Set whether to display search data.
     *
     * @param showData search data display indication
     */
    public final void setShowSearchData(final boolean showData) {
        this.showSearchData = showData;
    }

    /**
     * Return the name of the selected movie for more info to be displayed.
     *
     * @return name of selected movie
     */
    public final String getSelectedMovieTok() {
        return selectedMovieTok;
    }

    /**
     * Set the name of the selected movie for more info to be displayed.
     *
     * @param newMovieTok name of selected movie
     */
    public final void setSelectedMovieTok(final String newMovieTok) {
        this.selectedMovieTok = newMovieTok;
    }
}
