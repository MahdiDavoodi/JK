package ir.blog.mahdidavoodi;

import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestAccount {

    Account account = new Account();

    @Test
    public void testCAPTCHA() {
        byte[] captchaReturn = account.captcha();
        if (captchaReturn[0] < 1 || captchaReturn[0] > 10) fail();
        else if (captchaReturn[1] < 1 || captchaReturn[1] > 10) fail();
        else if (captchaReturn[2] < 1 || captchaReturn[2] > 4) fail();
    }

    @Test
    public void testReCAPTCHA() {
        assertTrue(account.reCAPTCHA(new byte[]{5, 10, 1}, 15));
        assertTrue(account.reCAPTCHA(new byte[]{3, 2, 2}, 1));
        assertTrue(account.reCAPTCHA(new byte[]{9, 3, 3}, 3));
        assertTrue(account.reCAPTCHA(new byte[]{5, 10, 4}, 50));
    }

    @Test
    public void testPasswordHash() {
        assertEquals(account.passwordHash("MD 123 %$"), 456021);
        assertEquals(account.passwordHash("HjZ&^ ][w 3212"), 8920);
    }

    @Test
    public void testEmailChecker() {
        assertTrue(account.emailChecker("Google@gmail.com"));
        assertFalse(account.emailChecker("Go*$.gle@gmail.com"));
        assertFalse(account.emailChecker("Google"));
        assertFalse(account.emailChecker("Google@@dd.com"));
    }

    @Test
    public void testCreateAccount() {
        assertTrue(account.createAccount("Google@gmail.com", "G[]123%^", "testAccount.txt"));
        assertFalse(account.createAccount("Google", "G[]123%^", "testAccount.txt"));
    }

    @Test
    public void testLogin() {
        testCreateAccount();
        assertTrue(account.login("Google@gmail.com", "G[]123%^", "testAccount.txt"));
        assertFalse(account.login("Google", " ", "testAccount.txt"));
    }

    @After
    public void afterTests() {
        File testAccount = new File("testAccount.txt");
        if (testAccount.exists())testAccount.delete();
    }
}
