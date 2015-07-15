package loginregistration;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This test is for the method checkNewUserRegistration() of the Registration
 * class and will test both its logic and its full branch coverage.
 * @author Katie Blask
 */
public class RegistrationCheckNewUserTest {

    private Registration registration;

    @Before
    public void setUp() {
        registration = new Registration();
    }

    @Test
    public final void testBranchCoverageNewUsername() {
        assertEquals(false, registration.checkNewUserRegistration(null));
    }

    @Test
    public final void testBranchCoverageTakenUsername() {
        
    }

    @Test
    public final void testBranchCoverageNoUsername() {
        
    }

    @Test
    public final void testBranchCoveragePasswordsMatch() {
        
    }

    @Test
    public final void testBranchCoveragePasswordsMismatch() {
        
    }

    @Test
    public final void testBranchCoverageNoPasswords() {
        
    }
}
