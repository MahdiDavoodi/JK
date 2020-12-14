package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        System.out.println("------> Triangle 1:");
        Triangle triangle = new Triangle(6, 8);
        triangle.printTriangleInfo();
        System.out.println("---------------------");
        // We can fill the variables at first with constructor.
        // Then we can change variables with Getter/Setter.
        // We used Constructor and Setter/Getter together! just for learning.

        System.out.println("------> Triangle 2:");
        Triangle triangle1 = new Triangle(3, 4);
        triangle1.printTriangleInfo();
        System.out.println("---------------------");

        System.out.println("------> Triangle 3:");
        Triangle triangle2 = new Triangle(7, 24);
        triangle2.printTriangleInfo();
        System.out.println("---------------------");

    }
}
