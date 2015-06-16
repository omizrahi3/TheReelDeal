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
    
    public RESTQuery() {
        queryURL = "";
    }
    
    public RESTQuery(String queryURL) {
        this.queryURL = queryURL;
    }

    public String getQueryURL() {
        return queryURL;
    }

    public void setQueryURL(String queryURL) {
        this.queryURL = formatQueryToken(queryURL);
    }
    
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
    
    public static boolean validQueryToken(String tok) {
        // TODO build out validation
        if (tok instanceof String) {
            return true;
        }
        return false;
    }
    
    public String formatQueryToken(String tok) {
        // TODO build out with any other special cases
        return tok.replace(" ", "%20");
    }
}
