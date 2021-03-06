/**
 * Handles logging into the application The Reel Deal as well as
 * registering for an account to access the application The Reel Deal.
 */
package loginregistration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 * Handles the user setting their major via the UI element.
 * @author Anthony
 * @version 1.0
 */
@ManagedBean(name = "majorMenuView", eager = true)
@SessionScoped
public class MajorChooserMenu implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 48874306273002062L;
    /**
     *
     */
    private String major;
    /**
     *
     */
    private List<SelectItem> schools;

    /**
     * Constructs a major menu.
     */
    public MajorChooserMenu() {
        initMenu();
    }

    /**
     * Initializes all schools and majors of each school
     * This data is what will be seen by the user when choosing their major
     * The data will be categorized by school (implemented as SelectItemGroup)
     * Each major is implemented as a SelectItem with a text and label property
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
            new SelectItem("Aerospace Engineering", "Aerospace Engineering"),
            new SelectItem("Biomedical Engineering", "Biomedical Engineering"),
            new SelectItem("Chemical Engineering", "Chemical Engineering"),
            new SelectItem("Civil Engineering", "Civil Engineering"),
            new SelectItem("Computer Engineering", "Computer Engineering"),
            new SelectItem("Electrical Engineering", "Electrical Engineering"),
            new SelectItem("Environmental Engineering",
                    "Environmental Engineering"),
            new SelectItem("Industrial Engineering", "Industrial Engineering"),
            new SelectItem("Material Science Engineering",
                    "Material Science Engineering"),
            new SelectItem("Mechanical Engineering",
                    "Mechanical Engineering"),
            new SelectItem("Nuclear & Radiological Engineering",
                    "Nuclear & Radiological Engineering")
        });
        scienceMajors.setSelectItems(new SelectItem[] {
            new SelectItem("Applied Math", "Applied Math"),
            new SelectItem("Applied Physics", "Applied Physics"),
            new SelectItem("Biochemistry", "Biochemistry"),
            new SelectItem("Biology", "Biology"),
            new SelectItem("Chemistry", "Chemistry"),
            new SelectItem("Discrete Math", "Discrete Math"),
            new SelectItem("Earth & Atmospheric Science",
                    "Earth & Atmospheric Science"),
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
            new SelectItem("History, Technology, and Science",
                    "History, Technology, and Science"),
            new SelectItem("Literature, Media, and Communication",
                    "Literature, Media, and Communication"),
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
     * Getter method for the chosen major.
     * @return major The chosen major
     */
    public final String getMajor() {
        return major;
    }

    /**
     * Getter method for the list of schools.
     * @return schools The list of schools
     */
    public final List<SelectItem> getSchools() {
        return schools;
    }

    /**
     * Setter method for the chosen major.
     * @param maj The chosen major
     */
    public final void setMajor(final String maj) {
        major = maj;
    }

    /**
     * Setter method for the list of schools.
     * @param schoolist The list of schools
     */
    public final void setSchools(final List<SelectItem> schoolist) {
        schools = schoolist;
    }
}