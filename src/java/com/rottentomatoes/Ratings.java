
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;

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
    
    public Ratings() {
        reelDealRatings = new ArrayList();
    }
    
    public Ratings(List<ReelDealRating> reelDealRatings) {
        this.criticsRating = "";
        this.criticsScore = "";
        this.audienceRating = "";
        this.audienceScore = "";
        this.reelDealRatings = reelDealRatings;
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
     * 
     * @return
     *     The criticsRating
     */
    public String getCriticsRating() {
        return criticsRating;
    }

    /**
     * 
     * @param criticsRating
     *     The critics_rating
     */
    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    /**
     * 
     * @return
     *     The criticsScore
     */
    public String getCriticsScore() {
        return criticsScore;
    }

    /**
     * 
     * @param criticsScore
     *     The critics_score
     */
    public void setCriticsScore(String criticsScore) {
        this.criticsScore = criticsScore;
    }

    public void setReelDealRatings(List<ReelDealRating> reelDealRatings) {
        this.reelDealRatings = reelDealRatings;
    }

    public List<ReelDealRating> getReelDealRatings() {
        return reelDealRatings;
    }
    
    public void addReelDealRating(ReelDealRating newRating) {
        reelDealRatings.add(newRating);
    }

    /**
     * 
     * @return
     *     The audienceRating
     */
    public String getAudienceRating() {
        return audienceRating;
    }

    /**
     * 
     * @param audienceRating
     *     The audience_rating
     */
    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    /**
     * 
     * @return
     *     The audienceScore
     */
    public String getAudienceScore() {
        return audienceScore;
    }

    /**
     * 
     * @param audienceScore
     *     The audience_score
     */
    public void setAudienceScore(String audienceScore) {
        this.audienceScore = audienceScore;
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
