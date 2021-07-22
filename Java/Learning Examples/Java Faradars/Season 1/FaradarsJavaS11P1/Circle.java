package ir.blog.mahdidavoodi;

public class Circle extends Shape {

    private double radius;

    public Circle() {
        super();                         // We have not to write this line. Java will do it anyway :)
        this.radius = 0;
    }

    public Circle(double r) {
        super();
        this.radius = r;
    }

    public Circle(double r, String color, boolean filled) {
        super(color, filled);
        this.radius = r;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle Shape [Radius = " + this.getRadius() + ", Area = " + this.getArea() + ", Color = " + this.getColor() + ", Filled = " + this.getFilled() + "]";
    }
}
