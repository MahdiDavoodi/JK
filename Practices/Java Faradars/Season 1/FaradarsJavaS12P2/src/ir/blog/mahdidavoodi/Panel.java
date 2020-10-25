package ir.blog.mahdidavoodi;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.setBackground(Color.WHITE);
        int xc = 200;
        int yc = 350;
        int r = 50;
        int n = 40;

        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            float h = (float) i / (n - 1);
            colors[i] = Color.getHSBColor(h, 1, 1);
        }
        colors[n - 1] = Color.white;

        int d = 160 / colors.length;

        for (int i = 0; i < colors.length; i++) {
            int j = colors.length - i - 1;
            FillArc(graphics, xc, yc, r + j * d, colors[i]);
        }


    }

    private void FillArc(Graphics g, int xc, int yc, int r, Color color) {
        g.setColor(color);
        g.fillArc(xc - r, yc - r, 2 * r, 2 * r, 0, 180);
    }
}
