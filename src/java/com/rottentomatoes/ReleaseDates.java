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
 * Handles data for all release dates of the movie
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class ReleaseDates implements Serializable {

    @Expose
    private String theater;
    @Expose
    private String dvd;

    /**
     * Getter for the theater release date
     * @return Theater release date
     */
    public String getTheater() {
        return theater;
    }

    /**
     * Setter for the theater release date
     * @param theater Theater release date
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    /**
     * Getter for the DVD release date
     * @return DVD release date
     */
    public String getDvd() {
        return dvd;
    }

    /**
     * Setter for the DVD release date
     * @param dvd DVD release date
     */
    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(theater).append(dvd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReleaseDates) == false) {
            return false;
        }
        ReleaseDates rhs = ((ReleaseDates) other);
        return new EqualsBuilder().append(theater, rhs.theater).append(dvd, rhs.dvd).isEquals();
    }

}
