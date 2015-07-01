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
 * Contains data members for alternate ID's for a movie.
 * Currently, the only alternative id is that of IMDB
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class AlternateIds implements Serializable {

    @Expose
    private String imdb;

    /**
     * Getter for the IMDB identifier of a movie
     * @return IMDB identifier string of a movie
     */
    public String getImdb() {
        return imdb;
    }

    /**
     * Setter for the IMDB identifier of a movie
     * @param imdb IMDB identifier string of a movie
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imdb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlternateIds) == false) {
            return false;
        }
        AlternateIds rhs = ((AlternateIds) other);
        return new EqualsBuilder().append(imdb, rhs.imdb).isEquals();
    }

}
