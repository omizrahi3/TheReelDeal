/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Anthony
 */
@ManagedBean(name = "majorMenuView", eager = true)
@SessionScoped
public class MajorMenuView {
    private String major;
    private List<SelectItem> schools;
    
    /**
     * Constructor
     */
    public MajorMenuView() {
        initMenu();
    }

    /**
     * Initialize all schools and majors of each school. This
     * data is what will be seen by the user when choosing his/her
     * major. The data will be categorized by each school, which is
     * implemented as a SelectItemGroup. Within each school, each major
     * is implemented as a SelectItem, with a text and label property.
     * e.g. new SelectItem("Text1", "Label1") will create a SelectItem
     *      that returns Text1 when the user chooses Label1. Label1 is what 
     *      the user will see and Text1 is what will set internally
     */
    private void initMenu() {
        System.out.println("Initializing MajorMenuView data.");
        SelectItemGroup archMajors = new SelectItemGroup("Architecture");        
        SelectItemGroup csMajors = new SelectItemGroup("Computing");
        SelectItemGroup engMajors = new SelectItemGroup("Engineering");
        SelectItemGroup scienceMajors = new SelectItemGroup("Sciences");
        SelectItemGroup busMajors = new SelectItemGroup("Business");
        SelectItemGroup artsMajors = new SelectItemGroup("Liberal Arts");
        
        archMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Architecture", "Architecture"),
            new SelectItem("Industrial Design", "Industrial Design")
        });
        csMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Computational Media", "Computational Media"),
            new SelectItem("Computer Science", "Computer Science")
        });
        engMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Aerospace", "Aerospace"),
            new SelectItem("Biomedical", "Biomedical"),
            new SelectItem("Chemical", "Chemical"),
            new SelectItem("Civil", "Civil"),
            new SelectItem("Computer", "Computer"),
            new SelectItem("Electrical", "Electrical"),
            new SelectItem("Environmental", "Environmental"),
            new SelectItem("v", "Industrial"),
            new SelectItem("Material Science", "Material Science"),
            new SelectItem("Mechanical", "Mechanical"),
            new SelectItem("Nuclear & Radiological", "Nuclear & Radiological")
        });
        scienceMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Applied Math", "Applied Math"),
            new SelectItem("Applied Physics", "Applied Physics"),
            new SelectItem("Biochemistry", "Biochemistry"),
            new SelectItem("Biology", "Biology"),
            new SelectItem("Chemistry", "Chemistry"),
            new SelectItem("Discrete Math", "Discrete Math"),
            new SelectItem("Earth & Atmospheric Science", "Earth & Atmospheric Science"),
            new SelectItem("Physics", "Physics"),
            new SelectItem("Psychology", "Psychology")
        });
        busMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Business", "Business"),
        });
        artsMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Applied Languages", "Applied Languages"),
            new SelectItem("Inter-Cultural Studies", "Inter-Cultural Studies"),
            new SelectItem("International Affairs", "International Affairs"),
            new SelectItem("Modern Languages", "Modern Languages"),
            new SelectItem("History, Technology, and Science", "History, Technology, and Science"),
            new SelectItem("Literature, Media, and Communication", "Literature, Media, and Communication"),
            new SelectItem("Public Policy", "Public Policy")
        });
        
        schools = new ArrayList<>();
        schools.add(archMajors);
        schools.add(csMajors);
        schools.add(engMajors);
        schools.add(scienceMajors);
        schools.add(busMajors);
        schools.add(artsMajors);
    }
    
    /**
     * Get the chosen major
     * @return chosen major
     */
    public String getMajor() {
        return major;
    }
    
    /**
     * Get the list of schools
     * @return list of schools
     */
    public List<SelectItem> getSchools() {
        return schools;
    }
    
    /**
     * Set the chosen major
     * @param major chosen major
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    /**
     * Set the list of schools
     * @param schools list of schools
     */
    public void setSchools(List<SelectItem> schools) {
        this.schools = schools;
    }
}