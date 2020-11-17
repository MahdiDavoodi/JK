package ir.blog.mahdidavoodi;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestUserManagement {
    UserManagement userManagement = new UserManagement();

    @Test
    public void testPasswordHash() {
        assertEquals(userManagement.passwordHash("MD 123 %$"), 456021);
        assertEquals(userManagement.passwordHash("HjZ&^ ][w 3212"), 8920);
    }

    @Test
    public void testEmailChecker() {
        assertTrue(userManagement.emailChecker("Google@gmail.com"));
        assertFalse(userManagement.emailChecker("Go*$.gle@gmail.com"));
        assertFalse(userManagement.emailChecker("Google"));
        assertFalse(userManagement.emailChecker("Google@@dd.com"));
    }
    @Test
    public void testCreateUser() {
        assertTrue(userManagement.createUser("Google@gmail.com", "G[]123%^", "Google"));
        assertFalse(userManagement.createUser("Google", "G[]123%^", "Google"));
    }

}
