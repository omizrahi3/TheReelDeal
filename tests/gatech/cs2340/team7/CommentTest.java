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
public class CommentTest {

    /**
     * Test of getAuthor method, of class Comment.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        User user = new User();
        Comment instance = new Comment(user);
        User expResult = user;
        User result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Comment.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Comment instance = new Comment(new User(), "This Movie Sucks", "totally sucks");
        String expResult = "This Movie Sucks";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBody method, of class Comment.
     */
    @Test
    public void testGetBody() {
        System.out.println("getBody");
        Comment instance = new Comment(new User(), "This Movie Sucks", "totally sucks");
        String expResult = "totally sucks";
        String result = instance.getBody();
        assertEquals(expResult, result);
    }
}
