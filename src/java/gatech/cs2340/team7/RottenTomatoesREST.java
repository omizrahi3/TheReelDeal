/*
Class to handle REST interfacing with the Rotten Tomatoes website
 */
package gatech.cs2340.team7;

import com.google.gson.Gson;
import com.rottentomatoes.*; // TODO don't import all

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Anthony
 */
@ManagedBean(name = "rottenTomatoesREST", eager = true)
@SessionScoped
public class RottenTomatoesREST {
    
    public static final String BASE_API_URL = "http://api.rottentomatoes.com/api/public/v1.0";
    public static final String APIKey = "yedukp76ffytfuy24zsqk7f5";
    public static final String BOX_OFFICE_URLTOK = "/lists/movies/box_office.json";
    public static final String NEW_THEATER_RELEASE_URLTOK = "/lists/movies/in_theaters.json";
    public static final String NEW_DVD_RELEASE_URLTOK = "/lists/dvds/new_releases.json";
    
    private List<Movie> searchResultMovies = new ArrayList<>();
    private List<Movie> newDVDReleases = new ArrayList<>();
    private List<Movie> newTheaterReleases = new ArrayList<>();
    private String rawData;
    private String movieToSearch;
    private RottenTomatoesData data;
    private boolean showSearchData;
    
    public RottenTomatoesREST() {
        movieToSearch = "";
        showSearchData = false;
        updateNewDVDReleases();
        updateNewTheaterReleases();
    }
    
    public List<Movie> getSearchResultMovies() {
        return searchResultMovies;
    }

    public void setSearchResultMovies(List<Movie> searchResultMovies) {
        this.searchResultMovies = searchResultMovies;
    }

    public List<Movie> getNewDVDReleases() {
        return newDVDReleases;
    }

    public void setNewDVDReleases(List<Movie> newDVDReleases) {
        this.newDVDReleases = newDVDReleases;
    }

    public List<Movie> getNewTheaterReleases() {
        return newTheaterReleases;
    }

    public void setNewTheaterReleases(List<Movie> newTheaterReleases) {
        this.newTheaterReleases = newTheaterReleases;
    }
    
    public boolean isShowSearchData() {
        return showSearchData;
    }

    public void setShowSearchData(boolean showData) {
        this.showSearchData = showData;
    }

    public RottenTomatoesData getData() {
        return data;
    }

    public void setData(RottenTomatoesData data) {
        this.data = data;
    }
    
     public String getRawData() {
        return rawData;
    }

    public String getMovieToSearch() {
        return movieToSearch;
    }

    public void setMovieToSearch(String movieToSearch) {
        this.movieToSearch = movieToSearch;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }
    
    
    public String getData(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            rawData = "";
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    rawData += output;
            }
            System.out.println("Got JSON: " + rawData);
            conn.disconnect();
        } catch (MalformedURLException ex) {
           Logger.getLogger(RottenTomatoesREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot open url");
        }
        return rawData;
    }
    
    public RottenTomatoesData JSONFormat(String rawData) {
        Gson gson = new Gson();
        return gson.fromJson(rawData, RottenTomatoesData.class);        
    }
    
    public void updateNewTheaterReleases() {
        newTheaterReleases.clear();
        System.out.println("Getting REST data of new releases");
        data = JSONFormat(getData(BASE_API_URL + NEW_THEATER_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" +
                RottenTomatoesREST.APIKey));
        
        //System.out.println("data: " + data);  
        for (Movie m : data.getMovies()) {
            //System.out.println(m.getId());
            newTheaterReleases.add(m);
        }    
    }
    
    public void updateNewDVDReleases() {
        newDVDReleases.clear();
        System.out.println("Getting REST data of new releases");
        data = JSONFormat(getData(BASE_API_URL + NEW_DVD_RELEASE_URLTOK +
                "?limit=16&country=us&apikey=" +
                RottenTomatoesREST.APIKey));
        
        //System.out.println("data: " + data);  
        for (Movie m : data.getMovies()) {
            //System.out.println(m.getId());
            newDVDReleases.add(m);
        }      
    }
    
    public void searchForMovie() {
        System.out.println("Search for movie: " + movieToSearch);
        // TODO perform actual search
        showSearchData = true; // currently not showing table?
    }
}
