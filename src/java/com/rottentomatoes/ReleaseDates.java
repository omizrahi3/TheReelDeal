
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ReleaseDates {

    @Expose
    private String theater;
    @Expose
    private String dvd;

    /**
     * 
     * @return
     *     The theater
     */
    public String getTheater() {
        return theater;
    }

    /**
     * 
     * @param theater
     *     The theater
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    /**
     * 
     * @return
     *     The dvd
     */
    public String getDvd() {
        return dvd;
    }

    /**
     * 
     * @param dvd
     *     The dvd
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
