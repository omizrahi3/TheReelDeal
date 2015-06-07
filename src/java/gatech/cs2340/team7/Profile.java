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
 */
@ManagedBean(name = "profile", eager = true)
@SessionScoped
public class Profile {
    
    // private Image image;
    private String aboutMe;
    
    public Profile() {
        aboutMe = "";
    }
    
    /*public Image getImage() {
        return image;
    }*/
    
    public String getAboutMe() {
        return aboutMe;
    }
    
    /*public void setImage(Image image) {
        this.image = image;
    }*/
    
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
