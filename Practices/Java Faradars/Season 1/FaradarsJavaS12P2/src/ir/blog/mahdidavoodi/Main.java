package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame app = new JFrame("Drawing Arc");

        app.setSize(400, 400);
        app.add(new Panel());
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);    }
}
