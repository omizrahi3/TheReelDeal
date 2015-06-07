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
    
    public MajorMenuView() {
        initMenu();
    }

    public void initMenu() {
        System.out.println("Initializing MajorMenuView data.");
        SelectItemGroup archMajors = new SelectItemGroup("Architecture");        
        SelectItemGroup csMajors = new SelectItemGroup("Computing");
        SelectItemGroup engMajors = new SelectItemGroup("Engineering");
        SelectItemGroup scienceMajors = new SelectItemGroup("Sciences");
        SelectItemGroup busMajors = new SelectItemGroup("Business");
        SelectItemGroup artsMajors = new SelectItemGroup("Liberal Arts");
        
        csMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Architecture", "Architecture"),
            new SelectItem("Industrial Design", "Industrial Design")
        });
        archMajors.setSelectItems(new SelectItem[] {
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
    
    public String getMajor() {
        return major;
    }
    
    public List<SelectItem> getSchools() {
        return schools;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setSchools(List<SelectItem> schools) {
        this.schools = schools;
    }
}
