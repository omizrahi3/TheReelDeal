/*
 * Specific handle for reviews made on the Reel Deel website
 */
package com.rottentomatoes;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "reelDeelReview", eager = true)
@SessionScoped
public class ReelDeelReview extends Review {
   
    public static final int MAX_SCORE = 4;
    public static final int MIN_SCORE = 0;
    public static final String BLACK_REEL_IMG = "resources/images/BlackReel.png";
    public static final String GOLD_REEL_IMG = "resources/images/GoldReel.png";
    
    private String[] reels;
    
    /**
     * Empty constructor
     */
    public ReelDeelReview() {
        this(0, "", new String[MAX_SCORE]);
    }
    
    /**
     * Chained constructor
     * @param score
     * @param feedback
     * @param reels
     */
    public ReelDeelReview(int score, String feedback,
            String[] reels) {
        setFeedback(feedback);
        setReels(reels);
        setScore(score);
    }
    
    public void submit() {
        System.out.println("Feedback received: " + feedback);
    }
    
    @Override
    public final void setScore(int score) {
        if (score < MIN_SCORE || score > MAX_SCORE) {
            throw new java.lang.IllegalArgumentException(
                    "Score give for review is not in range of " +
                            MIN_SCORE + " < score < " + MAX_SCORE);
        }
        this.score = score;
        reelsRatingChange(score);
    }
    
    @Override
    public String getFeedback() {
        return feedback;
    }
    
    @Override
    public final void setFeedback(String feedback) {
        // TODO determine checks for validation
        // max length?
        // explicit language?
        this.feedback = feedback;
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
            }
        }
        this.reels = reels;
    }
    
    /**
     * Update the displayed reels rating
     */
    public void reelsRatingChange() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        score = (params.get("rating") == null ? 0 : Integer.parseInt(params.get("rating")));
        reelsRatingChange(score);
    }
    
    /**
     * Set the reels according to the given score
     * @param score score to represent via reels
     */
    public void reelsRatingChange(int score) {
        for (int i = 0; i < score; ++i) {
            reels[i] = GOLD_REEL_IMG;
        }
        for (int i = score; i < reels.length; ++i) {
            reels[i] = BLACK_REEL_IMG;
        }        
    }
}
