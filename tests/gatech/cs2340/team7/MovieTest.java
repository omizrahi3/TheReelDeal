/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jimmy
 */
public class MovieTest {
    public static Movie instance;
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Movie("Lord of the Rings", "Action");
        instance.comment(new Comment(new User("Bob", new Account("bman88"), 
                new Profile("Bob", "Computer Science"))));
        instance.comment(new Comment(new User("Jim", new Account("jman88"), 
                new Profile("Jim", "Computer Science"))));
        instance.comment(new Comment(new User("Abe", new Account("aman88"), 
                new Profile("Abe", "Architechture"))));
        instance.comment(new Comment(new User("Benny", new Account("bman88"), 
                new Profile("Benny", "Chemistry"))));
        instance.comment(new Comment(new User("Denny", new Account("dman88"), 
                new Profile("Denny", "Chemistry"))));
        instance.comment(new Comment(new User("Penny", new Account("pman88"), 
                new Profile("Penny", "Chemistry"))));
        
        instance.rate(new Rating(new User("Bob", new Account("bman88"), 
                new Profile("Bob", "Computer Science")), 5));
        instance.rate(new Rating(new User("Jim", new Account("jman88"), 
                new Profile("Jim", "Computer Science")), 3));
        instance.rate(new Rating(new User("Abe", new Account("aman88"), 
                new Profile("Abe", "Architechture")), 4));
        instance.rate(new Rating(new User("Benny", new Account("bman88"), 
                new Profile("Benny", "Chemistry")), 1));
        instance.rate(new Rating(new User("Denny", new Account("dman88"), 
                new Profile("Denny", "Chemistry")), 0));
        instance.rate(new Rating(new User("Penny", new Account("pman88"), 
                new Profile("Penny", "Chemistry")), 1));
    }

    /**
     * Test of getTitle method, of class Movie.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "Lord of the Rings";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenre method, of class Movie.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        String expResult = "Action";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }



    /**
     * Test of getAverageRating method, of class Movie.
     */
    @Test
    public void testGetAverageRating() {
        System.out.println("getAverageRating");
        double expResult = 7.0 / 3;
        double result = instance.getAverageRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMajorSpecificRating method, of class Movie.
     */
    @Test
    public void testGetMajorSpecificRating() {
        System.out.println("getMajorSpecificRating");
        String major = "Chemistry";
        double expResult = 2.0 / 3;
        double result = instance.getMajorSpecificRating(major);
        assertEquals(expResult, result, 0.0);
    }
   
    /**
     * Test of getMajorSpecificRating method, of class Movie.
     */
    @Test
    public void testGetMajorSpecificRating2() {
        System.out.println("getMajorSpecificRating");
        String major = "Swimming";
        double expResult = 0;
        double result = instance.getMajorSpecificRating(major);
        assertEquals(expResult, result, 0.0);
    }
    
}
