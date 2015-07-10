package usermanagement;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This JUnit test is for the method getStatus() of the Account class and
 * will test both the logic of getStatus() and the methods full branch coverage
 *
 * @author ODell Mizrahi
 */
public class AccountGetStatusTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
        //account.setUsername("user");
    }

    //Tests coverage if User is only banned
    @Test
    public final void testBranchCoverageBanned() {
        account.setBanned(true);
        account.setLocked(false);
        account.setAdmin(false);
        assertEquals("Banned", account.getStatus());
    }

    //Tests coverage if User is only locked
    @Test
    public final void testBranchCoverageLocked() {
        account.setBanned(false);
        account.setLocked(true);
        account.setAdmin(false);
        assertEquals("Locked", account.getStatus());
    }

    //Tests coverage if User is only locked
    @Test
    public final void testBranchCoverageAdmin() {
        account.setBanned(false);
        account.setLocked(false);
        account.setAdmin(true);
        assertEquals("Administrator", account.getStatus());
    }

    //Tests coverage if User is neither banned, locked or admin
    @Test
    public final void testBranchCoverageNone() {
        account.setBanned(false);
        account.setLocked(false);
        account.setAdmin(false);
        assertEquals("Active", account.getStatus());
    }

    //Tests coverage if User is both banned and locked and return is expected banned
    @Test
    public final void testBranchCoverageBannedLocked() {
        account.setBanned(true);
        account.setLocked(true);
        account.setAdmin(false);
        assertEquals("Banned", account.getStatus());
    }

    //Tests coverage if User is both banned and locked and return is expected locked
    @Test
    public final void testBranchCoverageLockedBanned() {
        account.setBanned(true);
        account.setLocked(true);
        account.setAdmin(false);
        assertEquals("Locked", account.getStatus());
    }

    //Tests coverage if User is active immediately after new instance is created
    @Test
    public final void testBranchCoverageNull() {
        assertEquals("Active", account.getStatus());
    }

}
