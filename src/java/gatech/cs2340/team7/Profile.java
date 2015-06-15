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
 * @author Katie
 */
@ManagedBean(name = "profile", eager = true)
@SessionScoped
public class Profile {
    
    public static final String DEFAULT_ABOUT_ME = "Share something about yourself.";
    public static final String DEFAULT_MAJOR = "Undecided";
    public static final String DEFAULT_IMAGE_URL = "resources/images/AnonImage.jpg";
    
    private String name;
    private String major;
    private String aboutMe;
    private String imageURL;
    
    /**
     * Constructor
     */
    public Profile() {
        this("", Profile.DEFAULT_MAJOR, Profile.DEFAULT_ABOUT_ME, Profile.DEFAULT_IMAGE_URL);
    }
    
    /**
     * Constructor specifying the name of the user
     * @param name name of user
     * @param major major of user
     */
    public Profile(String name, String major) {
        this(name, major, Profile.DEFAULT_ABOUT_ME, Profile.DEFAULT_IMAGE_URL);
    }

    /**
     * Constructor for instantiating all relevant data
     * @param name Name of user (not username of account)
     * @param major User's major
     * @param aboutMe About me section
     * @param imageURL URL of profile image
     */
    public Profile(String name, String major, String aboutMe, String imageURL) {
        this.name = name;
        this.major = major;
        this.aboutMe = aboutMe;
        if (imageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        }
        else if (imageURL == null) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = imageURL;
        }
    }
    
    /**
     * Return the profile picture's URL
     * @return image URL
     */
    public String getImageURL() {
        return imageURL;
    }
    
    /**
     * Return the user's major
     * @return user's major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Return the user's about me section
     * @return user's about me section
     */
    public String getAboutMe() {
        return aboutMe;
    }
    
    /**
     * Return the user's human name
     * @return user's human name
     */
    public String getName() {
     return name;   
    }
    
    /**
     * Set the user's about me section
     * @param aboutMe about me section to set
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    /**
     * Set the user's major
     * @param major user's major
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /**
     * Set the user's name
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the user's imageURL
     * @param imageURL URL to set
     */
    public void setImageURL(String imageURL) {
        if (imageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        }
        else if (imageURL == null) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = imageURL;
        }
    }
}