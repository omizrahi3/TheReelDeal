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
 * Holds links to page for more movies returned by the Rotten Tomatoes API.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class APILinks implements Serializable {

    /**
     * The current page of movies.
     */
    @Expose
    private String self;

    /**
     * The next page of movies.
     */
    @Expose
    private String next;

    /**
     * Getter for the link to the current page of movies.
     *
     * @return Link to the current page of movies
     */
    public final String getSelf() {
        return self;
    }

    /**
     * Setter for the link to the current page of movies.
     *
     * @param newSelf Link to the current page of movies
     */
    public final void setSelf(final String newSelf) {
        this.self = newSelf;
    }

    /**
     * Getter for the link to the next page of movies.
     *
     * @return Link to the next page of movies
     */
    public final String getNext() {
        return next;
    }

    /**
     * Setter for the link to the next page of movies.
     *
     * @param newNext Link to the next page of movies
     */
    public final void setNext(final String newNext) {
        this.next = newNext;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(self).append(next).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof APILinks) {
            final APILinks rhs = ((APILinks) other);
            equality = new EqualsBuilder().append(self, rhs.self)
                    .append(next, rhs.next).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
