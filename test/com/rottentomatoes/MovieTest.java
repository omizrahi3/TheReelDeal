/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rottentomatoes;

import java.util.List;
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
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAverageRating method, of class Movie.
     */
    @Test
    public void testGetAverageRating() {
        System.out.println("getAverageRating");
        Movie instance = new Movie();
        float expResult = 0.0F;
        float result = instance.getAverageRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMajorSpecificRating method, of class Movie.
     */
    @Test
    public void testGetMajorSpecificRating() {
        System.out.println("getMajorSpecificRating");
        String major = "";
        Movie instance = new Movie();
        float expResult = 0.0F;
        float result = instance.getMajorSpecificRating(major);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Movie.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Movie instance = new Movie();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Movie.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Movie instance = new Movie();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Movie.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = null;
        Movie instance = new Movie();
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReelDealRatings method, of class Movie.
     */
    @Test
    public void testGetReelDealRatings() {
        System.out.println("getReelDealRatings");
        Movie instance = new Movie();
        List<ReelDealRating> expResult = null;
        List<ReelDealRating> result = instance.getReelDealRatings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReelDealRatings method, of class Movie.
     */
    @Test
    public void testSetReelDealRatings() {
        System.out.println("setReelDealRatings");
        List<ReelDealRating> reelDealRatings = null;
        Movie instance = new Movie();
        instance.setReelDealRatings(reelDealRatings);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReelDealRating method, of class Movie.
     */
    @Test
    public void testAddReelDealRating() {
        System.out.println("addReelDealRating");
        ReelDealRating newRating = null;
        Movie instance = new Movie();
        instance.addReelDealRating(newRating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
