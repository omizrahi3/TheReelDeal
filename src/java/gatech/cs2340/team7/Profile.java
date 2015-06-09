/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gatech.cs2340.team7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Anthony
 * @author Jimmy
 */
@ManagedBean(name = "profile", eager = true)
@SessionScoped
public class Profile {
    
    public static final String DEFAULT_ABOUT_ME = "Share something about yourself.";
    
    // private Image image;
    private String name;
    private String aboutMe;
    private String imageURL;
    
    /**
     * Empty constructor
     */
    public Profile() {
        this("", Profile.DEFAULT_ABOUT_ME, "");
    }
    
    /**
     * Constructor specifying the name of the user
     * @param name name of user
     */
    public Profile(String name) {
        this(name, Profile.DEFAULT_ABOUT_ME, "");
    }
    
    /**
     * Constructor for instantiating all relevant data
     * @param name Name of user (not username of account)
     * @param aboutMe About me section
     * @param imageURL URL of profile image
     */
    public Profile(String name, String aboutMe, String imageURL) {
        this.name = name;
        this.aboutMe = aboutMe;
        this.imageURL = imageURL;
    }
    
    public String getImageURL() {
        return imageURL;
    }
    
    public String getAboutMe() {
        return aboutMe;
    }
    
    public String getName() {
     return name;   
    }
    
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}