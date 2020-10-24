package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        int number;
        try {
            number = divide(10, 0);
            System.out.format("----> number = %d\n", number);
        } catch (ArithmeticException ex) {
            System.out.format("----> Exception: %s\n", ex);
        }

    }

    public static int divide(int a, int b) throws ArithmeticException {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            System.out.println("----> Warning: Division by Zero.");
            throw ex;         // Throw the error.
        }
    }
}
