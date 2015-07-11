/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
 */
package com.rottentomatoes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import usermanagement.User;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Generated;
import javax.faces.bean.SessionScoped;

/**
 * Stores and handles audience, critic, and Reel Deal ratings for the movie.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class Ratings implements Serializable {

    /**
     * Rounding factor of 10.
     */
    private final float roundingFactor = 10;

    /**
     * Rounding factor of .1.
     */
    private final float roundFactor = 1 / 10;

    /**
     * Critic rating of the movie.
     */
    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;

    /**
     * Critic score of the movie.
     */
    @SerializedName("critics_score")
    @Expose
    private String criticsScore;

    /**
     * Audience rating of the movie.
     */
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;

    /**
     * Audience score of the movie.
     */
    @SerializedName("audience_score")
    @Expose
    private String audienceScore;

    /**
     * Collection of Reel Deal ratings for the movie.
     */
    private List<ReelDealRating> reelDealRatings;

    /**
     * Empty constructor that initializes default data.
     */
    public Ratings() {
        reelDealRatings = new ArrayList();
    }

    /**
     * Chained constructor that sets the collection of Reel Deal Ratings.
     *
     * @param newRDRatings Collection of Reel Deal Ratings
     */
    public Ratings(final List<ReelDealRating> newRDRatings) {
        this.criticsRating = "";
        this.criticsScore = "";
        this.audienceRating = "";
        this.audienceScore = "";
        this.reelDealRatings = newRDRatings;
    }

    /**
     * Update an existing Reel Deal rating.
     * @param author Author of the rating
     * @param rating Content of the rating
     */
    public final void updateReelDealRating(
            final User author, final ReelDealRating rating) {
        for (ReelDealRating reelDealRating : reelDealRatings) {
            if (reelDealRating.getAuthor().equals(author)) {
                reelDealRating.setValue(rating.getValue());
                reelDealRating.setComment(rating.getComment());
            }
        }
    }

    /**
     * Gets the average rating over all Reel Deal users who have rated the
     * movie. Returns -1 if no ratings found.
     *
     * @return average rating
     */
    public final float getAverageRating() {
        float returnedAvg;
        if (hasRatings()) {
            float sum = 0f;
            for (ReelDealRating r : reelDealRatings) {
                sum += r.getValue();
            }
            float avg = sum / reelDealRatings.size();
            avg = (float) Math.floor(avg * roundingFactor);
            avg = avg / roundingFactor; //round down to nearest 10th
            returnedAvg = avg;

        } else {
            returnedAvg = -1;
        }
        return returnedAvg;
    }

    /**
     * Gets the average Reel Deal rating for the movie, and ensures that the
     * value returned is in a user-friendly form for readability.
     *
     * @return Average rating
     */
    public final String getDisplayableAverageRating() {
        final Float avg = getAverageRating();
        String returnedAvg;
        if (avg == -1) {
            returnedAvg = "n/a";
        } else {
            returnedAvg = avg.toString();
        }
        return returnedAvg;
    }

    /**
     * Returns whether there are reel deal ratings to view.
     *
     * @return boolean of whether there are reel deal ratings
     */
    public final boolean hasRatings() {
        return !reelDealRatings.isEmpty();
    }

    /**
     * Gets the average rating over all Reel Deal users of a specific major who
     * have rated the movie. Returns -1 if no major specific ratings found.
     *
     * @param major major
     * @return average rating of specific major
     */
    public final float getMajorSpecificRating(final String major) {
        if (hasRatings()) {
            float sum = 0f;
            int numOfRatings;
            numOfRatings = 0;
            for (ReelDealRating r : reelDealRatings) {
                if (major.equals(r.getMajor())) {
                    sum += r.getValue();
                    numOfRatings++;

                }
            }
            float avg = sum / numOfRatings;
            avg -= (avg % roundFactor);  //rounding down to nearest 0.1
            return avg;

        }
        return -1;
    }

    /**
     * Assert that the data to be displayed is readable tot he common user
     * (a.k.a. don't show default values returned by Rotten Tomatoes.
     */
    public final void assertDefaultValuesOfUndefData() {
        if (criticsRating == null) {
            criticsScore = "n/a";
        }
        if (audienceRating == null) {
            audienceScore = "n/a";
        }
    }

    /**
     * Getter for the critic rating of the movie.
     *
     * @return Critic rating of the movie
     */
    public final String getCriticsRating() {
        return criticsRating;
    }

    /**
     * Setter for the critic rating of the movie.
     *
     * @param newCriticsRating Critic rating of the movie
     */
    public final void setCriticsRating(final String newCriticsRating) {
        this.criticsRating = newCriticsRating;
    }

    /**
     * Getter for the critics score for the movie.
     *
     * @return Critics score for the movie
     */
    public final String getCriticsScore() {
        return criticsScore;
    }

    /**
     * Setter for the critics score for the movie.
     *
     * @param newCriticsScore Critics score for the movie
     */
    public final void setCriticsScore(final String newCriticsScore) {
        this.criticsScore = newCriticsScore;
    }

    /**
     * Setter for the collection of Reel Deal ratings for the movie.
     *
     * @param newRatings Collection of Reel Deal ratings for the movie
     */
    public final void setReelDealRatings(
            final List<ReelDealRating> newRatings) {
        this.reelDealRatings = newRatings;
    }

    /**
     * Getter for the collection of Reel Deal ratings for the movie.
     *
     * @return Collection of Reel Deal ratings for the movie
     */
    public final List<ReelDealRating> getReelDealRatings() {
        return reelDealRatings;
    }

    /**
     * Add a new Reel Deal rating for the movie.
     *
     * @param newestRating New Reel Deal rating for the movie
     */
    public final void addReelDealRating(final ReelDealRating newestRating) {
        reelDealRatings.add(newestRating);
    }

    /**
     * Getter for the audience rating for the movie.
     *
     * @return Audience rating for the movie
     */
    public final String getAudienceRating() {
        return audienceRating;
    }

    /**
     * Setter for the audience rating for the movie.
     *
     * @param newAudienceRating Audience rating for the movie
     */
    public final void setAudienceRating(final String newAudienceRating) {
        this.audienceRating = newAudienceRating;
    }

    /**
     * Getter for the audience score for the movie.
     *
     * @return Audience score for the movie
     */
    public final String getAudienceScore() {
        return audienceScore;
    }

    /**
     * Setter for the audience score for the movie.
     *
     * @param newAudienceScore Audience score for the movie
     */
    public final void setAudienceScore(final String newAudienceScore) {
        this.audienceScore = newAudienceScore;
    }

    /**
     * Returns the number of Reel Deal ratings the movie has.
     *
     * @return Size of the Reel Deal ratings collection
     */
    public final int getNumberOfReelDealRatings() {
        return reelDealRatings.size();
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(criticsRating)
                .append(criticsScore).append(audienceRating)
                .append(audienceScore).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof AbridgedCast) {
            final Ratings rhs = ((Ratings) other);
            equality = new EqualsBuilder()
                    .append(criticsRating, rhs.criticsRating)
                    .append(criticsScore, rhs.criticsScore)
                    .append(audienceRating, rhs.audienceRating)
                    .append(audienceScore, rhs.audienceScore).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
