package ir.blog.mahdidavoodi;


import java.io.IOException;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws IOException {
        Snapp snapp = new Snapp();
        snapp.appStart();
    }
}
