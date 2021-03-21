package ir.blog.mahdidavoodi;

public class Coins {
    public static int dynamic(int[] coins, int n) {
        int total = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (n >= coins[i]) {
                n -= coins[i];
                total++;
                int temp = dynamic(coins, n);
                total = Math.min(total, temp);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] coins = {1, 2, 3};
        System.out.println("By Dynamic Programming " + dynamic(coins, n));
    }
}
