package ir.blog.mahdidavoodi;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();       // Make a random object.

        int n_times = 100000;
        int n1 = 0;                  // ... times if its 1.
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int random_n;

        for (int i = 0; i < n_times; i++) {
            random_n = random.nextInt(6) + 1;
            switch (random_n) {
                case 1:
                    n1++;
                    break;
                case 2:
                    n2++;
                    break;
                case 3:
                    n3++;
                    break;
                case 4:
                    n4++;
                    break;
                case 5:
                    n5++;
                    break;
                case 6:
                    n6++;
                    break;
            }
        }

        double p1 = (double) n1 / n_times;                        // We have to cast it to double.
        double p2 = (double) n2 / n_times;
        double p3 = (double) n3 / n_times;
        double p4 = (double) n4 / n_times;
        double p5 = (double) n5 / n_times;
        double p6 = (double) n6 / n_times;

        System.out.format("----> Results of rolling a dice %d times:\n", n_times);
        System.out.format("----> 1 = %d/%d = %.2f%%\n", n1, n_times, 100 * p1);
        System.out.format("----> 2 = %d/%d = %.2f%%\n", n2, n_times, 100 * p2);
        System.out.format("----> 3 = %d/%d = %.2f%%\n", n3, n_times, 100 * p3);
        System.out.format("----> 4 = %d/%d = %.2f%%\n", n4, n_times, 100 * p4);
        System.out.format("----> 5 = %d/%d = %.2f%%\n", n5, n_times, 100 * p5);
        System.out.format("----> 6 = %d/%d = %.2f%%\n", n6, n_times, 100 * p6);
    }
}
