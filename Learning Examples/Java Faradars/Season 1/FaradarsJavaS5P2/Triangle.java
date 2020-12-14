package ir.blog.mahdidavoodi;

public class Triangle {


    // IntelliJ IDEA: Use Alt+Insert for constructor and setter/getter methods.
    // Use Ctrl+Alt+L to organize your code.

    private double first, second;

    public Triangle(double first, double second) {
        setFirst(first);
        setSecond(second);
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = Math.abs(first);
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = Math.abs(second);
    }

    public void printTriangleInfo() {
        System.out.format("----> First = %.2f \t ----> Second = %.2f \t ----> Third = %.2f\n", first, second, computingC());
        System.out.format("----> Triangle's Phi = %.2f \t ----> Triangle's Theta = %.2f\n", trianglePhi(), triangleTheta());
        System.out.format("----> Triangle's Area = %.2f\n", triangleArea());
    }

    public double computingC() {
        return Math.sqrt(first * first + second * second);
    }

    public double triangleArea() {
        return (first * second / 2);
    }

    public double triangleTheta() {
        return Math.atan2(second, first) * 180 / Math.PI;
    }

    public double trianglePhi() {
        return Math.atan2(first, second) * 180 / Math.PI;
    }



}
