package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        int n = 12345;
        System.out.format("The number is %d.\n", n);
        System.out.format("The number is %08d.\n", n);
        System.out.format("The number is %+,6d.\n\n", n);
        double pi = Math.PI;
        System.out.format("The PI is %7f.\n", pi);
        System.out.format("The PI is %7.2f.\n", pi);
        System.out.format("The PI is %-7.3f.\n", pi);
        System.out.format("The PI is %-7.3f.\n", pi);
    }
}
