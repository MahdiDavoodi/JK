package ir.blog.mahdidavoodi;

/*
 * Some dynamic programming exercises for interviews.
 * I didn't solve this! I just understood and learned the answers!
 * */
public class KnapsackProblem {

    static int knapsack(int capacity, int[] weights, int[] values, int numberOfValues) {
        int i, w;
        int[][] table = new int[numberOfValues + 1][capacity + 1];

        for (i = 0; i <= numberOfValues; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    table[i][w] = 0;
                else if (weights[i - 1] <= w)
                    table[i][w] = Math.max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w]);
                else
                    table[i][w] = table[i - 1][w];
            }
        }
        return table[numberOfValues][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        System.out.println("---> Max value we can put in the bag: " + knapsack(capacity, weights, values, values.length));
    }
}

