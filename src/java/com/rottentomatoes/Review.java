/*
 * Generalized review handle to hold a score and feedback
 */
package com.rottentomatoes;

/**
 *
 * @author Anthony
 */
public class Review {
    protected int score;
    protected String feedback;
    
    /**
     * Constructor
     */
    public Review() {
        this(0, "");
    }
    
    /**
     * Chained constructor
     * @param score Score of review
     * @param feedback Text feedback of review
     */
    public Review(int score, String feedback) {
        this.score = score;
        this.feedback = feedback;
    }
    
    /**
     * Return score of the review
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score of the review
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Return the text feedback of the review
     * @return text feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Set the text feedback of the review
     * @param feedback text feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    
    
}
