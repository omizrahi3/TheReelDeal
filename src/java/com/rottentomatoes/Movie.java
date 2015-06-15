
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
public class Movie {

    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private int year;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @Expose
    private int runtime;
    @SerializedName("critics_consensus")
    @Expose
    private String criticsConsensus;
    @SerializedName("release_dates")
    @Expose
    private ReleaseDates releaseDates;
    @Expose
    private Ratings ratings;
    @Expose
    private String synopsis;
    @Expose
    private Posters posters;
    @SerializedName("abridged_cast")
    @Expose
    private List<AbridgedCast> abridgedCast = new ArrayList<AbridgedCast>();
    @SerializedName("alternate_ids")
    @Expose
    private AlternateIds alternateIds;
    @Expose
    private Links links;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Movie withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Movie withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 
     * @return
     *     The year
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(int year) {
        this.year = year;
    }

    public Movie withYear(int year) {
        this.year = year;
        return this;
    }

    /**
     * 
     * @return
     *     The mpaaRating
     */
    public String getMpaaRating() {
        return mpaaRating;
    }

    /**
     * 
     * @param mpaaRating
     *     The mpaa_rating
     */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Movie withMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
        return this;
    }

    /**
     * 
     * @return
     *     The runtime
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * 
     * @param runtime
     *     The runtime
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Movie withRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }

    /**
     * 
     * @return
     *     The criticsConsensus
     */
    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    /**
     * 
     * @param criticsConsensus
     *     The critics_consensus
     */
    public void setCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
    }

    public Movie withCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
        return this;
    }

    /**
     * 
     * @return
     *     The releaseDates
     */
    public ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    /**
     * 
     * @param releaseDates
     *     The release_dates
     */
    public void setReleaseDates(ReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
    }

    public Movie withReleaseDates(ReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
        return this;
    }

    /**
     * 
     * @return
     *     The ratings
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * 
     * @param ratings
     *     The ratings
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public Movie withRatings(Ratings ratings) {
        this.ratings = ratings;
        return this;
    }

    /**
     * 
     * @return
     *     The synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * 
     * @param synopsis
     *     The synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Movie withSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    /**
     * 
     * @return
     *     The posters
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * 
     * @param posters
     *     The posters
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    public Movie withPosters(Posters posters) {
        this.posters = posters;
        return this;
    }

    /**
     * 
     * @return
     *     The abridgedCast
     */
    public List<AbridgedCast> getAbridgedCast() {
        return abridgedCast;
    }

    /**
     * 
     * @param abridgedCast
     *     The abridged_cast
     */
    public void setAbridgedCast(List<AbridgedCast> abridgedCast) {
        this.abridgedCast = abridgedCast;
    }

    public Movie withAbridgedCast(List<AbridgedCast> abridgedCast) {
        this.abridgedCast = abridgedCast;
        return this;
    }

    /**
     * 
     * @return
     *     The alternateIds
     */
    public AlternateIds getAlternateIds() {
        return alternateIds;
    }

    /**
     * 
     * @param alternateIds
     *     The alternate_ids
     */
    public void setAlternateIds(AlternateIds alternateIds) {
        this.alternateIds = alternateIds;
    }

    public Movie withAlternateIds(AlternateIds alternateIds) {
        this.alternateIds = alternateIds;
        return this;
    }

    /**
     * 
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    public Movie withLinks(Links links) {
        this.links = links;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(year).append(mpaaRating).append(runtime).append(criticsConsensus).append(releaseDates).append(ratings).append(synopsis).append(posters).append(abridgedCast).append(alternateIds).append(links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Movie) == false) {
            return false;
        }
        Movie rhs = ((Movie) other);
        return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(year, rhs.year).append(mpaaRating, rhs.mpaaRating).append(runtime, rhs.runtime).append(criticsConsensus, rhs.criticsConsensus).append(releaseDates, rhs.releaseDates).append(ratings, rhs.ratings).append(synopsis, rhs.synopsis).append(posters, rhs.posters).append(abridgedCast, rhs.abridgedCast).append(alternateIds, rhs.alternateIds).append(links, rhs.links).isEquals();
    }

}
