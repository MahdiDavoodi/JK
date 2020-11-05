package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Panel panel = new Panel();
        JFrame frame = new JFrame();

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setTitle("JavaS6P5");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
