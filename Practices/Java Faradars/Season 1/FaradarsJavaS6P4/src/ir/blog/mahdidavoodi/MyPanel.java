package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);          // We have to use the default method as well

        int width = this.getWidth();
        int height = this.getHeight();             // We can get the height and width of the panel.
        graphics.setColor(Color.BLUE);              // We can change the line color.
        graphics.drawLine(0, 0, width, height);        // We can draw a line with it's starting and ending point.

    }
}
