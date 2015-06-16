/*
Generic RESTQuery class to process a REST query
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
 *
 * @author Anthony
 */
@ManagedBean(name = "rESTQuery", eager = true)
@SessionScoped
public class RESTQuery {
    
    protected String queryURL;
    
    /**
     * Constructor
     */
    public RESTQuery() {
        queryURL = "";
    }
    
    /**
     * Constructor
     * @param queryURL 
     */
    public RESTQuery(String queryURL) {
        this.queryURL = queryURL;
    }

    /**
     * Return the query URL string
     * @return query URL
     */
    public String getQueryURL() {
        return queryURL;
    }

    /**
     * Set the query URL string
     * @param queryURL new query URL
     */
    public void setQueryURL(String queryURL) {
        this.queryURL = formatQueryToken(queryURL);
    }
    
    /**
     * Actual send the HTTP request and get the response
     * @return raw data received from the HTTP request
     */
    public String processQuery() {
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
