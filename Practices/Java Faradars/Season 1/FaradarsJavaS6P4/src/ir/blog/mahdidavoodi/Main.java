package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();

        JFrame frame = new JFrame();    // Create an outside frame for our panel.
        frame.setTitle("Mahdi Davoodi");
        frame.add(panel);           // Add our costume panel to our frame
        frame.setSize(300, 300);     // Set frame default size
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     // We have to set this method. It's too important!
        frame.setVisible(true);             // To show the frame
    }
}
