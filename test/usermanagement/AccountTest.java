package usermanagement;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;

import loginregistration.BannedAccountException;
import loginregistration.LockedAccountException;

/**
 *
 * @author Anthony
 */
public class AccountTest {

    private Account account;

    @Before
    public void setup() {
        account = new Account();
        account.setUsername("user");
    }

    @Test
    public final void testIdealLogin() 
        throws LockedAccountException, BannedAccountException {
        account.setNumCommentFlags(0);
        account.login();
        assertTrue("Account is not logged in!", account.isLoggedIn());
        assertFalse("Account is incorrectly locked!", account.isLocked());
        assertFalse("Account is incorrectly banned!", account.isBanned());
    }
    
    @Test(expected = LockedAccountException.class)
    public final void testAccountLockedLogin() 
        throws LockedAccountException, BannedAccountException {
        account.setLocked(true);
        account.login();
        assertFalse("Account is incorrectly logged in!", account.isLoggedIn());
    }
    
    @Test(expected = BannedAccountException.class)
    public final void testAccountBannedLogin()
        throws LockedAccountException, BannedAccountException {
        account.setBanned(true);
        account.login();
        assertFalse("Account is incorrectly logged in!", account.isLoggedIn());
    }
    
    @Test(expected = LockedAccountException.class)
    public final void testAccountFlagLockedLogin()
        throws LockedAccountException, BannedAccountException {
        account.setNumCommentFlags(3);
        account.login();
        assertFalse("Account is incorrectly logged in!", account.isLoggedIn());
    }
}
