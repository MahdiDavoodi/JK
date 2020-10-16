package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        Complex z1 = new Complex(3, 4);
        Complex z2 = new Complex(1, 2);
        Complex z3 = z1.add(z2);
        Complex z4 = z1.subtract(z2);
        Complex z5 = z1.multiply(z2);
        Complex z6 = z1.divide(z2);

        System.out.format("z1 = %s\n", z1);
        System.out.format("abs(z1) = %s\n", z1.abs());
        System.out.format("phase(z1) = %s\n", z1.phase());
        System.out.format("conj(z1) = %s\n", z1.conj());
        System.out.format("z2 = %s\n", z2);
        System.out.format("z3 = z1 + z2 = %s\n", z3);
        System.out.format("z4 = z1 - z2 = %s\n", z4);
        System.out.format("z5 = z1 * z2 = %s\n", z5);
        System.out.format("z6 = z1 / z2 = %s\n", z6);
        
        // Java will call the complex.toString automatically if is it there. because that is a standard name.


    }
}
