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
    public static final String DEFAULT_MAJOR = "Undecided";
    
    private String name;
    private String major;
    private String aboutMe;
    private String imageURL;
    
    /**
     * Empty constructor
     */
    public Profile() {
        this("", Profile.DEFAULT_MAJOR, Profile.DEFAULT_ABOUT_ME, "");
    }
    
    /**
     * Constructor specifying the name of the user
     * @param name name of user
     */
    public Profile(String name, String major) {
        this(name, major, Profile.DEFAULT_ABOUT_ME, "");
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
        this.imageURL = imageURL;
    }
    
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
    
    public String getAboutMe() {
        return aboutMe;
    }
    
    public String getName() {
     return name;   
    }
    
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}