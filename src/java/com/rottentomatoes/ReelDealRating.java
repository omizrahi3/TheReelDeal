/**
 * The com.rottentomatoes package handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API
 */
package com.rottentomatoes;

import java.util.Map;

import UserManagement.User;
import gatech.cs2340.team7.ControlHub;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Handles the creation and editing of a movie review made from
 * the ReelDeal application
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
    private User author;
    private int value;
    private Comment comment;
    private boolean flagged;

    
    /**
     * Empty constructor that makes a chain call to set default values
     */
    public ReelDealRating() {
        this(null, new String[MAX_VALUE], MIN_VALUE, "");
    }
    
    /**
     * Chained copy constructor that sets data members based on the 
     * data passed in
     * @param newRating 
     */
    public ReelDealRating(ReelDealRating newRating) {
        this.reels = newRating.getReels();
        this.author = newRating.getAuthor();
        this.value = newRating.getValue();
        this.comment = new Comment(newRating.getComment());
        this.flagged = false;
    }
    
    /**
     * Chained constructor call that sets data members based on the input data
     * @param author Author of the review
     * @param value Numerical score of the review
     * @param comment Handle of the comment of the review
     */
    public ReelDealRating(User author, int value, String comment) {
        this(author, new String[MAX_VALUE], value, comment);
    }
    
    /**
     * Chained constructor call that sets data members based on the input data
     * @param author Author of the review
     * @param value Numerical score of the review
     * @param comment Handle of the comment of the review
     * @param reels Array of paths to custom reel images to display the score
     */
    public ReelDealRating(User author, String[] reels, int value,
            String comment) {
        this.author = author;
        setReels(reels);
        setValue(value);
        this.comment = new Comment(comment);
    }
    
    /**
     * Update the array of reels, which displays a gold reel for each point
     * in the score given for the movie
     */
    public void reelsRatingChange() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        value = (params.get("rating") == null ? 0 : Integer.parseInt(params.get("rating")) );
        assertReels(value);
    }
    
    /**
     * Set the array of reels images according to the given value
     * @param value Value to represent via reel images
     */
    public void assertReels(int value) {
        for (int i = 0; i < value; ++i) {
            reels[i] = GOLD_REEL_IMG;
        }
        for (int i = value; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }        
    }
    
    /**
     * Setter for the numerical score for the movie
     * @param value Numerical score for the movie
     */
    public final void setValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new java.lang.IllegalArgumentException(
                    "Score give for review is not in range of " +
                            MIN_VALUE + " < value < " + MAX_VALUE);
        }
        this.value = value;
        assertReels(value);
    }
    
    /**
     * Getter for the array of .png files to display
     * @return array of strings representing .png files
     */
    public String[] getReels() {
        return reels;
    }
    
    /**
     * Setter for the array of .png files to display
     * @param reels array of strings representing .png files
     */
    public final void setReels(String[] reels) {
        this.reels = new String[reels.length];
        for (int i = 0; i < reels.length; ++i) {
            if (reels[i] == null || reels[i].length() == 0) {
                this.reels[i] = BLACK_REEL_IMG;
            } else {
                this.reels[i] = GOLD_REEL_IMG;
            }
        }
    }
    
    /**
     * Getter for the value of the rating
     * @return value Value of the rating
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Getter for the author of the rating
     * @return author Author of the rating
     */
    public User getAuthor() {
        return author;
    }
    
    /**
     * Set the author of the rating
     * @param author Author of the rating
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    
    /**
     * Get the major of the author
     * @return major Major for the author of the rating
     */
    public String getMajor() {
        if (author != null && author.getMajor() != null) {
            return author.getMajor();
        } else {
            return "None";
        }
        
    }

    /**
     * Get the comment of the rating
     * @return comment Handle of the comment of the rating
     */
    public String getComment() {
        return comment.getContent();
    }

    /**
     * Set the comment of the rating
     * @param comment Handle of the commment of the rating
     */
    public final void setComment(Comment comment) {
        this.comment = comment;
    }
    
    /**
     * Set the comment of the rating, based on a String input
     * @param comment Comment
     */
    public final void setComment(String comment) {
        System.out.println("Setting comment to " + comment);
        this.comment.setContent(comment);
    }
    
    /**
     * Clear member data.
     * Called after the rating has been successfully processed.
     */
    public void clearData() {
        this.value = MIN_VALUE;
        setComment("");
        for (int i = 0; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }
    }
    
    /**
     * Flag the comment as potentially inappropriate
     * @return Next page to load after processing flag
     */
    public String flag() {
        System.out.println("Flagging comment " + this.getComment());
        flagged = true;
        ControlHub.getInstance().movieUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Remove the comment from being flagged as potentially inappropriate
     * @return Next page to load after processing unflag
     */
    public String deFlag() {
        System.out.println("Flagging comment " + this.getComment());
        flagged = false;
        ControlHub.getInstance().movieUpdate();
        return ControlHub.getInstance().activeUserDashboardPageURL();
    }
    
    /**
     * Return whether this rating is currently flagged as potentially
     * inappropriate
     * @return Whether this rating is currently flagged as potentially
     * inappropriate
     */
    public boolean isFlagged() {
        return flagged;
    }

}
