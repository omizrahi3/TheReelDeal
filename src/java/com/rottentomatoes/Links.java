/**
 * The com.rottentomatoes package handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API
 */
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Provides links to various other web pages, which provide
 * additional information about the movie
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class Links implements Serializable {

    @Expose
    private String self;
    @Expose
    private String alternate;
    @Expose
    private String cast;
    @Expose
    private String reviews;
    @Expose
    private String similar;

    /**
     * Getter for the main page of the movie
     * @return Main page of the movie
     */
    public String getSelf() {
        return self;
    }

    /**
     * Setter for the main page of the movie
     * @param self Main page of the movie
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * Getter for an alternate page for the movie
     * @return Alternate page for the movie
     */
    public String getAlternate() {
        return alternate;
    }

   /**
    * Setter for an alternate page for the movie
    * @param alternate Alternate page for the movie
    */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    /**
     * Getter for the cast page for the movie
     * @return Cast page for the movie
     */
    public String getCast() {
        return cast;
    }

    /**
     * Setter for the cast page for the movie
     * @param cast Cast page for the movie
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    /**
     * Getter for the reviews page for the movie
     * @return Reviews page for the movie
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * Setter for the reviews page for the movie
     * @param reviews Reviews page for the movie
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     * Getter for the page with similar movie recommendations
     * @return Page with similar movie recommendations
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * Setter for the page with similar movie recommendations
     * @param similar Page with similar movie recommendations
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(alternate).append(cast).append(reviews).append(similar).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(alternate, rhs.alternate).append(cast, rhs.cast).append(reviews, rhs.reviews).append(similar, rhs.similar).isEquals();
    }

}
