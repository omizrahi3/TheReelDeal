
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Ratings {

    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;
    @SerializedName("critics_score")
    @Expose
    private int criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;
    @SerializedName("audience_score")
    @Expose
    private int audienceScore;

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

    public Ratings withCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
        return this;
    }

    /**
     * 
     * @return
     *     The criticsScore
     */
    public int getCriticsScore() {
        return criticsScore;
    }

    /**
     * 
     * @param criticsScore
     *     The critics_score
     */
    public void setCriticsScore(int criticsScore) {
        this.criticsScore = criticsScore;
    }

    public Ratings withCriticsScore(int criticsScore) {
        this.criticsScore = criticsScore;
        return this;
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

    public Ratings withAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
        return this;
    }

    /**
     * 
     * @return
     *     The audienceScore
     */
    public int getAudienceScore() {
        return audienceScore;
    }

    /**
     * 
     * @param audienceScore
     *     The audience_score
     */
    public void setAudienceScore(int audienceScore) {
        this.audienceScore = audienceScore;
    }

    public Ratings withAudienceScore(int audienceScore) {
        this.audienceScore = audienceScore;
        return this;
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