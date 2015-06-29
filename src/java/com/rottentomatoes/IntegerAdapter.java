/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rottentomatoes;

import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.TypeAdapter;
import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public class IntegerAdapter extends TypeAdapter<Integer> implements Serializable {
    
    @Override
    public Integer read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String val = reader.nextString();
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            System.out.println("Caught number format exception, returning -2");
            return -2;
        }
    }
    
    @Override
    public void write(JsonWriter writer, Integer val) throws IOException {
        if (val == null) {
            writer.nullValue();
            return;
        }
        writer.value(val);
    }
}
