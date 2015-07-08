/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
 */
package com.rottentomatoes;

import java.util.Map;

import usermanagement.User;
import gatech.cs2340.team7.ControlHub;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Handles the creation and editing of a movie review made from the ReelDeal
 * application.
 *
 * @author Anthony
 * @author Jimmy
 */
@ManagedBean(name = "reelDealRating", eager = true)
@SessionScoped
public class ReelDealRating implements Serializable {

    public static final int MAX_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final String BLACK_REEL_IMG = "resources/images/BlackReel.png";
    public static final String GOLD_REEL_IMG = "resources/images/GoldReel.png";

    private String[] reels;
    private String displayDescriptor;
    private User author;
    private int value;
    private Comment comment;
    private boolean flagged;

    /**
     * Empty constructor that makes a chain call to set default values.
     */
    public ReelDealRating() {
        this(null, new String[MAX_VALUE], MIN_VALUE, "");
    }

    /**
     * Chained copy constructor that sets data members based on the data passed
     * in.
     *
     * @param newRating new Reel Deal rating
     */
    public ReelDealRating(final ReelDealRating newRating) {
        this.reels = newRating.getReels();
        this.author = newRating.getAuthor();
        this.value = newRating.getValue();
        this.comment = new Comment(newRating.getComment());
        this.flagged = false;
    }

    /**
     * Chained constructor call that sets data members based on the input data.
     *
     * @param newAuthor Author of the review
     * @param newValue Numerical score of the review
     * @param newComment Handle of the comment of the review
     */
    public ReelDealRating(final User newAuthor, final int newValue,
            final String newComment) {
        this(newAuthor, new String[MAX_VALUE], newValue, newComment);
    }

    /**
     * Chained constructor call that sets data members based on the input data.
     *
     * @param newAuthor Author of the review
     * @param newValue Numerical score of the review
     * @param newComment Handle of the comment of the review
     * @param newReels Array of paths to custom reel images to display the score
     */
    public ReelDealRating(final User newAuthor,
            final String[] newReels,
            final int newValue,
            final String newComment) {
        this.author = newAuthor;
        setReels(newReels);
        setValue(newValue);
        this.comment = new Comment(newComment);
        this.displayDescriptor = "Leave a Review";
    }

    /**
     * Update the array of reels, which displays a gold reel for each point in
     * the score given for the movie.
     */
    public final void reelsRatingChange() {
        final Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        if (params.get("rating") == null) {
            value = 0;
        } else {
            value = Integer.parseInt(params.get("rating"));
        }
        assertReels(value);
    }

    /**
     * Set the array of reels images according to the given value.
     *
     * @param ratingValue Value to represent via reel images
     */
    public final void assertReels(final int ratingValue) {
        for (int i = 0; i < ratingValue; ++i) {
            reels[i] = GOLD_REEL_IMG;
        }
        for (int i = ratingValue; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }
    }

    /**
     * Setter for the numerical score for the movie.
     *
     * @param newValue Numerical score for the movie
     */
    public final void setValue(final int newValue) {
        if (newValue < MIN_VALUE || newValue > MAX_VALUE) {
            throw new java.lang.IllegalArgumentException(
                    "Score give for review is not in range of "
                    + MIN_VALUE + " < value < " + MAX_VALUE);
        }
        this.value = newValue;
        assertReels(newValue);
    }

    /**
     * Getter for the array of .png files to display.
     *
     * @return array of strings representing .png files
     */
    public final String[] getReels() {
        return reels;
    }

    /**
     * Setter for the array of .png files to display.
     *
     * @param newReels array of strings representing .png files
     */
    public final void setReels(final String[] newReels) {
        this.reels = new String[newReels.length];
        for (int i = 0; i < newReels.length; ++i) {
            if (newReels[i] == null || newReels[i].length() == 0) {
                this.reels[i] = BLACK_REEL_IMG;
            } else {
                this.reels[i] = GOLD_REEL_IMG;
            }
        }
    }

    /**
     * Getter for the value of the rating.
     *
     * @return value Value of the rating
     */
    public final int getValue() {
        return value;
    }

    /**
     * Getter for the author of the rating.
     *
     * @return author Author of the rating
     */
    public final User getAuthor() {
        return author;
    }

    /**
     * Set the author of the rating.
     *
     * @param newAuthor Author of the rating
     */
    public final void setAuthor(final User newAuthor) {
        this.author = newAuthor;
    }

    /**
     * Get the major of the author.
     *
     * @return major Major for the author of the rating
     */
    public final String getMajor() {
        String major;
        if (author == null || author.getMajor() == null) {
            major = "None";
        } else {
            major = author.getMajor();
        }
        return major;
    }

    /**
     * Get the comment of the rating.
     *
     * @return comment Handle of the comment of the rating
     */
    public final String getComment() {
        return comment.getContent();
    }

    /**
     * Set the comment of the rating.
     *
     * @param newComment Handle of the commment of the rating
     */
    public final void setComment(final Comment newComment) {
        this.comment = newComment;
    }

    /**
     * Set the comment of the rating, based on a String input.
     *
     * @param newComment comment
     */
    public final void setComment(final String newComment) {
        this.comment.setContent(newComment);
    }

    /**
     * Clear member data. Called after the rating has been successfully
     * processed.
     */
    public final void clearData() {
        this.value = MIN_VALUE;
        setComment("");
        for (int i = 0; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }
    }

    /**
     * Flag the comment as potentially inappropriate.
     *
     * @return Next page to load after processing flag
     */
    public final String flag() {
        flagged = true;
        ControlHub.getInstance().saveState();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Remove the comment from being flagged as potentially inappropriate.
     *
     * @return Next page to load after processing unflag
     */
    public final String deFlag() {
        flagged = false;
        ControlHub.getInstance().movieUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }

    /**
     * Return whether this rating is currently flagged as potentially
     * inappropriate.
     *
     * @return Whether this rating is currently flagged as potentially
     * inappropriate
     */
    public final boolean isFlagged() {
        return flagged;
    }

    /**
     * Return whether this rating is currently flagged as potentially
     * inappropriate.
     *
     * @param flag Whether this rating is currently flagged as potentially
     * inappropriate
     */
    public final void setFlagged(final boolean flag) {
        this.flagged = flag;
    }



    /**
     * Get the description label for the given review, which indicates whether a
     * new review is being made, or an existing review is being edited.
     *
     * @return Review Label Description
     */
    public final String getDisplayDescriptor() {
        return displayDescriptor;
    }

    /**
     * Update the description label for the given review, which indicates
     * whether a new review is being made, or an existing review is
     * being edited.
     *
     * @param newDescriptor New Review Label Description
     */
    public final void setDisplayDescriptor(final String newDescriptor) {
        this.displayDescriptor = newDescriptor;
    }
}
