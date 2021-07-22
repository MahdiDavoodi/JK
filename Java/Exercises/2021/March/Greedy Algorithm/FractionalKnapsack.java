package ir.blog.mahdidavoodi;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Greedy Algorithm examples solved by myself!
 * */
public class FractionalKnapsack {

    static class Item {
        Double cost;
        double weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            cost = (double) value / (double) weight;
        }
    }

    private static double maxValue(int[] weight, int[] values, int capacity) {
        Item[] items = new Item[weight.length];

        for (int i = 0; i < weight.length; i++) {
            items[i] = new Item(weight[i], values[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item2.cost.compareTo(item1.cost);
            }
        });

        double totalValue = 0d;

        for (Item item :
                items) {

            int currentWeight = (int) item.weight;
            int currentValue = (int) item.value;

            if (capacity - currentWeight >= 0) {
                capacity = capacity - currentWeight;
                totalValue += currentValue;
            } else {
                double fraction = ((double) capacity / (double) currentWeight);
                totalValue += (currentValue * fraction);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weight = {10, 40, 20, 30};
        int[] values = {60, 40, 100, 120};
        System.out.println("---> " + maxValue(weight, values, 50));
    }
}