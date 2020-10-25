package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Panel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.black);

        int width = this.getWidth();
        int height = this.getHeight();
        Random random = new Random();
        int number = 300;

        for (int i = 0; i < number; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int s = 2 + random.nextInt(5);
            g.setColor(getRandomColor(random));           // Random Color
            g.fillOval(x, y, s, s);
        }
    }

    private Color getRandomColor(Random random) {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
