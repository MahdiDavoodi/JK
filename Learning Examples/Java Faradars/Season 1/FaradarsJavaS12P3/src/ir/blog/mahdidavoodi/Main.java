package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame app = new JFrame("OOP and Drawing");
        app.add(new MyPanel());
        app.setSize(400, 400);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
