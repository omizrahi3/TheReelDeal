/**
 * Handles all of the data that
 * is returned from a REST call to the Rotten Tomatoes API.
 */
package com.rottentomatoes;

import java.io.Serializable;

/**
 * Handles the text of a Reel Deal movie rating.
 * @author Anthony
 */
public class Comment implements Serializable {

    /**
     * The text content of a rating comment.
     */
    private String content;

    /**
     * Empty constructor that makes a chain call.
     */
    public Comment() {
        this("");
    }

    /**
     * Chained constructor that sets the content of the comment for
     * a movie rating.
     * @param newContent Text content of the rating
     */
    public Comment(final String newContent) {
        setContent(newContent);
    }

    /**
     * Getter for the text content of the review.
     * @return Text content of the review
     */
    public final String getContent() {
        return content;
    }

    /**
     * Setter for the text content of the review.
     * @param textContent Text content of the review
     */
    public final void setContent(final String textContent) {
        // TODO determine checks for validation
        // max length?
        // explicit language?
        content = textContent;
    }
}
