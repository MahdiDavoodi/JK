package ir.blog.mahdidavoodi;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Panel extends JPanel {
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.GRAY);
        graphics.drawRect(20, 20, 100, 50);   // Draw a gray Rectangle!
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(20, 20, 100, 50);   // Draw a yellow fill Rectangle!
        // Also we can draw a Square with this method.
        graphics.setColor(Color.GRAY);
        graphics.drawOval(150, 20, 100, 50);   // Draw a gray Ellipse!
        graphics.setColor(Color.RED);
        graphics.fillOval(150, 20, 100, 50);   // Draw a red fill Ellipse!
        // Also we can draw a Circle with this method.
        // We have many other methods to use.
    }
}
