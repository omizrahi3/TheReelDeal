/**
 * Handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API.
 */
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Handle for the poster pictures for the movie
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class Posters implements Serializable {

    @Expose
    private String thumbnail;
    @Expose
    private String profile;
    @Expose
    private String detailed;
    @Expose
    private String original;

    /**
     * Getter for the thumbnail picture URL for the movie
     * @return Thumbnail picture URL for the movie
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Setter for the thumbnail picture URL for the movie
     * @param thumbnail Thumbnail picture URL for the movie
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Getter for the profile picture URL for the movie
     * @return Profile picture URL for the movie
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Setter for the profile picture URL for the movie
     * @param profile Profile picture URL for the movie
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Getter for the detailed picture URL for the movie
     * @return Detailed picture URL for the movie
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     * Setter for the detailed picture URL for the movie
     * @param detailed Detailed picture URL for the movie
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     * Getter for the original picture URL for the movie
     * @return Original picture URL for the movie
     */
    public String getOriginal() {
        return original;
    }

    /**
     * Setter for the original picture URL for the movie
     * @param original Original picture URL for the movie
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thumbnail).append(profile).append(detailed).append(original).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof AbridgedCast) {
            final Posters rhs = ((Posters) other);
            equality = new EqualsBuilder().append(thumbnail, rhs.thumbnail)
                    .append(profile, rhs.profile)
                    .append(detailed, rhs.detailed)
                    .append(original, rhs.original).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
