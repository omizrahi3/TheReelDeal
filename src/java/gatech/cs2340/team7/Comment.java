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
public class Comment {
    private final User author;
    private String title;
    private String body;
    
    /**
     * constructor for Comment object
     * 
     * @param author User writing the comment
     */
    public Comment(User author){
        this(author, "", "");
    }
    
    /**
     * constructor for Comment object
     * 
     * @param author User writing comment
     * @param title comment title
     * @param body contents of the comment
     */
    public Comment(User author, String title, String body){
        this.author = author;
        this.title = title;
        this.body = body;
    }
    
    /**
     * getter method for the comment author
     * 
     * @return comment author
     */
    public User getAuthor() {
        return author;
    }
    
    /**
     * getter method for the comment title
     * 
     * @return comment title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * getter method for the comment body
     * 
     * @return comment body
     */
    public String getBody() {
        return body;
    }
    
    /**
     * setter method for comment title
     * 
     * @param title title of comment
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * setter method for comment body
     * 
     * @param body body of comment
     */
    public void setBody(String body) {
        this.body = body;
    }
    
}
