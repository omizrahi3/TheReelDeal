/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatech.cs2340.team7;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Jimmy
 */
public class RegistrationTest {
    public Registration instance;
    
 
    
    @Before
    public void setUp() {
        instance = new Registration();
        instance.setName("Test Dummy");
        instance.setUsername("TestDum555");
        instance.setMajor("TestingMajor");
        instance.setPassword("TestPassRepeat");
        instance.setPasswordRepeat("TestPassRepeat");
        instance.setValidRegistration(false);
    }
    
 

    /**
     * Test of registerNewUser method, of class Registration.
     */
    @Test
    public void testRegisterNewUser() {
        System.out.println("registerNewUser");
        User expUserResult = new User("Test Dummy", new Account("TestDum555"), new Profile("Test Dummy", "TestingMajor"));
        User userResult = instance.registerNewUser();
        assertEquals(expUserResult.getAccount().getUsername(), userResult.getAccount().getUsername());
        assertEquals(expUserResult.getProfile().getName(), userResult.getProfile().getName());
        assertEquals(expUserResult.getProfile().getName(), userResult.getProfile().getName());
        assertEquals(expUserResult.getName(), userResult.getName());
    }

    /**
     * Test of checkNewUserRegistration method, of class Registration.
     */
    @Test
    public void testCheckNewUserRegistration() {
        System.out.println("checkNewUserRegistration");
        
        List<User> users = new ArrayList<User>();
        users.add(new User("Bob", new Account("Bob555"), new Profile("Test Dummy", "TestingMajor")));
        users.add(new User("Frank", new Account("Frank555"), new Profile("Test Dummy", "TestingMajor")));
        users.add(new User("Jodie", new Account("Jodie555"), new Profile("Test Dummy", "TestingMajor")));
        boolean expResult = true;
        boolean result = instance.checkNewUserRegistration(users);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkNewUserRegistration method, of class Registration.
     */
    @Test
    public void testCheckNewUserRegistration2() {
        System.out.println("checkNewUserRegistration");
        List<User> users = new ArrayList<User>();
        users.add(new User("Bob", new Account("Bob555"), new Profile("Test Dummy", "TestingMajor")));
        users.add(new User("Frank", new Account("Frank555"), new Profile("Test Dummy", "TestingMajor")));
        users.add(new User("Jodie", new Account("Jodie555"), new Profile("Test Dummy", "TestingMajor")));
        users.add(new User("Tester", new Account("TestDum555"), new Profile("Test Dummy", "TestingMajor")));
        boolean expResult = true;
        boolean result = instance.checkNewUserRegistration(users);
        assertEquals(expResult, result);
    }

    /**
     * Test of passwordsMatch method, of class Registration.
     */
    @Test
    public void testPasswordsMatch() {
        System.out.println("passwordsMatch");
        boolean expResult = true;
        boolean result = instance.passwordsMatch();
        assertEquals(expResult, result);
    }

    /**
     * Test of passwordsMatch method, of class Registration.
     */
    @Test
    public void testPasswordsMatch2() {
        System.out.println("passwordsMatch");
        instance.setPasswordRepeat("WrongRepeat");
        boolean expResult = false;
        boolean result = instance.passwordsMatch();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Registration.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Test Dummy";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPasswordRepeat method, of class Registration.
     */
    @Test
    public void testGetPasswordRepeat() {
        System.out.println("getPasswordRepeat");
        String expResult = "TestPassRepeat";
        String result = instance.getPasswordRepeat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMajor method, of class Registration.
     */
    @Test
    public void testGetMajor() {
        System.out.println("getMajor");
        String expResult = "TestingMajor";
        String result = instance.getMajor();
        assertEquals(expResult, result);
    }


    /**
     * Test of isValidRegistration method, of class Registration.
     */
    @Test
    public void testIsValidRegistration() {
        System.out.println("isValidRegistration");
        boolean expResult = false;
        boolean result = instance.isValidRegistration();
        assertEquals(expResult, result);
    }

}