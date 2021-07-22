package ir.blog.mahdidavoodi;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle() {
        super();
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(double w, double h) {
        super();
        this.width = w;
        this.height = h;
    }

    public Rectangle(double w, double h, String color, boolean filled) {
        super(color, filled);
        this.width = w;
        this.height = h;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double w) {
        this.width = w;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double h) {
        this.height = h;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString() {
        return "Rectangle Shape [Size = " + this.getWidth() + "x" + this.getHeight() + ", Area = " + this.getArea() + ", Color = " + this.getColor() + ", Filled = " + this.getFilled() + "]";
    }

}
