package ir.blog.mahdidavoodi;

public class EquationSolver {

    public static void solveEq(double a, double b) {
        double x = -b / a;
        System.out.println("----> Solving Equation: ax + b = 0.");
        System.out.format("----> Answer is x = %.2f", x);
    }

    // We can Overload the methods. We just have to change the parameters (method's signature).
    
    public static void solveEq(double a, double b, double c) {
        double delta = b * b - 4 * a * c, x;
        System.out.println("----> Solving Equation: ax^2 + bx + c = 0.");
        if (delta > 0) {
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            x = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.format("----> Answer is x1 = %.2f \t and \t x2 = %.2f", x, x2);
        } else if (delta == 0) {
            x = -b / (2 * a);
            System.out.format("----> Answer is x = %.2f", x);
        } else {
            System.out.println("----> The equation doesn't have any answer!");
        }
    }
}
