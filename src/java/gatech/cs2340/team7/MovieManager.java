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
 * Stores and handles processing of all movie-related data.
 *
 * @author Anthony
 */
@ManagedBean(name = "movieManager", eager = true)
@SessionScoped
public class MovieManager {

    /**
     * Map of movies set from a search. The movies are keyed by their unique
     * id returned from Rotten Tomatoes
     */
    private HashMap<String, Movie> searchResultMovies;

    /**
     * Map of movies set from the new DVD's list.
     * The movies are keyed by their unique id returned from Rotten Tomatoes
     */
    private HashMap<String, Movie> newDVDReleases;

    /**
     * Map of movies set from the new theater releases list.
     * The movies are keyed by their unique id returned from Rotten Tomatoes
     */
    private HashMap<String, Movie> newTheaterReleases;

    /**
     * The currently selected movie by the user.
     */
    private Movie selectedMovie;

    /**
     * The current (or default) user rating displayed for the user on the
     * movie details page.
     */
    private ReelDealRating activeUserRating;

    /**
     * All Reel Deal ratings added to the application.
     */
    private HashMap<String, Movie> ratedMovies;

    /**
     * Empty Constructor.
     */
    public MovieManager() {
        this(new HashMap<>(), new HashMap<>(), null, null);
    }

    /**
     * Constructor with all data members specified.
     *
     * @param newNewtheaterReleases Collection of new theater releases
     * @param newNewDVDReleases Collection of new DVD releases
     * @param newSearchResultMovies Collection of movies from search results
     * @param newSelectedMovie Movie selected by user to see further information
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public MovieManager(final HashMap<String, Movie> newNewDVDReleases,
            final HashMap<String, Movie> newNewtheaterReleases,
            final HashMap<String, Movie> newSearchResultMovies,
            final Movie newSelectedMovie) {
        this.newDVDReleases = newNewDVDReleases;
        this.newTheaterReleases = newNewtheaterReleases;
        this.searchResultMovies = newSearchResultMovies;
        this.selectedMovie = newSelectedMovie;
        this.activeUserRating = new ReelDealRating();
        ratedMovies = MovieIO.readFile();
        // ALWAYS have this be the final instruction in the constructor.
        ControlHub.getInstance().setMovieManager(this);
    }

    /**
     * Assert that all movie data is correctly set for user readability.
     */
    public final void assertDefaultValuesOfUndefData() {
        this.newDVDReleases.values().stream().forEach((movie) -> {
            movie.assertDefaultValuesOfUndefData();
        });
        this.newTheaterReleases.values().stream().forEach((movie) -> {
            movie.assertDefaultValuesOfUndefData();
        });
        if (searchResultMovies != null) {
            this.searchResultMovies.values().stream().forEach((movie) -> {
                movie.assertDefaultValuesOfUndefData();
            });
        }

    }

    /**
     * Use the given unique identifier to find the selected movie, depending on
     * which collection the movie is currently in.
     *
     * @param id Unique identifier for the selected movie
     * @return Page to navigate to after finding the movie
     */
    public final String movieSelected(final String id) {
        Movie tempMovie;
        if (newDVDReleases.containsKey(id)) {
            tempMovie = newDVDReleases.get(id);
            selectedMovie = tempMovie;
        } else if (newTheaterReleases.containsKey(id)) {
            tempMovie = newTheaterReleases.get(id);
            selectedMovie = tempMovie;
        } else if (searchResultMovies != null
                && (searchResultMovies.containsKey(id))) {
            tempMovie = searchResultMovies.get(id);
            selectedMovie = tempMovie;
        } else {
            throw new java.util.NoSuchElementException("Movie with id "
                    + id + " not found!");
        }
        if (ratedMovies.get(id) != null) {
            selectedMovie.setReelDealRatings(
                    ratedMovies.get(id).getReelDealRatings());
            User activeUser = ControlHub.getInstance().getActiveUser();
            if (activeUser.getMovieRatings().containsKey(id)) {
                //activeUserRating.assertReels(activeUser.getUserReels(id));
                activeUserRating = activeUser.getMovieReviewFor(
                        selectedMovie.getId());
                activeUserRating.setDisplayDescriptor("Edit Your Review");
            }
        }
        return ControlHub.MOVIE_DETAIL_URL;
    }

    /**
     * Add the new Reel Deal rating to the selected movie.
     *
     * @return Page to navigate to after processing the addition
     */
    public final String addRating() {
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
     * Get movies returned by REST query.
     *
     * @return Collection of movies from search results, as a HashMap
     */
    public final HashMap<String, Movie> getSearchResultMovies() {
        return searchResultMovies;
    }

    /**
     * Get movies returned by REST query.
     *
     * @return Collection of movies from search results, as a List
     */
    public final List<Movie> getSearchResultMoviesList() {
        return new ArrayList<>(searchResultMovies.values());
    }

    /**
     * Set movies returned by REST query.
     *
     * @param newSearchResultMovies Collection of movies from search results
     */
    public final void setSearchResultMovies(
            final HashMap<String, Movie> newSearchResultMovies) {
        this.searchResultMovies = newSearchResultMovies;
        this.searchResultMovies.values().stream().forEach((m) -> {
            m.assertDefaultValuesOfUndefData();
        });
    }

    /**
     * Set movies returned by REST query.
     *
     * @param newSearchResultMovies Collection of movies from search results
     */
    public final void setSearchResultMovies(
            final List<Movie> newSearchResultMovies) {
        this.searchResultMovies = new HashMap<>();
        newSearchResultMovies.stream().forEach((movie) -> {
            this.searchResultMovies.put(movie.getId(), movie);
        });
        this.searchResultMovies.values().stream().forEach((movie) -> {
            movie.assertDefaultValuesOfUndefData();
        });
    }

    /**
     * Get new DVD releases.
     *
     * @return New DVD releases
     */
    public final HashMap<String, Movie> getNewDVDReleases() {
        return newDVDReleases;
    }

    /**
     * Get new DVD releases.
     *
     * @return New DVD releases
     */
    public final List<Movie> getNewDVDReleasesList() {
        return new ArrayList<>(newDVDReleases.values());
    }

    /**
     * Set new DVD releases.
     *
     * @param newNewDVDReleases New DVD releases
     */
    public final void setNewDVDReleases(
            final HashMap<String, Movie> newNewDVDReleases) {
        this.newDVDReleases = newNewDVDReleases;
    }

    /**
     * Set new DVD releases.
     *
     * @param newNewDVDReleases New DVD releases
     */
    public final void setNewDVDReleases(final List<Movie> newNewDVDReleases) {
        newNewDVDReleases.stream().forEach((movie) -> {
            this.newDVDReleases.put(movie.getId(), movie);
        });
    }

    /**
     * Get new theater releases.
     *
     * @return New theater releases
     */
    public final HashMap<String, Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }

    /**
     * Get new theater releases.
     *
     * @return New theater releases
     */
    public final List<Movie> getNewTheaterReleasesList() {
        return new ArrayList<>(newTheaterReleases.values());
    }

    /**
     * Set new in-theater releases.
     *
     * @param newNewTheaterReleases New in-theater releases
     */
    public final void setNewTheaterReleases(
            final HashMap<String, Movie> newNewTheaterReleases) {
        this.newTheaterReleases = newNewTheaterReleases;
    }

    /**
     * Set new in-theater releases.
     *
     * @param newNewTheaterReleases New in-theater releases
     */
    public final void setNewTheaterReleases(
            final List<Movie> newNewTheaterReleases) {
        newNewTheaterReleases.stream().forEach((movie) -> {
            this.newTheaterReleases.put(movie.getId(), movie);
        });
    }

    /**
     * Return selected movie for detailed view.
     *
     * @return Handle for the selected movie
     */
    public final Movie getSelectedMovie() {
        return selectedMovie;
    }

    /**
     * Set selected movie for detailed view.
     *
     * @param newSelectedMovie Selected movie for more info to be displayed
     */
    public final void setSelectedMovie(final Movie newSelectedMovie) {
        this.selectedMovie = newSelectedMovie;
    }

    /**
     * Get the new Reel Deal rating.
     *
     * @return New Reel Deal rating
     */
    public final ReelDealRating getActiveUserRating() {
        return activeUserRating;
    }

    /**
     * Set the new Reel Deal rating.
     *
     * @param newRating new Reel Deal rating
     */
    public final void setActiveUserRating(final ReelDealRating newRating) {
        this.activeUserRating = newRating;
    }

    /**
     * Sort the collection of rated movies, by the Reel Deal numerical score.
     *
     * @param movies Rated movies to sort
     * @return The collection of rated movies, sorted by Reel Deal rating
     */
    public final LinkedHashMap<String, Movie> sortMoviesByRating(
            final HashMap<String, Movie> movies) {
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
     * Return a recommended movie, based on the sorted Reel Deal scores.
     *
     * @return Recommended movie
     */
    public final Movie getRecommendation() {
        return getRecommendation("");
    }

    /**
     * Return a recommended movie, based on the sorted Reel Deal scores. Filter
     * by ratings done by members of the same major as the active user
     *
     * @param major Major to filter sorting by
     * @return Recommended movie
     */
    public final Movie getRecommendation(final String major) {
        System.out.println("Getting recommendation based on major: " + major);
        float highestRating = 0;
        Movie recommendedMovie = null;
        for (Movie m : ratedMovies.values()) {
            float curRating;
            if (major.length() > 0) {
                curRating = m.getMajorSpecificRating(major);
            } else {
                curRating = Float.parseFloat(m.getAverageRating());
            }
            if (curRating > highestRating) {
                highestRating = curRating;
                recommendedMovie = m;
            }
        }
        return recommendedMovie;
    }

    /**
     * Show the recommendation.
     *
     * @return Page to navigate to after showing the recommendation
     */
    public final String viewRecommendation() {
        return viewRecommendation("");
    }

    /**
     * Show the recommended movie, based on the major of the active user.
     *
     * @param major Major of the active user
     * @return Page to navigate to after showing the recommendation
     */
    public final String viewRecommendation(final String major) {
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
                        "There are no movies rated, so a recommendation"
                        + "cannot be given! Take some time to write some "
                        + "reviews, and then we can try again."));
        }
        return nextPage;
    }

    /**
     * Getter for the collection of movies rated through the Reel Deal.
     * application
     *
     * @return Collection of movies rated through the Reel Deal application
     */
    public final HashMap<String, Movie> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * Getter for the collection of movies rated through the Reel Deal
     * application, as a List.
     *
     * @return Collection of movies rated through the Reel Deal application
     */
    public final List<Movie> getRatedMoviesList() {
        return new ArrayList<>(ratedMovies.values());
    }

    /**
     * Setter for the collection of movies rated through the Reel Deal
     * application.
     *
     * @param newRatedMovies Collection of movies rated through the Reel Deal
     * application
     */
    public final void setRatedMovies(
            final HashMap<String, Movie> newRatedMovies) {
        this.ratedMovies = newRatedMovies;
    }

    /**
     * Save the state of all movies to a binary file.
     */
    public final void saveState() {
        System.out.println("Saving state of users");
        MovieIO.WriteToFile(ratedMovies);
    }

    /**
     * Return to the movie hub page.
     *
     * @return Movie Hub XHTML Page URL
     */
    public final String backToMovieHub() {
        selectedMovie = new Movie();
        activeUserRating = new ReelDealRating();
        return ControlHub.MOVIE_HUB_URL;
    }
}
