/**
 * The com.rottentomatoes package handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API
 */
package com.rottentomatoes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.faces.bean.SessionScoped;

/**
 * Holds all data specific to a Movie, and provides additional logic
 * to handle formatting of its data
 * @author Anthony
 */
@Generated("org.jsonschema2pojo")
@SessionScoped
public class Movie implements Serializable {

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


    /**
     * Empty constructor that instantiates default values
     */
    public Movie() {
        ratings = new Ratings();
        posters = new Posters();
        synopsis = "No movie found.";
        posters.setThumbnail("resources/images/BlackReel.png");
    }
    
    /**
     * Asserts that the data to be displayed is readable to the common user.
     * To accomplish this, all undefined data is set to
     * default, readable values
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
        ratings.assertDefaultValuesOfUndefData();
    }
    
    /**
     * Getter for the unique identifier of the movie
     * @return Unique identifier string of the movie
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the unique identifier of the movie
     * @param id Unique identifier string of the movie
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the title of the movie
     * @return Title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title of the movie
     * @param title Title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the year of the movie's release
     * @return Year of the movie's release
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Setter for the year of the movie's release
     * @param year Year of the movie's release
     */
    public void setYear(Integer year) {
        this.year = year;
    }

   /**
    * Getter for the MPAA rating of the movie
    * @return MPAA rating of the movie
    */
    public String getMpaaRating() {
        return mpaaRating;
    }

   /**
    * Setter for the MPAA rating of the movie
    * @param mpaaRating MPAA rating of the movie
    */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * Getter for the runtime of the movie
     * @return Runtime of the movie
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * Setter for the runtime of the movie
     * @param runtime Runtime of the movie
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
     * Getter for a short snippet of the critic consensus for the movie
     * @return Snippet of the critic consensus for the movie
     */
    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    /**
     * Setter for a short snippet of the critic consensus for the movie
     * @param criticsConsensus Snippet of the critic consensus for the movie
     */
    public void setCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
    }

    /**
     * Getter for the handle of the release dates for the movie
     * @return Handle of the release dates for the movie
     */
    public ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    /**
     * Setter for the handle of the release dates for the movie
     * @param releaseDates Handle of the release dates for the movie
     */
    public void setReleaseDates(ReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
    }

    /**
     * Getter for the handle for the ratings of the movie
     * @return Handle for the ratings of the movie
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * Setter for the handle for the ratings of the movie
     * @param ratings Handle for the ratings of the movie
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    /**
     * Getter for the summary of the movie
     * @return Summary of the movie
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Setter for the summary of the movie
     * @param synopsis Summary of the movie
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Getter for the handle for the poster pictures of the movie
     * @return Handle for the poster pictures of the movie
     */
    public Posters getPosters() {
        return posters;
    }

    /**
     * Setter for the handle for the poster pictures of the movie
     * @param posters Handle for the poster pictures of the movie
     */
    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    /**
     * Getter for the collection of cast members for the movie
     * @return Collection of cast members for the movie
     */
    public List<AbridgedCast> getAbridgedCast() {
        return abridgedCast;
    }

    /**
     * Setter for the collection of cast members for the movie
     * @param abridgedCast Collection of cast members for the movie
     */
    public void setAbridgedCast(List<AbridgedCast> abridgedCast) {
        this.abridgedCast = abridgedCast;
    }

    /**
     * Getter for the handle of alternate identifiers for the movie
     * @return Handle of alternate identifiers for the movie
     */
    public AlternateIds getAlternateIds() {
        return alternateIds;
    }

    /**
     * Setter for the handle of alternate identifiers for the movie
     * @param alternateIds Handle of alternate identifiers for the movie
     */
    public void setAlternateIds(AlternateIds alternateIds) {
        this.alternateIds = alternateIds;
    }

    /**
     * Getter for the handle of links for the movie
     * @return Handle of links for the movie
     */
    public Links getLinks() {
        return links;
    }

    /**
     * Setter for the handle of links for the movie
     * @param links Handle of links for the movie
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
     * Getter for the movie's ReelDeal ratings
     * @return Ratings from the ReelDeal web app
     */
    public List<ReelDealRating> getReelDealRatings() {
        return ratings.getReelDealRatings();
    }

    /**
     * Setter for the movie's ReelDeal Rating
     * @param reelDealRatings 
     */
    public void setReelDealRatings(List<ReelDealRating> reelDealRatings) {
        ratings.setReelDealRatings(reelDealRatings);
    }

    /**
     * Adds a new Reel Deal rating to the ratings handle for the movie 
     * @param newRating 
     */
    public void addReelDealRating(ReelDealRating newRating) {
        System.out.println("Added review from " +
                newRating.getAuthor().getName() + " with " +
                newRating.getValue() + " reels and feedback: " +
                newRating.getComment());
        ratings.addReelDealRating(newRating);
    }
}
