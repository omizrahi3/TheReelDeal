/*
 * Specific handle for reviews made on the Reel Deel website
 */
package com.rottentomatoes;

import java.util.Map;

import UserManagement.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Anthony
 * @author Jimmy
 */
@ManagedBean(name = "reelDeelRating", eager = true)
@SessionScoped
public class ReelDealRating {
   
    public static final int MAX_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final String BLACK_REEL_IMG = "resources/images/BlackReel.png";
    public static final String GOLD_REEL_IMG = "resources/images/GoldReel.png";
    
    private String[] reels;
    private User author;
    private int value;
    private Comment comment;
    
    /**
     * Empty constructor
     */
    public ReelDealRating() {
        this(null, new String[MAX_VALUE], MIN_VALUE, "");
    }
    
    /**
     * Chained constructor
     * @param author author
     * @param value value
     * @param comment comment
     * @param reels reels
     */
    public ReelDealRating(User author, String[] reels, int value,
            String comment) {
        this.author = author;
        setReels(reels);
        setValue(value);
        this.comment = new Comment(comment);
    }
    
    /**
     * Update the displayed reels rating
     */
    public void reelsRatingChange() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        value = (params.get("rating") == null ? 0 : Integer.parseInt(params.get("rating")) );
        reelsRatingChange(value);
    }
    
    /**
     * Set the reels according to the given value
     * @param value value to represent via reels
     */
    public void reelsRatingChange(int value) {
        for (int i = 0; i < value; ++i) {
            reels[i] = GOLD_REEL_IMG;
        }
        for (int i = value; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }        
    }
    
    public void submit() {
        System.out.println("Feedback received: " + comment.getContent());
    }
    
    /**
     * Set the value of the rating
     * @param value value
     */
    public final void setValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new java.lang.IllegalArgumentException(
                    "Score give for review is not in range of " +
                            MIN_VALUE + " < value < " + MAX_VALUE);
        }
        this.value = value;
        reelsRatingChange(value);
    }
    
    /**
     * Return the array of .png files to display
     * @return array of strings representing .png files
     */
    public String[] getReels() {
        return reels;
    }
    
    /**
     * Set the reels
     * @param reels 
     */
    public final void setReels(String[] reels) {
        for (int i = 0; i < reels.length; ++i) {
            if (reels[i] == null || reels[i].length() == 0) {
                reels[i] = BLACK_REEL_IMG;
            } else {
                reels[i] = GOLD_REEL_IMG;
            }
        }
        this.reels = reels;
    }
    
    /**
     * Get the value of the rating
     * @return value 
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Get the author of the rating
     * @return author
     */
    public User getAuthor() {
        return author;
    }
    
    /**
     * Set the author of the rating
     * @param author author
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    
    /**
     * Get the major of the author
     * @return major
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
     * @return comment
     */
    public String getComment() {
        return comment.getContent();
    }

    /**
     * Set the comment of the rating
     * @param comment comment
     */
    public final void setComment(Comment comment) {
        this.comment = comment;
    }
    
    /**
     * Set the comment of the rating, based on a String input
     * @param comment comment 
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
}
