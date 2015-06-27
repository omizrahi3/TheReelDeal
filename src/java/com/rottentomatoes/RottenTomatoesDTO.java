
package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class RottenTomatoesDTO {

    @Expose
    private Integer total;
    @Expose
    private List<Movie> movies = new ArrayList<>();
    @Expose
    private Links_ links;
    @SerializedName("link_template")
    @Expose
    private String linkTemplate;

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * 
     * @param movies
     *     The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * 
     * @return
     *     The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The linkTemplate
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * 
     * @param linkTemplate
     *     The link_template
     */
    public void setLinkTemplate(String linkTemplate) {
        this.linkTemplate = linkTemplate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(movies).append(links).append(linkTemplate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RottenTomatoesDTO) == false) {
            return false;
        }
        RottenTomatoesDTO rhs = ((RottenTomatoesDTO) other);
        return new EqualsBuilder().append(total, rhs.total).append(movies, rhs.movies).append(links, rhs.links).append(linkTemplate, rhs.linkTemplate).isEquals();
    }

}
