
package com.rottentomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links {

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
     * 
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    public Links withSelf(String self) {
        this.self = self;
        return this;
    }

    /**
     * 
     * @return
     *     The alternate
     */
    public String getAlternate() {
        return alternate;
    }

    /**
     * 
     * @param alternate
     *     The alternate
     */
    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    public Links withAlternate(String alternate) {
        this.alternate = alternate;
        return this;
    }

    /**
     * 
     * @return
     *     The cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * 
     * @param cast
     *     The cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

    public Links withCast(String cast) {
        this.cast = cast;
        return this;
    }

    /**
     * 
     * @return
     *     The reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * 
     * @param reviews
     *     The reviews
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Links withReviews(String reviews) {
        this.reviews = reviews;
        return this;
    }

    /**
     * 
     * @return
     *     The similar
     */
    public String getSimilar() {
        return similar;
    }

    /**
     * 
     * @param similar
     *     The similar
     */
    public void setSimilar(String similar) {
        this.similar = similar;
    }

    public Links withSimilar(String similar) {
        this.similar = similar;
        return this;
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
