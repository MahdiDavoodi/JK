package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        this.setBackground(Color.WHITE);
        
        graphics.setColor(Color.red);
        graphics.drawArc(10, 10, 300, 300, 45, 135);
    }
}
