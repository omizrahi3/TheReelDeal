/**
 * Handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API.
 */
package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data transfer object which contains all data returned from a
 * Rotten Tomatoes API REST call
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class RottenTomatoesDTO implements Serializable {

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
     * Getter for the total amount of results returned from Rotten Tomatoes
     * @return Total amount of results returned from Rotten Tomatoes
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Setter for the total amount of results returned from Rotten Tomatoes
     * @param total Total amount of results returned from Rotten Tomatoes
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Getter for the collection of movies
     * @return Collection of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Setter for the collection of movies
     * @param movies Collection of movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Getter for the handle of links to other pages
     * @return Handle of links to other pages
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * Setter for the handle of links to other pages
     * @param links Handle of links to other pages
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     * Getter for the template for the links held
     * @return Template for the links held
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * Setter for the template for the links held
     * @param linkTemplate Template for the links held
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
