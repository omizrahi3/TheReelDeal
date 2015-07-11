/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
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
 * Data transfer object which contains all data returned from a Rotten Tomatoes
 * API REST call.
 *
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class RottenTomatoesDTO implements Serializable {

    /**
     * Total amount of results returned from Rotten Tomatoes.
     */
    @Expose
    private Integer total;

    /**
     * Collection of movies.
     */
    @Expose
    private List<Movie> movies = new ArrayList<>();

    /**
     * Handle of links to other pages.
     */
    @Expose
    private APILinks links;

    /**
     * Template for the links held.
     */
    @SerializedName("link_template")
    @Expose
    private String linkTemplate;

    /**
     * Getter for the total amount of results returned from Rotten Tomatoes.
     *
     * @return Total amount of results returned from Rotten Tomatoes
     */
    public final Integer getTotal() {
        return total;
    }

    /**
     * Setter for the total amount of results returned from Rotten Tomatoes.
     *
     * @param newTotal Total amount of results returned from Rotten Tomatoes
     */
    public final void setTotal(final Integer newTotal) {
        this.total = newTotal;
    }

    /**
     * Getter for the collection of movies.
     *
     * @return Collection of movies
     */
    public final List<Movie> getMovies() {
        return movies;
    }

    /**
     * Setter for the collection of movies.
     *
     * @param newMovies Collection of movies
     */
    public final void setMovies(final List<Movie> newMovies) {
        this.movies = newMovies;
    }

    /**
     * Getter for the handle of links to other pages.
     *
     * @return Handle of links to other pages
     */
    public final APILinks getLinks() {
        return links;
    }

    /**
     * Setter for the handle of links to other pages.
     *
     * @param newLinks Handle of links to other pages
     */
    public final void setLinks(final APILinks newLinks) {
        this.links = newLinks;
    }

    /**
     * Getter for the template for the links held.
     *
     * @return Template for the links held
     */
    public final String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * Setter for the template for the links held.
     *
     * @param newTemplate Template for the links held
     */
    public final void setLinkTemplate(final String newTemplate) {
        this.linkTemplate = newTemplate;
    }

    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(total).append(movies)
                .append(links).append(linkTemplate).toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        boolean equality;
        if (other == this) {
            equality = true;
        } else if (other instanceof RottenTomatoesDTO) {
            final RottenTomatoesDTO rhs = ((RottenTomatoesDTO) other);
            equality = new EqualsBuilder().append(total, rhs.total)
                    .append(movies, rhs.movies).append(links, rhs.links)
                    .append(linkTemplate, rhs.linkTemplate).isEquals();
        } else {
            equality = false;
        }
        return equality;
    }
}
