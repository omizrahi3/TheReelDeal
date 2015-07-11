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
 * Provides links to various other web pages, which provide additional
 * information about the movie.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class Links implements Serializable {

    /**
     * Main page of the movie.
     */
    @Expose
    private String self;

    /**
     * Alternate page for the movie.
     */
    @Expose
    private String alternate;

    /**
     * Cast page for the movie.
     */
    @Expose
    private String cast;

    /**
     * Review page for the movie.
     */
    @Expose
    private String reviews;

    /**
     * Page with similar movie recommendations.
     */
    @Expose
    private String similar;

    /**
     * Getter for the main page of the movie.
     *
     * @return Main page of the movie
     */
    public final String getSelf() {
        return self;
    }

    /**
     * Setter for the main page of the movie.
     *
     * @param newSelf Main page of the movie
     */
    public final void setSelf(final String newSelf) {
        this.self = newSelf;
    }

    /**
     * Getter for an alternate page for the movie.
     *
     * @return Alternate page for the movie
     */
    public final String getAlternate() {
        return alternate;
    }

    /**
     * Setter for an alternate page for the movie.
     *
     * @param newAlternate Alternate page for the movie
     */
    public final void setAlternate(final String newAlternate) {
        this.alternate = newAlternate;
    }

    /**
     * Getter for the cast page for the movie.
     *
     * @return Cast page for the movie
     */
    public final String getCast() {
        return cast;
    }

    /**
     * Setter for the cast page for the movie.
     *
     * @param newCast Cast page for the movie
     */
    public final void setCast(final String newCast) {
        this.cast = newCast;
    }

    /**
     * Getter for the reviews page for the movie.
     *
     * @return Reviews page for the movie
     */
    public final String getReviews() {
        return reviews;
    }

    /**
     * Setter for the reviews page for the movie.
     *
     * @param newReviews Reviews page for the movie
     */
    public final void setReviews(final String newReviews) {
        this.reviews = newReviews;
    }

    /**
     * Getter for the page with similar movie recommendations.
     *
     * @return Page with similar movie recommendations
     */
    public final String getSimilar() {
        return similar;
    }

    /**
     * Setter for the page with similar movie recommendations.
     *
     * @param newSimilar Page with similar movie recommendations
     */
    public final void setSimilar(final String newSimilar) {
        this.similar = newSimilar;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(self).append(alternate)
                .append(cast).append(reviews).append(similar).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof AbridgedCast) {
            final Links rhs = ((Links) other);
            equality = new EqualsBuilder().append(self, rhs.self)
                    .append(alternate, rhs.alternate).append(cast, rhs.cast)
                    .append(reviews, rhs.reviews).append(similar, rhs.similar)
                    .isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
