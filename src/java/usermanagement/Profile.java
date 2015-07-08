/**
 * Handles the features of a user.
 */
package usermanagement;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Handles all data and actions on a user's profile.
 * @author Anthony
 * @author Jimmy
 * @author Katie
 * @version 1.3
 */
@ManagedBean(name = "profile", eager = true)
@SessionScoped
public class Profile implements Serializable {
        /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 2238604245469415515L;

    /**
     * default about me text set upon profile creation.
     */
    public static final String DEFAULT_ABOUT_ME = "Share something about"
            + "yourself.";

    /**
     * default major text set upon profile creation.
     */
    public static final String DEFAULT_MAJOR = "Undecided";

    /**
     * default image URL set upon profile creation.
     */
    public static final String DEFAULT_IMAGE_URL =
            "resources/images/AnonImage.jpg";

    /**
     * name of user.
     */
    private String name;

    /**
     * major of user.
     */
    private String major;

    /**
     * about me section of user's profile.
     */
    private String aboutMe;

    /**
     * image URL of user's profile.
     */
    private String imageURL;

    /**
     * Constructs a profile with a default major, about me description,
     * and image URL.
     */
    public Profile() {
        this("", Profile.DEFAULT_MAJOR, Profile.DEFAULT_ABOUT_ME,
                Profile.DEFAULT_IMAGE_URL);
    }

    /**
     * Constructs a profile with a default about me description and image URL.
     * The name of the user is specified
     * @param newName The name of the user
     * @param newMajor The major of the user
     */
    public Profile(final String newName, final String newMajor) {
        this(newName, newMajor, Profile.DEFAULT_ABOUT_ME,
                Profile.DEFAULT_IMAGE_URL);
    }

    /**
     * Constructs a profile with all components specified.
     * @param newName The name of the user (not username of the account)
     * @param newMajor The user's major
     * @param newAboutMe The about me description
     * @param newImageURL The URL of the desired profile image
     */
    public Profile(final String newName, final String newMajor,
            final String newAboutMe, final String newImageURL) {
        this.name = newName;
        this.major = newMajor;
        this.aboutMe = newAboutMe;
        if (newImageURL == null || newImageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = newImageURL;
        }
    }

    /**
     * Getter method for the URL of the profile image.
     * @return imageURL The URL of the image
     */
    public final String getImageURL() {
        return imageURL;
    }

    /**
     * Getter method for the user's major.
     * @return major The user's major
     */
    public final String getMajor() {
        return major;
    }

    /**
     * Getter method for the user's about me description.
     * @return aboutMe The user's about me description
     */
    public final String getAboutMe() {
        return aboutMe;
    }

    /**
     * Getter method for the user's birth name.
     * @return name The user's birth name
     */
    public final String getName() {
     return name;
    }

    /**
     * Setter method for the user's about me description.
     * @param newAboutMe The about me description to set
     */
    public final void setAboutMe(final String newAboutMe) {
        this.aboutMe = newAboutMe;
    }

    /**
     * Setter method for the user's major.
     * @param newMajor The user's selected major
     */
    public final void setMajor(final String newMajor) {
        this.major = newMajor;
    }

    /**
     * Setter method for the user's birth name.
     * @param newName The birth name to set
     */
    public final void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Setter method for the URL of the desired profile image.
     * @param newImageURL The URL to set
     */
    public final void setImageURL(final String newImageURL) {
        if (imageURL == null || imageURL.equals("")) {
            this.imageURL = Profile.DEFAULT_IMAGE_URL;
        } else {
            this.imageURL = newImageURL;
        }
    }
}
