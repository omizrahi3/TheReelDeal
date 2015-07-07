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
 * Handles the name of a cast member of a specific movie. Usually,
 * an object will hold a collection of AbridgeCast
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
public class AbridgedCast implements Serializable {

    /**
     * The name of the cast member.
     */
    @Expose
    private String name;

    /**
     * The unique identifier of the cast member.
     */
    @Expose
    private String id;

    /**
     * Getter for the name of a specific cast member for a movie.
     * @return The cast member's name
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter for the name of a specific cast member for a movie.
     * @param castMember The cast member's name
     */
    public final void setName(final String castMember) {
        name = castMember;
    }

    /**
     * Getter for the unique identifier of the cast member.
     * @return Unique identifier string of the cast member
     */
    public final String getId() {
        return id;
    }

    /**
     * Setter for the unique identifier of the cast member.
     * @param identification Unique identifier of the cast member
     */
    public final void setId(final String identification) {
        id = identification;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(name).append(id).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AbridgedCast)) {
            return false;
        }
        AbridgedCast rhs = ((AbridgedCast) other);
        return new EqualsBuilder().append(name, rhs.name)
                .append(id, rhs.id).isEquals();
    }

}
