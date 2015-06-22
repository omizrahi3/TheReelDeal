/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rottentomatoes;

/**
 *
 * @author Anthony
 */
public class Comment {
    private String content;
    /**
     * Constructor
     */
    public Comment() {
        this("");
    }
    
    /**
     * Chained constructor
     * @param content Text content of review
     */
    public Comment(String content) {
        setContent(content);
    }

    /**
     * Return the text content of the review
     * @return text content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the text content of the review
     * @param content text content
     */
    public final void setContent(String content) {
        // TODO determine checks for validation
        // max length?
        // explicit language?
        this.content = content;
    }  
}
