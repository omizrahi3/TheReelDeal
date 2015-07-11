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
 * Handles data for all release dates of the movie.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class ReleaseDates implements Serializable {

    /**
     * Theater release date.
     */
    @Expose
    private String theater;

    /**
     * DVD release date.
     */
    @Expose
    private String dvd;

    /**
     * Getter for the theater release date.
     *
     * @return Theater release date
     */
    public final String getTheater() {
        return theater;
    }

    /**
     * Setter for the theater release date.
     *
     * @param newTheater Theater release date
     */
    public final void setTheater(final String newTheater) {
        this.theater = newTheater;
    }

    /**
     * Getter for the DVD release date.
     *
     * @return DVD release date
     */
    public final String getDvd() {
        return dvd;
    }

    /**
     * Setter for the DVD release date.
     *
     * @param newDvd DVD release date
     */
    public final void setDvd(final String newDvd) {
        this.dvd = newDvd;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(theater).append(dvd).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof AbridgedCast) {
            final ReleaseDates rhs = ((ReleaseDates) other);
            equality = new EqualsBuilder().append(theater, rhs.theater)
                    .append(dvd, rhs.dvd).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
