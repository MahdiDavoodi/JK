package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        double m = Maximum(10, 25, 15, 30, 12, 60, 0, 0, 10);

        System.out.format("Max = %f\n", m);
    }

    public static double Maximum(double... A) {           // Use variable list. "...". Notice: we can only have one variable like this.
        double max = A[0];
        for (double a : A) {
            if (a > max) {
                max = a;
            }
        }

        return max;
    }
}
