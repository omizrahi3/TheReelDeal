
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import gatech.cs2340.team7.ReelDealRating;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Ratings {

    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;
    @SerializedName("critics_score")
    @Expose
    private Integer criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;
    @SerializedName("audience_score")
    @Expose
    private Integer audienceScore;
    
    private List<ReelDealRating> reelDealRatings;
    
    public Ratings(){};
    
    public Ratings(String criticsRating, Integer criticsScore, String audienceRating,
            Integer audienceScore, List<ReelDealRating> reelDealRatings) {
        this.criticsRating = criticsRating;
        this.criticsScore = criticsScore;
        this.audienceRating = audienceRating;
        this.audienceScore = audienceScore;
        this.reelDealRatings = reelDealRatings;
        
    }
    
    /**
     * Gets the average rating over all Reel Deel users who have rated the movie.
     * Returns -1 if no ratings found.
     * 
     * @return average rating
     */
    public float getAverageRating() {
        float sum = 0;
        int numberOfRatings = 0;
        for (ReelDealRating r : reelDealRatings) {
            sum += r.getValue();
            numberOfRatings++;
        }
        
        if (numberOfRatings <= 0) {
            return -1f;
        } else {
            return sum / numberOfRatings;
        }
    }
    
    /**
     * Gets the average rating over all Reel Deel users of a specific major
     * who have rated the movie. Returns -1 if no major specific ratings found.
     * 
     * @return average rating of specific major
     */
    public float getMajorSpecificRating(String major) {
        float sum = 0;
        int numberOfRatings = 0;
        for (ReelDealRating r : reelDealRatings) {
            if (major.equals(r.getMajor())) {
                sum += r.getValue();
                numberOfRatings++;
            }
        }
        
        if (numberOfRatings <= 0) {
            return -1f;
        } else {
            return sum / numberOfRatings;
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
    public Integer getCriticsScore() {
        return criticsScore;
    }

    /**
     * 
     * @param criticsScore
     *     The critics_score
     */
    public void setCriticsScore(Integer criticsScore) {
        this.criticsScore = criticsScore;
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
    public Integer getAudienceScore() {
        return audienceScore;
    }

    /**
     * 
     * @param audienceScore
     *     The audience_score
     */
    public void setAudienceScore(Integer audienceScore) {
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
