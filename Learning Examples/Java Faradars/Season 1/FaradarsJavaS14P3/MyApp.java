package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyApp extends JFrame {
    
    public MyApp() {
        super("My Application");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JLabel label1 = new JLabel("Input:");
        this.add(label1);

        JTextField textField = new JTextField(6);
        textField.setText("0");
        this.add(textField);
        
        JLabel label2 = new JLabel(" * 2 ----> 0");
        this.add(label2);
        
        textField.addActionListener(new ActionListener() {
            @Override    
            public void actionPerformed(ActionEvent e) {
                    String string = textField.getText();
                    double n;
                    try {
                        n = Double.parseDouble(string);
                    }
                    catch (Exception ex) {
                        n = 0;
                    }
                    label2.setText(" * 2 ----> " + (2*n));
                }
            });
        
        this.setVisible(true);
    }
    
    
}
