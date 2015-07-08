/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
 */
package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import usermanagement.User;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.faces.bean.SessionScoped;

/**
 * Holds all data specific to a Movie, and provides additional logic to handle
 * formatting of its data.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class Movie implements Serializable {

    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private Integer year;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @Expose
    private String runtime;
    @SerializedName("critics_consensus")
    @Expose
    private String criticsConsensus;
    @SerializedName("release_dates")
    @Expose
    private ReleaseDates releaseDates;
    @Expose
    private Ratings ratings;
    @Expose
    private String synopsis;
    @Expose
    private Posters posters;
    @SerializedName("abridged_cast")
    @Expose
    private List<AbridgedCast> abridgedCast = new ArrayList<>();
    @SerializedName("alternate_ids")
    @Expose
    private AlternateIds alternateIds;
    @Expose
    private Links links;

    /**
     * Empty constructor that instantiates default values.
     */
    public Movie() {
        ratings = new Ratings();
        posters = new Posters();
        synopsis = "No movie found.";
        posters.setThumbnail("resources/images/BlackReel.png");
    }

    /**
     * Asserts that the data to be displayed is readable to the common user. To
     * accomplish this, all undefined data is set to default, readable values.
     */
    public final void assertDefaultValuesOfUndefData() {
        ratings.assertDefaultValuesOfUndefData();
        if (runtime == null || runtime.length() == 0) {
            runtime = "n/a";
        }
        if (synopsis == null || synopsis.length() == 0) {
            synopsis = "No synopsis currently provided by Rotten Tomatoes";
        }
        if (criticsConsensus == null || criticsConsensus.length() == 0) {
            criticsConsensus = "n/a";
        }
        ratings.assertDefaultValuesOfUndefData();
    }

    /**
     * Update an existing Reel Deal rating for a movie.
     * @param author Author of the rating
     * @param rating Content of the rating 
     */
    public final void updateMovieRating(
            final User author, final ReelDealRating rating) {
        ratings.updateReelDealRating(author, rating);
    }

    /**
     * Getter for the unique identifier of the movie.
     *
     * @return Unique identifier string of the movie
     */
    public final String getId() {
        return id;
    }

    /**
     * Setter for the unique identifier of the movie.
     *
     * @param newId Unique identifier string of the movie
     */
    public final void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Getter for the title of the movie.
     *
     * @return Title of the movie
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Setter for the title of the movie.
     *
     * @param newTitle Title of the movie
     */
    public final void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Getter for the year of the movie's release.
     *
     * @return Year of the movie's release
     */
    public final Integer getYear() {
        return year;
    }

    /**
     * Setter for the year of the movie's release.
     *
     * @param newYear Year of the movie's release
     */
    public final void setYear(final Integer newYear) {
        this.year = newYear;
    }

    /**
     * Getter for the MPAA rating of the movie.
     *
     * @return MPAA rating of the movie
     */
    public final String getMpaaRating() {
        return mpaaRating;
    }

    /**
     * Setter for the MPAA rating of the movie.
     *
     * @param newMpaaRating MPAA rating of the movie
     */
    public final void setMpaaRating(final String newMpaaRating) {
        this.mpaaRating = newMpaaRating;
    }

    /**
     * Getter for the runtime of the movie.
     *
     * @return Runtime of the movie
     */
    public final String getRuntime() {
        return runtime;
    }

    /**
     * Setter for the runtime of the movie.
     *
     * @param newRuntime Runtime of the movie
     */
    public final void setRuntime(final String newRuntime) {
        if (runtime.length() == 0) {
            this.runtime = "n/a";
        } else {
            this.runtime = newRuntime;
        }
    }

    /**
     * Getter for a short snippet of the critic consensus for the movie.
     *
     * @return Snippet of the critic consensus for the movie
     */
    public final String getCriticsConsensus() {
        return criticsConsensus;
    }

    /**
     * Setter for a short snippet of the critic consensus for the movie.
     *
     * @param newCriticsConsensus Snippet of the critic consensus for the movie
     */
    public final void setCriticsConsensus(final String newCriticsConsensus) {
        this.criticsConsensus = newCriticsConsensus;
    }

    /**
     * Getter for the handle of the release dates for the movie.
     *
     * @return Handle of the release dates for the movie
     */
    public final ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    /**
     * Setter for the handle of the release dates for the movie.
     *
     * @param newReleaseDates Handle of the release dates for the movie
     */
    public final void setReleaseDates(final ReleaseDates newReleaseDates) {
        this.releaseDates = newReleaseDates;
    }

    /**
     * Getter for the handle for the ratings of the movie.
     *
     * @return Handle for the ratings of the movie
     */
    public final Ratings getRatings() {
        return ratings;
    }

    /**
     * Setter for the handle for the ratings of the movie.
     *
     * @param newRatings Handle for the ratings of the movie
     */
    public final void setRatings(final Ratings newRatings) {
        this.ratings = newRatings;
    }

    /**
     * Getter for the summary of the movie.
     *
     * @return Summary of the movie
     */
    public final String getSynopsis() {
        return synopsis;
    }

    /**
     * Setter for the summary of the movie.
     *
     * @param newSynopsis Summary of the movie
     */
    public final void setSynopsis(final String newSynopsis) {
        this.synopsis = newSynopsis;
    }

    /**
     * Getter for the handle for the poster pictures of the movie.
     *
     * @return Handle for the poster pictures of the movie
     */
    public final Posters getPosters() {
        return posters;
    }

    /**
     * Setter for the handle for the poster pictures of the movie.
     *
     * @param newPosters Handle for the poster pictures of the movie
     */
    public final void setPosters(final Posters newPosters) {
        this.posters = newPosters;
    }

    /**
     * Getter for the collection of cast members for the movie.
     *
     * @return Collection of cast members for the movie
     */
    public final List<AbridgedCast> getAbridgedCast() {
        return abridgedCast;
    }

    /**
     * Setter for the collection of cast members for the movie.
     *
     * @param newAbridgedCast Collection of cast members for the movie
     */
    public final void setAbridgedCast(
            final List<AbridgedCast> newAbridgedCast) {
        this.abridgedCast = newAbridgedCast;
    }

    /**
     * Getter for the handle of alternate identifiers for the movie.
     *
     * @return Handle of alternate identifiers for the movie
     */
    public final AlternateIds getAlternateIds() {
        return alternateIds;
    }

    /**
     * Setter for the handle of alternate identifiers for the movie.
     *
     * @param newAltIds Handle of alternate identifiers for the movie
     */
    public final void setAlternateIds(final AlternateIds newAltIds) {
        this.alternateIds = newAltIds;
    }

    /**
     * Getter for the handle of links for the movie.
     *
     * @return Handle of links for the movie
     */
    public final Links getLinks() {
        return links;
    }

    /**
     * Setter for the handle of links for the movie.
     *
     * @param newLinks Handle of links for the movie
     */
    public final void setLinks(final Links newLinks) {
        this.links = newLinks;
    }

    /**
     * Gets the average rating over all Reel Deal users who have rated the
     * movie. Returns -1 if the movie does not have ratings.
     *
     * @return average rating or -1
     */
    public final String getAverageRating() {
        Float rating = ratings.getAverageRating();
        String ratingToReturn;
        if (rating == -1f) {
            ratingToReturn = "n/a";
        } else {
            ratingToReturn = rating.toString();
        }
        return ratingToReturn;
    }

    /**
     * Gets the average rating over all Reel Deal users of a specific major who
     * have rated the movie. Returns -1 if no major specific ratings found.
     *
     * @param major Major to sort by for ther rating
     * @return average rating of specific major
     */
    public final float getMajorSpecificRating(final String major) {
        return ratings.getMajorSpecificRating(major);
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(year)
                .append(mpaaRating).append(runtime).append(criticsConsensus)
                .append(releaseDates).append(ratings).append(synopsis)
                .append(posters).append(abridgedCast).append(alternateIds)
                .append(links).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof AbridgedCast) {
            final Movie rhs = ((Movie) other);
            equality = new EqualsBuilder().append(id, rhs.id)
                    .append(title, rhs.title).append(year, rhs.year)
                    .append(mpaaRating, rhs.mpaaRating)
                    .append(runtime, rhs.runtime)
                    .append(criticsConsensus, rhs.criticsConsensus)
                    .append(releaseDates, rhs.releaseDates)
                    .append(ratings, rhs.ratings)
                    .append(synopsis, rhs.synopsis)
                    .append(posters, rhs.posters)
                    .append(abridgedCast, rhs.abridgedCast)
                    .append(alternateIds, rhs.alternateIds)
                    .append(links, rhs.links).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }

    /**
     * Getter for the movie's ReelDeal ratings.
     *
     * @return Ratings from the ReelDeal web application
     */
    public final List<ReelDealRating> getReelDealRatings() {
        return ratings.getReelDealRatings();
    }

    /**
     * Setter for the movie's ReelDeal Rating.
     *
     * @param reelDealRatings Ratings
     */
    public final void setReelDealRatings(
            final List<ReelDealRating> reelDealRatings) {
        ratings.setReelDealRatings(reelDealRatings);
    }

    /**
     * Adds a new Reel Deal rating to the ratings handle for the movie.
     *
     * @param newRating new ReelDeal rating
     */
    public final void addReelDealRating(final ReelDealRating newRating) {
        ratings.addReelDealRating(newRating);
    }
}
