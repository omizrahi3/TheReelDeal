package loginregistration;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import usermanagement.User;

/**
 * This test is for the method checkNewUserRegistration() of the Registration
 * class and will test both its logic and its full branch coverage.
 * For this test to work, the faces context functionality within this method
 * needs to be commented out since there is no active web page when
 * this test launches
 * @author Katie Blask
 */
public class RegistrationCheckNewUserTest {

    private Registration registration;
    private Map<String, User> users;
    private User aUser;

    @Before
    public void setUp() {
        registration = new Registration();
        users = new HashMap<String, User>();
        aUser = new User();
    }

    @Test
    public final void testBranchCoverageNewUsername() {
        registration.setUsername("Calvin2000");
        registration.setPassword("CALvin");
        registration.setPasswordRepeat("CALvin");
        assertEquals(true, registration.checkNewUserRegistration(users));
    }

    @Test
    public final void testBranchCoverageTakenUsername() {
        registration.setUsername("Sam1989");
        users.put("Sam1989", aUser);
        registration.setPassword("moviesROCK");
        registration.setPasswordRepeat("moviesROCK");
        assertEquals(false, registration.checkNewUserRegistration(users));
        
    }

    @Test
    public final void testBranchCoverageNoUsername() {
        registration.setUsername(null);
        registration.setPassword("password");
        registration.setPasswordRepeat("password");
        try {
           assertEquals(false, registration.checkNewUserRegistration(users)); 
        }
        catch(IllegalArgumentException e) {
            
        }
    }

    @Test
    public final void testBranchCoveragePasswordsMatch() {
        registration.setUsername("BooRadley300");
        registration.setPassword("ToKillaMockingBird");
        registration.setPasswordRepeat("ToKillaMockingBird");
        assertEquals(true, registration.checkNewUserRegistration(users));
    }

    @Test
    public final void testBranchCoveragePasswordsMismatch() {
        registration.setUsername("TrevorFr0g");
        registration.setPassword("IluvHarryP0tter");
        registration.setPasswordRepeat("iloveHarryPotter");
        assertEquals(false, registration.checkNewUserRegistration(users));
    }

    //Fails because the passwordsMatch method in the Registration class
    //doesn't handle null passwords; fault with the code not the test
    @Test
    public final void testBranchCoverageNoPasswords() {
        registration.setUsername("userName100");
        registration.setPassword(null);
        registration.setPassword(null);
        assertEquals(false, registration.checkNewUserRegistration(users));
    }
}
