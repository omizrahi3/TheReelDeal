/**
 * The com.rottentomatoes package handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API
 */
package com.rottentomatoes;

import java.io.Serializable;

/**
 * Handles the text of a Reel Deal movie rating
 * @author Anthony
 */
public class Comment implements Serializable {
    
    private String content;
    
    /**
     * Empty constructor that makes a chain call
     */
    public Comment() {
        this("");
    }
    
    /**
     * Chained constructor that sets the content of the comment for
     * a movie rating
     * @param content Text content of the rating
     */
    public Comment(String content) {
        setContent(content);
    }

    /**
     * Getter for the text content of the review
     * @return Text content of the review
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter for the text content of the review
     * @param content Text content of the review
     */
    public final void setContent(String content) {
        // TODO determine checks for validation
        // max length?
        // explicit language?
        this.content = content;
    }  
}
