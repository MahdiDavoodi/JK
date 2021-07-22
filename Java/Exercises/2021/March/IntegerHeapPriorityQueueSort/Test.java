package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            array.add(random.nextInt(20));
        }

        for (int integer :
                array) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        IntegerHeapPriorityQueueSort sort = new IntegerHeapPriorityQueueSort(array);
        sort.sort();
        for (int integer :
                array) {
            System.out.print(integer + ", ");
        }
    }
}