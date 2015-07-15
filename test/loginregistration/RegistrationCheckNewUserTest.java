package loginregistration;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import usermanagement.User;

/**
 * This test is for the method checkNewUserRegistration() of the Registration
 * class and will test both its logic and its full branch coverage.
 * @author Katie Blask
 */
public class RegistrationCheckNewUserTest {

    private Registration registration;
    private Map<String, User> users;
    private User aUser;

    @Before
    public void setUp() {
        registration = new Registration();
    }

    @Test
    public final void testBranchCoverageNewUsername() {
        registration.setUsername("Calvin2000");
        users.clear();
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
        users.clear();
        registration.setPassword("password");
        registration.setPasswordRepeat("password");
        assertEquals(false, registration.checkNewUserRegistration(users));
    }

    @Test
    public final void testBranchCoveragePasswordsMatch() {
        registration.setUsername("BooRadley300");
        users.clear();
        registration.setPassword("ToKillaMockingBird");
        registration.setPasswordRepeat("ToKillaMockingBird");
        assertEquals(true, registration.checkNewUserRegistration(users));
    }

    @Test
    public final void testBranchCoveragePasswordsMismatch() {
        registration.setUsername("TrevorFr0g");
        users.clear();
        registration.setPassword("IluvHarryP0tter");
        registration.setPasswordRepeat("iloveHarryPotter");
        assertEquals(false, registration.checkNewUserRegistration(users));
    }

    @Test
    public final void testBranchCoverageNoPasswords() {
        registration.setUsername("userName100");
        users.clear();
        registration.setPassword(null);
        registration.setPassword(null);
        assertEquals(false, registration.checkNewUserRegistration(users));
    }
}
