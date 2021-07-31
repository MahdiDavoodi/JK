package ir.blog.mahdidavoodi;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int S = 6;
        int n_times = 1000;
        int[] n = new int[S+1];             // Our Array
        double[] p = new double[S+1];
        int k;

        for (int i = 0; i < n_times; i++) {
            k = random.nextInt(S) + 1;
            n[k]++;
        }

        System.out.format("Results of rolling a dice %d times:\n", n_times);

        for (int j = 1; j < S+1; j++) {
            p[j] = (double)n[j]/n_times;
            System.out.format("----> %d = %d/%d = %.2f%%\n", j, n[j], n_times, 100*p[j]);
        }
    }
}
