/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import UserManagement.User;
/**
 *
 * @author Jimmy
 */
public class ReelDealRating {
    private final User author;
    private float value;
    
    public ReelDealRating(User author, float value) {
        this.author = author;
        setValue(value);
    }
    
    public void setValue(float value) {
        if (value > 4) {
            this.value = 4.0f;
        } else if (value < 0) {
            this.value = 0f;
        } else {
            this.value = value;
        }
    }
    
    public float getValue() {
        return value;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public String getMajor() {
        return author.getMajor();
    }

    
}
