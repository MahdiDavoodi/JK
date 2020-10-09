package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        int a, b, c;
        a = 10;
        b = a++;  // Postfix Increment Operator
        c = ++a;  // Prefix Increment Operator
        System.out.format("a = %d\n", a);
        System.out.format("b = %d\n", b);
        System.out.format("c = %d\n", c);

    }
}
