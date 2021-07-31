package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) continue;         // skip number six ... means go to next i (first of the loop).
            System.out.format("%d\t%d\n", i, i * i);
            if (i == 7) break;
        }
    }
}
