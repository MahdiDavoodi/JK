package ir.blog.mahdidavoodi;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame app = new JFrame("Icons and Label");
        app.setSize(1000, 1000);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel();
        label1.setText("Welcome to Java!");
        app.add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Label 2...");
        app.add(label2, BorderLayout.SOUTH);

        ImageIcon imageIcon = new ImageIcon("1.png");
        JLabel label3 = new JLabel(imageIcon);
        app.add(label3);

        app.setVisible(true);
    }
}
