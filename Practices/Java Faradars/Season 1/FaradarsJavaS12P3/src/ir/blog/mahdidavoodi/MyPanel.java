package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        MyLine line1 = new MyLine(graphics);
        line1.from(0, 0);
        line1.to(100, 200);
        line1.draw();
        
        graphics.setColor(Color.red);
        
        MyLine line2 = new MyLine(graphics, 50, 0, 300, 200);
        line2.setColor(Color.blue);
        line2.draw();
        
        MyCircle circle = new MyCircle(graphics, 100, 100, 50);
        circle.setColor(Color.green);
        circle.draw();

        graphics.drawRect(30, 30, 150, 150);
        
    }
}
