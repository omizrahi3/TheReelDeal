/**
 * The com.rottentomatoes package handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API
 */
package com.rottentomatoes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import UserManagement.User;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Generated;
import javax.faces.bean.SessionScoped;

/**
 * Stores and handles audience, critic, and Reel Deal ratings for the movie
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class Ratings implements Serializable {

    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;
    @SerializedName("critics_score")
    @Expose
    private String criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;
    @SerializedName("audience_score")
    @Expose
    private String audienceScore;
    private List<ReelDealRating> reelDealRatings;
    
    /**
     * Empty constructor that initializes default data
     */
    public Ratings() {
        reelDealRatings = new ArrayList();
    }
    
    /**
     * Chained constructor that sets the collection of Reel Deal Ratings
     * @param reelDealRatings Collection of Reel Deal Ratings
     */
    public Ratings(List<ReelDealRating> reelDealRatings) {
        this.criticsRating = "";
        this.criticsScore = "";
        this.audienceRating = "";
        this.audienceScore = "";
        this.reelDealRatings = reelDealRatings;
    }
    
    public void updateReelDealRating(User author, ReelDealRating rating) {
        for (int i = 0; i < reelDealRatings.size(); i++) {
            if (reelDealRatings.get(i).getAuthor().equals(author)) {
                reelDealRatings.get(i).setValue(rating.getValue());
                reelDealRatings.get(i).setComment(rating.getComment());
            }
        }
    }
    
    /**
     * Gets the average rating over all Reel Deal users who have rated the movie.
     * Returns -1 if no ratings found.
     * 
     * @return average rating
     */
    public float getAverageRating() {
        if (hasRatings()) {
            float sum = 0f;
            for (ReelDealRating r : reelDealRatings) {
                sum += r.getValue();
            }
            float avg = sum / reelDealRatings.size();
            avg -= (avg % 0.1);             //rounding down to nearest 0.1
            return avg;
            
        }
        return -1;
    }
    
    /**
     * Gets the average Reel Deal rating for the movie, and ensures that 
     * the value returned is in a user-friendly form for readability
     * @return 
     */
    public String getDisplayableAverageRating() {
        Float avg = getAverageRating();
        return (avg == -1 ? "n/a" : avg.toString());
    }
    
    /**
     * Returns whether there are reel deal ratings to view
     * @return boolean of whether there are reel deal ratings
     */
    public boolean hasRatings() {
        return reelDealRatings.size() > 0;
    }

    /**
     * Gets the average rating over all Reel Deal users of a specific major
     * who have rated the movie. Returns -1 if no major specific ratings found.
     * @param major major
     * @return average rating of specific major
     */
    public float getMajorSpecificRating(String major) {
        if (hasRatings()) {
            float sum = 0f;
            int numOfRatings = 0;
            for (ReelDealRating r : reelDealRatings) {
                if (major.equals(r.getMajor())) {
                    sum += r.getValue();
                    numOfRatings++;
                    
                }
            }
            float avg = sum / numOfRatings;
            avg -= (avg % 0.1);             //rounding down to nearest 0.1
            return avg;
            
        }
        return -1;
    }
    
    /**
     * Assert that the data to be displayed is readable tot he common user
     * (a.k.a. don't show default values returned by Rotten Tomatoes
     */
    public void assertDefaultValuesOfUndefData() {
        if (criticsRating == null) {
            criticsScore = "n/a";
        }
        if (audienceRating == null) {
            audienceScore = "n/a";
        }
        
    }
    
   /**
    * Getter for the critic rating of the movie
    * @return Critic rating of the movie
    */
    public String getCriticsRating() {
        return criticsRating;
    }

   /**
    * Setter for the critic rating of the movie
    * @param criticsRating Critic rating of the movie
    */
    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    /**
     * Getter for the critics score for the movie
     * @return Critics score for the movie
     */
    public String getCriticsScore() {
        return criticsScore;
    }

    /**
     * Setter for the critics score for the movie
     * @param criticsScore Critics score for the movie
     */
    public void setCriticsScore(String criticsScore) {
        this.criticsScore = criticsScore;
    }

    /**
     * Setter for the collection of Reel Deal ratings for the movie
     * @param reelDealRatings Collection of Reel Deal ratings for the movie
     */
    public void setReelDealRatings(List<ReelDealRating> reelDealRatings) {
        this.reelDealRatings = reelDealRatings;
    }

    /**
     * Getter for the collection of Reel Deal ratings for the movie
     * @return Collection of Reel Deal ratings for the movie
     */
    public List<ReelDealRating> getReelDealRatings() {
        return reelDealRatings;
    }
    
    /**
     * Add a new Reel Deal rating for the movie
     * @param newRating New Reel Deal rating for the movie
     */
    public void addReelDealRating(ReelDealRating newRating) {
        reelDealRatings.add(newRating);
    }

    /**
     * Getter for the audience rating for the movie
     * @return Audience rating for the movie
     */
    public String getAudienceRating() {
        return audienceRating;
    }

    /**
     * Setter for the audience rating for the movie
     * @param audienceRating Audience rating for the movie
     */
    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    /**
     * Getter for the audience score for the movie
     * @return Audience score for the movie
     */
    public String getAudienceScore() {
        return audienceScore;
    }

    /**
     * Setter for the audience score for the movie
     * @param audienceScore Audience score for the movie
     */
    public void setAudienceScore(String audienceScore) {
        this.audienceScore = audienceScore;
    }
    
    /**
     * Returns the number of Reel Deal ratings the movie has
     * @return Size of the Reel Deal ratings collection
     */
    public int getNumberOfReelDealRatings() {
        return reelDealRatings.size();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(criticsRating).append(criticsScore).append(audienceRating).append(audienceScore).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ratings) == false) {
            return false;
        }
        Ratings rhs = ((Ratings) other);
        return new EqualsBuilder().append(criticsRating, rhs.criticsRating).append(criticsScore, rhs.criticsScore).append(audienceRating, rhs.audienceRating).append(audienceScore, rhs.audienceScore).isEquals();
    }

}