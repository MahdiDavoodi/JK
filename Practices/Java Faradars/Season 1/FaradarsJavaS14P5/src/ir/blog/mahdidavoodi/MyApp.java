package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyApp extends JFrame {

    JLabel label1, label2;
    JTextField textField;

    public MyApp() {
        super("My Application");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label1 = new JLabel("Input:");
        this.add(label1);

        textField = new JTextField(6);
        textField.addActionListener(this::txt1_TextChanged);
        textField.setText("0");
        this.add(textField);

        label2 = new JLabel(" * 2 ----> 0");
        this.add(label2);

        this.setVisible(true);
    }

    private void txt1_TextChanged(ActionEvent actionEvent) {
        String string = textField.getText();
        double n;
        try {
            n = Double.parseDouble(string);
        } catch (Exception exception) {
            n = 0;
        }
        label2.setText(" * 2 ----> " + (2 * n));
    }

}
