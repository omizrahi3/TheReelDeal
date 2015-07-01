/*
 * The gatech.cs2340.team7 package contains various overarching manager
 * handles for directing the control and flow of the application
 */
package gatech.cs2340.team7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Handles the processing and return of data from a REST call
 * @author Anthony
 */
@ManagedBean(name = "rESTQuery", eager = true)
@SessionScoped
public class RESTQuery {
    
    private String queryURL;
    
    /**
     * Empty Constructor
     */
    public RESTQuery() {
        queryURL = "";
    }
    
    /**
     * Chained constructor call that sets the URL for the REST query
     * @param queryURL 
     */
    public RESTQuery(String queryURL) {
        this.queryURL = queryURL;
    }

    /**
     * Getter for the query URL
     * @return query URL
     */
    public String getQueryURL() {
        return queryURL;
    }

    /**
     * Setter for the query URL
     * @param queryURL URL for the REST query
     */
    public void setQueryURL(String queryURL) {
        this.queryURL = formatQueryToken(queryURL);
    }
    
    /**
     * Send the HTTP request to Rotten Tomatoes and receive the response
     * @return raw JSON data received from the Rotten Tomatoes response
     */
    public String processQuery() {
        // TODO throw exception if not valid token, have caller catch exceptio
        // and display to user
        System.out.println("Processing query " + queryURL);
        String rawData = "";
        try {
            URL url = new URL(queryURL);
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
            while ((output = br.readLine()) != null) {
                    rawData += output;
            }
            conn.disconnect();
        } catch (MalformedURLException ex) {
           Logger.getLogger(RESTQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot open url");
        }
        return rawData;
    }
    
    /**
     * Return the validity of the potential query token
     * @param tok Token to examine
     * @return indication of token validity
     */
    public static boolean validQueryToken(String tok) {
        // TODO build out validation
        // apache has a url validator
        if (tok instanceof String) {
            return true;
        }
        return false;
    }
    
    /**
     * Assert that the query url tok is in a format to be sent
     * in an HTTP request
     * @param tok Query token to format
     * @return Formatted token
     */
    public String formatQueryToken(String tok) {
        // TODO build out with any other special cases
        return tok.replace(" ", "%20");
    }
}
