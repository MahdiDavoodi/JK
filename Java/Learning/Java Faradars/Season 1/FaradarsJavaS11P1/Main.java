package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {

        Shape shape = new Shape("Yellow", true);
        Circle circle = new Circle(8, "Blue", false);
        Rectangle rectangle = new Rectangle(3, 4, "Green", true);

        // Print our shapes information.
        System.out.format("----> shape: %s\n", shape);
        System.out.format("----> circle: %s\n", circle);
        System.out.format("----> rectangle: %s\n", rectangle);
    }
}
