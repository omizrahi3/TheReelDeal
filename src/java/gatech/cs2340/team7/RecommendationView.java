/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;
import com.rottentomatoes.Movie;
/**
 *
 * @author Jimmy
 */
public class RecommendationView {
    private String year1;
    private String year2;
    private final MovieManager movieManager;
    
    public RecommendationView(MovieManager movieManager) {
        this.movieManager = movieManager;
        year1 = "1970";
        year2 = "2015";
    }

    /**
     * Getter for year1
     *
     * @return early year bound
     */
    public String getYear1() {
        return year1;
    }

    /**
     * Getter for year2
     *
     * @return later year bound
     */
    public String getYear2() {
        return year2;
    }

    /**
     * setter for year1
     *
     * @param year1 early year bound
     */
    public void setYear1(String year1) {
        this.year1 = year1;
    }

        /**
     * setter for year1
     *
     * @param year2 later year bound
     */
    public void setYear2(String year2) {
        this.year2 = year2;
    }

    public String getRecommendationByYear() {
        int earlyYear = Integer.parseInt(year1);
        int laterYear = Integer.parseInt(year2);
        if (!(earlyYear <= 0) && !(laterYear <= 0)) {
            return movieManager.viewRecommendation(earlyYear, laterYear);
        } else {
            return null;
        }
        
    }
}
