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
    public void testLoginUser() {
        assertTrue(userManagement.loginUser("Admin@admin.com", "G[]123%^"));
        assertFalse(userManagement.loginUser("Admin", "G[]123%^"));
    }

    @Test
    public void testEditWalletBalance() {
        assertTrue(userManagement.loginUser("Admin@admin.com", "G[]123%^"));
        assertFalse(userManagement.loginUser("Admin", "G[]123%^"));
        assertEquals(userManagement.editWalletBalance(0), 202020);
    }

    @Test
    public void testRemoveUser() {
        assertTrue(userManagement.loginUser("Admin@admin.com", "G[]123%^"));
        assertFalse(userManagement.loginUser("Admin", "G[]123%^"));
        assertTrue(userManagement.removeUser());
    }

    @Test
    public void testCreateUser() {
        assertTrue(userManagement.loginUser("Admin@admin.com", "G[]123%^"));
        assertFalse(userManagement.loginUser("Admin", "G[]123%^"));
        assertTrue(userManagement.removeUser());
        assertTrue(userManagement.createUser("Admin@admin.com", "G[]123%^", "Admin", 202020));
        assertFalse(userManagement.createUser("Google", "G[]123%^", "Google", 202020));
    }

}
