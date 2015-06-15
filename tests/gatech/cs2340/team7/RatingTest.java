/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

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
public class RatingTest {

    /**
     * Test of getValue method, of class Rating.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Rating instance = new Rating(new User(), 4);
        int expResult = 4;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetValue2() {
        System.out.println("getValue");
        Rating instance = new Rating(new User(), 7);
        int expResult = Rating.MAX_RATING;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetValue3() {
        System.out.println("getValue");
        Rating instance = new Rating(new User(), -5);
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class Rating.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        User user = new User();
        Rating instance = new Rating(user, 0);
        User expResult = user;
        User result = instance.getAuthor();
        assertEquals(expResult, result);
    }
    
}
