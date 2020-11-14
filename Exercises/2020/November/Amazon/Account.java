package ir.blog.mahdidavoodi;

public class Account {

    public boolean reCAPTCHA(byte[] captchaReturn, int userAnswer) {
        return false;
    }

    public byte[] captcha() {
        return new byte[]{-1, -1, -1};
    }

    public long passwordHash(String password) {
        return -1;
    }

    public boolean emailChecker(String email) {
        return false;
    }

    public boolean createAccount(String email, String password, String pathname) {
        return false;
    }

    public boolean login(String email, String password, String pathname) {
        return false;
    }
}
