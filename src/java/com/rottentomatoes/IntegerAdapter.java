/**
 * Handles all of the data that is returned from a REST call to the Rotten
 * Tomatoes API.
 */
package com.rottentomatoes;

import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.TypeAdapter;
import java.io.Serializable;

/**
 * Custom GSON adapter extension to handle receiving an empty string for an int
 * or Integer type data member.
 *
 * @author Anthony
 */
public class IntegerAdapter extends TypeAdapter<Integer> implements Serializable {

    @Override
    public final Integer read(final JsonReader reader) throws IOException {
        int result;
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
        }
        final String val = reader.nextString();
        try {
            result = Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            result = -2;
        }
        return result;
    }

    @Override
    public final void write(
            final JsonWriter writer, Integer val) throws IOException {
        if (val == null) {
            writer.nullValue();
            return;
        }
        writer.value(val);
    }
}
