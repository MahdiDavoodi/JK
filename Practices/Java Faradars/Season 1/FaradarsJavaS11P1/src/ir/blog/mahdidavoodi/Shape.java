package ir.blog.mahdidavoodi;

public class Shape {

    private String color;
    private boolean filled;

    public Shape() {
        this.color = "";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void fill() {
        this.setFilled(true);
    }

    public void unfill() {
        this.setFilled(false);
    }

    @Override
    public String toString() {
        return "Shape [Color = " + this.getColor() + ", Filled = " + this.getFilled() + "]";
    }
}
