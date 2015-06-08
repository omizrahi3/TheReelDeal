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
    
    // private Image image;
    private String name;
    private String aboutMe;
    private String imageURL;
    
    public Profile() {
        name = "";
        aboutMe = "";
        imageURL = "";
        
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