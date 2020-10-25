package ir.blog.mahdidavoodi;

import java.awt.*;

public class MyCircle {
    
    private Graphics graphics;
    private int x, y;
    private int r;
    private Color color;
    
    public MyCircle(Graphics graphics) {
        this(graphics, 0, 0, 0);
    }
    
    public MyCircle(Graphics graphics, int x, int y, int r) {
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = graphics.getColor();
    }
    
    public int getX() {return this.x;}
    public void setX(int x) {this.x = x;}
    
    public int getY() {return this.y;}
    public void setY(int y) {this.y = y;}    

    public int getR() {return this.r;}
    public void setR(int r) {this.r = r;}
    
    public Color getColor() {return this.color;}
    public void setColor(Color color) {this.color = color;}
    
    public void center(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw() {
        Color temp_color = this.graphics.getColor();
        this.graphics.setColor(this.color);
        this.graphics.drawOval(x-r, y-r, 2*r, 2*r);
        this.graphics.setColor(temp_color);
    }
    

}
