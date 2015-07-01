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
 * Handles the name of a cast member of a specific movie. Usually,
 * an object will hold a collection of AbridgeCast
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class AbridgedCast implements Serializable {

    @Expose
    private String name;
    @Expose
    private String id;

    /**
     * Getter for the name of a specific cast member for a movie
     * @return The cast member's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of a specific cast member for a movie
     * @param name The cast member's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the unique identifier of the cast member
     * @return Unique identifier string of the cast member
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the unique identifier of the cast member
     * @param id Unique identifier of the cast member
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AbridgedCast) == false) {
            return false;
        }
        AbridgedCast rhs = ((AbridgedCast) other);
        return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).isEquals();
    }

}
