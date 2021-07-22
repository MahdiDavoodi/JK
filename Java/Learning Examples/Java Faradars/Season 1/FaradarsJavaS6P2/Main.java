package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("----> Insert your name:");         // Get name from the user.
        String message = String.format("----> Hello %s!\n----> Welcome to my application!",name);
        JOptionPane.showMessageDialog(null,message);                // Say hello to user.
    }
}
