package ir.blog.mahdidavoodi;

import java.awt.*;

public class MyLine {
    
    private Graphics graphics;
    private int x1, y1;
    private int x2, y2;
    private Color color;
    
    public MyLine(Graphics graphics) {
        this(graphics, 0, 0, 0, 0);
    }
    
    public MyLine(Graphics graphics, int x1, int y1, int x2, int y2) {
        this.graphics = graphics;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = graphics.getColor();
    }
    
    public int getX1() {return this.x1;}
    public void setX1(int x1) {this.x1 = x1;}
    
    public int getY1() {return this.y1;}
    public void setY1(int y1) {this.y1 = y1;}

    public int getX2() {return this.x2;}
    public void setX2(int x2) {this.x2 = x2;}
    
    public int getY2() {return this.y2;}
    public void setY2(int y2) {this.y2 = y2;}
    
    public Color getColor() {return this.color;}
    public void setColor(Color color) {this.color = color;}
    
    public void draw() {
        Color temp_color = this.graphics.getColor();
        this.graphics.setColor(this.color);
        this.graphics.drawLine(this.x1, this.y1, this.x2, this.y2);
        this.graphics.setColor(temp_color);
    }
    
    public void from(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void to(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

}
