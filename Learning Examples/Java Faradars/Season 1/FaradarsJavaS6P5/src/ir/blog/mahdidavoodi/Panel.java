package ir.blog.mahdidavoodi;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int lines = 40, width = this.getWidth(), height = this.getHeight(), i, j;
        for (i = 0; i <= lines; i++) {
            j = lines - i;
            graphics.setColor(Color.BLUE);
            graphics.drawLine(i * width / lines, 0, 0, j * height / lines);
            graphics.setColor(Color.RED);
            graphics.drawLine(i * width / lines, height, width, j * height / lines);
            graphics.drawString("By Mahdi Davoodi!", height / 2, width / 2);    // Draw String in panel!

        }

    }
}
