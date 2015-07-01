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
 * Holds links to page for more movies returned by the 
 * Rotten Tomatoes API
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class Links_ implements Serializable {

    @Expose
    private String self;
    @Expose
    private String next;

    /**
     * Getter for the link to the current page of movies
     * @return Link to the current page of movies
     */
    public String getSelf() {
        return self;
    }

    /**
     * Setter for the link to the current page of movies
     * @param self Link to the current page of movies
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * Getter for the link to the next page of movies
     * @return Link to the next page of movies
     */
    public String getNext() {
        return next;
    }

    /**
     * Setter for the link to the next page of movies
     * @param next Link to the next page of movies
     */
    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(next).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links_) == false) {
            return false;
        }
        Links_ rhs = ((Links_) other);
        return new EqualsBuilder().append(self, rhs.self).append(next, rhs.next).isEquals();
    }

}
