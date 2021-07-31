package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyApp extends JFrame {
    
    JLabel label1, label2;
    JTextField jTextField;
    
    public MyApp() {

        super("My Application");
        this.setSize(600, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        label1 = new JLabel("----> Input:");
        this.add(label1);

        jTextField = new JTextField(6);
        jTextField.setText("0");
        this.add(jTextField);
        
        label2 = new JLabel(" * 2 ----> 0");
        this.add(label2);
        
        jTextField.addActionListener(new TextFieldHandler());
        
        this.setVisible(true);
    }
    
    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String string = jTextField.getText();
            double n;
            try {
                n = Double.parseDouble(string);
            }
            catch (Exception ex) {
                n = 0;
            }
            label2.setText(" * 2 ----> " + (2*n));
        }
    }
}
