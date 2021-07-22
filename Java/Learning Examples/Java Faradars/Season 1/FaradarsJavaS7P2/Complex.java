package ir.blog.mahdidavoodi;

public class Complex {
    private double real, imaginary;

    // Constructors.
    public Complex() {
        real = 0;
        imaginary = 0;
    }

    public Complex(double x) {
        real = x;
        imaginary = 0;
    }

    public Complex(double x, double y) {
        real = x;
        imaginary = y;
    }

    // Getter and Setter.

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public String toString() {
        String string;
        if (real != 0) {
            string = String.format(" %.2f", real);
            if (imaginary > 0) {
                string = string + String.format(" + %.2fi", imaginary);
            } else if (imaginary < 0) {
                string = string + String.format(" %.2fi", imaginary);
            }
        } else {
            if (imaginary != 0) {
                string = String.format(" %.2fi", imaginary);
            } else {
                string = String.format(" %.2f", real);
            }
        }

        return string;
    }

    public Complex add(Complex complex) {
        return new Complex(real + complex.getReal(), imaginary + complex.getImaginary());
    }

    public Complex add(double complex) {
        return new Complex(real + complex, imaginary);
    }

    public Complex subtract(Complex complex) {
        return new Complex(real - complex.getReal(), imaginary - complex.getImaginary());
    }

    public Complex subtract(double complex) {
        return new Complex(real - complex, imaginary);
    }

    public Complex multiply(Complex complex) {
        return new Complex((real * complex.getReal()) - (imaginary * complex.getImaginary()), (real * complex.getImaginary()) - (complex.getReal() * imaginary));
    }

    public Complex multiply(double complex) {
        return new Complex(real * complex, complex * imaginary);
    }

    public Complex divide(Complex complex) {

        double D = complex.getReal() * complex.getReal() + complex.getImaginary() * complex.getImaginary();
        return new Complex((real * complex.getReal() + imaginary * complex.getImaginary()) / D, (imaginary * complex.getReal() - complex.getImaginary() * real) / D);
    }

    public Complex divide(double complex) {
        return new Complex(real / complex, imaginary / complex);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double phase() {
        return Math.atan2(imaginary, real);
    }

    public Complex conj() {
        return new Complex(real, -imaginary);
    }

}
