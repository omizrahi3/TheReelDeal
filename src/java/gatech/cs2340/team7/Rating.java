/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

/**
 *
 * @author Jimmy
 */
public class Rating {
    public static final int MAX_RATING = 5;
    private final User author;
    private int value;
    
    /**
     * Constructor for rating object
     * 
     * @param author user who made the rating
     * @param value 0 thru MAX_RATING indicating the rating value
     */
    public Rating(User author, int value) {
        this.author = author;
        setValue(value);
    }
    
    /**
     * getter method for the rating value
     * 
     * @return rating value
     */
    public int getValue() {
        return value;
    }
    
    /**
     * getter method for the rating author
     * 
     * @return author
     */
    public User getAuthor() {
        return author;
    }
    
    /**
     * setter for the rating value. Cannot be less than 0 or greater than max value
     * 
     * @param value value to set rating to
     */
    public void setValue(int value) {
        if (value > MAX_RATING) {
            this.value = MAX_RATING;
        } else if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }
}
