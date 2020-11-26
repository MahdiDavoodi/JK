package ir.blog.mahdidavoodi;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Rectangle {
    private int length, width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length &&
                width == rectangle.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}

public class MyHashCode {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(10, 5);
        Rectangle rectangle2 = new Rectangle(10, 5);
        /*
         * "rectangle1.equals(rectangle2)" will return false at first time.
         * Because we didn't overload a good equals method for them.
         * We have to equals() in Rectangle.
         * */

        System.out.println("----> The first and the second object are equals: " + rectangle1.equals(rectangle2));
        /*
         * Set uses hashcode();
         * For Set, we have to overload hashcode() method too.
         * We often overload hashcode() and equals() together.
         *  */

        Set<Rectangle> set = new HashSet<>();
        set.add(rectangle1);
        System.out.println("----> The first and the second object are equals: " + set.contains(rectangle2));
    }
}
