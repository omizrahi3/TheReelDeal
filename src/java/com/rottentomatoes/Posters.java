/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
 */
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Handle for the poster pictures for the movie.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class Posters implements Serializable {

    /**
     * Thumbnail picture URL for the movie.
     */
    @Expose
    private String thumbnail;

    /**
     * Profile picture URL for the movie.
     */
    @Expose
    private String profile;

    /**
     * Detailed picture URL for the movie.
     */
    @Expose
    private String detailed;

    /**
     * Original picture URL for the movie.
     */
    @Expose
    private String original;

    /**
     * Getter for the thumbnail picture URL for the movie.
     *
     * @return Thumbnail picture URL for the movie
     */
    public final String getThumbnail() {
        return thumbnail;
    }

    /**
     * Setter for the thumbnail picture URL for the movie.
     *
     * @param newThumbnail Thumbnail picture URL for the movie
     */
    public final void setThumbnail(final String newThumbnail) {
        this.thumbnail = newThumbnail;
    }

    /**
     * Getter for the profile picture URL for the movie.
     *
     * @return Profile picture URL for the movie
     */
    public final String getProfile() {
        return profile;
    }

    /**
     * Setter for the profile picture URL for the movie.
     *
     * @param newProfile Profile picture URL for the movie
     */
    public final void setProfile(final String newProfile) {
        this.profile = newProfile;
    }

    /**
     * Getter for the detailed picture URL for the movie.
     *
     * @return Detailed picture URL for the movie
     */
    public final String getDetailed() {
        return detailed;
    }

    /**
     * Setter for the detailed picture URL for the movie.
     *
     * @param newDetailed Detailed picture URL for the movie
     */
    public final void setDetailed(final String newDetailed) {
        this.detailed = newDetailed;
    }

    /**
     * Getter for the original picture URL for the movie.
     *
     * @return Original picture URL for the movie
     */
    public final String getOriginal() {
        return original;
    }

    /**
     * Setter for the original picture URL for the movie.
     *
     * @param newOriginal Original picture URL for the movie
     */
    public final void setOriginal(final String newOriginal) {
        this.original = newOriginal;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(thumbnail)
                .append(profile).append(detailed)
                .append(original).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof Posters) {
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
