/**
 * The UserManagement package handles the features of a user
 */
package UserManagement;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Handles all data and actions on a user's profile
 * @author Anthony
 * @author Jimmy
 * @author Katie
 * @version 1.3
 */
@ManagedBean(name = "profile", eager = true)
@SessionScoped
public class Profile implements Serializable {
    
    public static final String DEFAULT_ABOUT_ME = "Share something about yourself.";
    public static final String DEFAULT_MAJOR = "Undecided";
    public static final String DEFAULT_IMAGE_URL = "resources/images/AnonImage.jpg";
    
    private String name;
    private String major;
    private String aboutMe;
    private String imageURL;
    
    /**
     * Constructs a profile with a default major, about me description, and image URL
     */
    public Profile() {
        this("", Profile.DEFAULT_MAJOR, Profile.DEFAULT_ABOUT_ME, Profile.DEFAULT_IMAGE_URL);
    }
    
    /**
     * Constructs a profile with a default about me description and image URL
     * The name of the user is specified
     * @param name The name of the user
     * @param major The major of the user
     */
    public Profile(String name, String major) {
        this(name, major, Profile.DEFAULT_ABOUT_ME, Profile.DEFAULT_IMAGE_URL);
    }

    /**
     * Constructs a profile with all components specified
     * @param name The name of the user (not username of the account)
     * @param major The user's major
     * @param aboutMe The about me description
     * @param imageURL The URL of the desired profile image
     */
    public Profile(String name, String major, String aboutMe, String imageURL) {
        this.name = name;
        this.major = major;
        this.aboutMe = aboutMe;
        if (imageURL == null || imageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = imageURL;
        }
    }
    
    /**
     * Getter method for the URL of the profile image
     * @return imageURL The URL of the image
     */
    public String getImageURL() {
        return imageURL;
    }
    
    /**
     * Getter method for the user's major
     * @return major The user's major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Getter method for the user's about me description
     * @return aboutMe The user's about me description
     */
    public String getAboutMe() {
        return aboutMe;
    }
    
    /**
     * Getter method for the user's birth name
     * @return name The user's birth name
     */
    public String getName() {
     return name;   
    }
    
    /**
     * Setter method for the user's about me description
     * @param aboutMe The about me description to set
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    /**
     * Setter method for the user's major
     * @param major The user's selected major
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /**
     * Setter method for the user's birth name
     * @param name The birth name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter method for the URL of the desired profile image
     * @param imageURL The URL to set
     */
    public void setImageURL(String imageURL) {
        if (imageURL == null || imageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = imageURL;
        }
    }
}
