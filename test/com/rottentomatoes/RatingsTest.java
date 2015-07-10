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
import usermanagement.User;
import com.rottentomatoes.ReelDealRating;
/**
 *
 * @author Jimmy
 */
public class RatingsTest {
    Ratings ratings1;
    Ratings ratings2;
    Ratings ratings3;
    
    public RatingsTest() {
    }

    @Before
    public void setUp() {
        ratings1 = new Ratings();
        ratings2 = new Ratings();
        ratings3 = new Ratings();
        
        ReelDealRating greatRating = new ReelDealRating();
        greatRating.setValue(4);
        
        ReelDealRating goodRating = new ReelDealRating();
        goodRating.setValue(3);
        
        ReelDealRating okayRating = new ReelDealRating();
        okayRating.setValue(2);
        
        ReelDealRating badRating = new ReelDealRating();
        badRating.setValue(1);
        
        ReelDealRating awfulRating = new ReelDealRating();
        awfulRating.setValue(0);
        
        ratings1.addReelDealRating(greatRating); //4
        ratings1.addReelDealRating(goodRating); //3
        ratings1.addReelDealRating(okayRating);//2
        ratings1.addReelDealRating(badRating);//1
        ratings1.addReelDealRating(awfulRating);//0
        
        ratings2.addReelDealRating(goodRating);
        
        ratings3.addReelDealRating(awfulRating);
        ratings3.addReelDealRating(awfulRating);
        ratings3.addReelDealRating(awfulRating);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getAverageRating method, of class Ratings.
     */
    @Test
    public void testGetAverageRating() {
        System.out.println("getAverageRating");
        Ratings instance = ratings1;
        float expResult = 2.0F;
        float result = instance.getAverageRating();
        System.out.println(result);
        assertEquals("Multiple rating average was incorrect", expResult, result, 0.0);
    }
    
    @Test
    public void testGetAverageRating2() {
        System.out.println("getAverageRating");
        Ratings instance = ratings2;
        float expResult = 3.0F;
        float result = instance.getAverageRating();
        System.out.println(result);
        assertEquals("Single rating average was incorrect", expResult, result, 0.0);
    }
    
    @Test
    public void testGetAverageRating3() {
        System.out.println("getAverageRating");
        Ratings instance = ratings3;
        float expResult = 0.0F;
        float result = instance.getAverageRating();
        System.out.println(result);
        assertEquals("Ratings of zero average was incorrect", expResult, result, 0.0);
    }
    
    @Test
    public void testGetAverageRating4() {
        System.out.println("getAverageRating");
        Ratings instance = new Ratings();
        float expResult = -1.0F;
        float result = instance.getAverageRating();
        System.out.println(result);
        assertEquals("Answer is not -1 when no ratings present.", expResult, result, 0.0);
    }
}