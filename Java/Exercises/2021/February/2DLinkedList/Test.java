package ir.blog.mahdidavoodi;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        TwoDLinkedList list = new TwoDLinkedList();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(90));
        }

        list.print();
    }
}
