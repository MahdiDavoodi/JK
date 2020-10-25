package ir.blog.mahdidavoodi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String[] options = new String[]{"Save", "Don't Save", "Cancel"};

        int result = JOptionPane.showOptionDialog(
                null,
                "----> Do you want to save changes to file?", "Option Dialog", 0, JOptionPane.WARNING_MESSAGE, null, options, options[2]
        );
        if (result == JOptionPane.CLOSED_OPTION)
            result = 2;
        System.out.format("----> showOptionDialog Result: %d [%s]\n", result, options[result]);
    }
}
