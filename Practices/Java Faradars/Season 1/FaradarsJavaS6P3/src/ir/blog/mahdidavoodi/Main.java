package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("----> Please input an integer:");
        int number = Integer.parseInt(input);             // We changed String to Integer.
        String message;
        if (number % 2 == 0) message = "----> Number was an Even number!";
        else message = "----> Number was an Odd number!";
        JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);      // Show the result.
        

    }
}
