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
    private Integer year;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @Expose
    private String runtime;
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
    private List<AbridgedCast> abridgedCast = new ArrayList<>();
    @SerializedName("alternate_ids")
    @Expose
    private AlternateIds alternateIds;
    @Expose
    private Links links;


    
    public Movie() {
        ratings = new Ratings();
    }
    
    /**
     * Assert that the data to be displayed is readable to the common user
     * (a.k.a. don't show default values returned by Rotten Tomatoes
     */
    public void assertDefaultValuesOfUndefData() {
        ratings.assertDefaultValuesOfUndefData();
        if (runtime == null || runtime.length() == 0) {
            runtime = "n/a";
        }
        if (synopsis == null || synopsis.length() == 0) {
            synopsis = "No synopsis currently provided by Rotten Tomatoes";
        }
        if (criticsConsensus == null || criticsConsensus.length() == 0) {
            criticsConsensus = "n/a";
        }
    }
    
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

    /**
     * 
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
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

    /**
     * 
     * @return
     *     The runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * 
     * @param runtime
     *     The runtime
     */
    public void setRuntime(String runtime) {
        System.out.println("Hello from setRuntime");
        if (runtime.length() == 0) {
            this.runtime = "n/a";
        } else {
            this.runtime = runtime;
        }
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
    
    /**
     * Gets the average rating over all Reel Deal users who have rated the movie.
     * Returns -1 if the movie does not have ratings.
     * 
     * @return average rating or -1
     */
    public float getAverageRating() {
        return ratings.getAverageRating();
    }
    
    /**
     * Gets the average rating over all Reel Deal users of a specific major
     * who have rated the movie. Returns -1 if no major specific ratings found.
     * @param major
     * @return average rating of specific major
     */
    public float getMajorSpecificRating(String major) {
        return ratings.getMajorSpecificRating(major);
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

    /**
     * Return the movie's ReelDeal ratings
     * @return ratings from the ReelDeal web app
     */
    public List<ReelDealRating> getReelDealRatings() {
        return ratings.getReelDealRatings();
    }

    /**
     * Set the movie's ReelDeal Rating
     * @param reelDealRatings 
     */
    public void setReelDealRatings(List<ReelDealRating> reelDealRatings) {
        ratings.setReelDealRatings(reelDealRatings);
    }

    public void addReelDealRating(ReelDealRating newRating) {
        ratings.addReelDealRating(newRating);
    }
}
