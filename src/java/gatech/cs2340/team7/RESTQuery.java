/*
 * Contains various overarching manager
 * handles for directing the control and flow of the application.
 */
package gatech.cs2340.team7;

import java.lang.StringBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Handles the processing and return of data from a REST call.
 *
 * @author Anthony
 */
@ManagedBean(name = "rESTQuery", eager = true)
@SessionScoped
public class RESTQuery {

    /**
     * URL to use to process the query.
     */
    private String queryURL;

    /**
     * Return code used by the HTTP protocol to indicate success of the
     * message being received.
     */
    public static final int HTTP_OK = 200;

    /**
     * Empty Constructor.
     */
    public RESTQuery() {
        queryURL = "";
    }

    /**
     * Chained constructor call that sets the URL for the REST query.
     *
     * @param newQueryURL URL to use to process the query
     */
    public RESTQuery(final String newQueryURL) {
        this.queryURL = newQueryURL;
    }

    /**
     * Getter for the query URL.
     *
     * @return query URL
     */
    public final String getQueryURL() {
        return queryURL;
    }

    /**
     * Setter for the query URL.
     *
     * @param newQueryURL URL for the REST query
     */
    public final void setQueryURL(final String newQueryURL) {
        this.queryURL = formatQueryToken(newQueryURL);
    }

    /**
     * Send the HTTP request to Rotten Tomatoes and receive the response.
     *
     * @return raw JSON data received from the Rotten Tomatoes response
     */
    @SuppressWarnings("OnlyOneReturn")
    public final String processQuery() {
        try {
            final HttpURLConnection conn = setupHTTPConnection(queryURL);
            final String rawData = buildRawData(conn);
            conn.disconnect();
            return rawData;
        } catch (MalformedURLException mue) {
            return "";
        } catch (IOException ioe) {
            return "";
        }
    }

    /**
     * Build raw data from the input stream.
     * @param conn HTTP connection to read the stream from
     * @return Built raw data as a string
     * @throws IOException for bad InputStreamReader
     */
    @SuppressWarnings("DataflowAnomalyAnalysis")
    public final String buildRawData(final HttpURLConnection conn)
        throws IOException {
        InputStream dataStream;
        InputStreamReader streamReader;
        BufferedReader reader;

        dataStream = conn.getInputStream();
        streamReader = new InputStreamReader(dataStream);
        reader = new BufferedReader(streamReader);

        final StringBuffer rawData = new StringBuffer("");
        String output = "";
        while (output != null) {
            rawData.append(output);
            output = reader.readLine();
        }
        return rawData.toString();
    }

    /**
     * Setup the HTTP connection for the given URL.
     * @param url URL to setup HTTP connection for
     * @return Ready-to-use HTTP connection
     * @throws MalformedURLException for bad URL creation
     * @throws IOException for bad URL creation
     */
    public final HttpURLConnection setupHTTPConnection(final String url)
            throws MalformedURLException, IOException {
        HttpURLConnection conn;
        final URL urlForQuery = new URL(url);
        conn = (HttpURLConnection) urlForQuery.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        return conn;
    }

    /**
     * Return the validity of the potential query token.
     *
     * @param tok Token to examine
     * @return indication of token validity
     */
    public static final boolean validQueryToken(final String tok) {
        // Future implementation: build out validation
        return true;
    }

    /**
     * Assert that the query URL token is in a format to be sent in an HTTP
     * request.
     *
     * @param tok Query token to format
     * @return Formatted token
     */
    public final String formatQueryToken(final String tok) {
        // Future implementation:  build out with any other special cases
        return tok.replace(" ", "%20");
    }
}
