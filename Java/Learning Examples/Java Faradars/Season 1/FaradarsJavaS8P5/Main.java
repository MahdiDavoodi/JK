package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();

        // Adding Elements
        list.add(10);
        list.add(15);
        list.add(5);
        list.add(50);

        System.out.format("----> List = %s\n", list);

        // Remove Elements First way
        int index = list.indexOf(15);
        list.remove(index);

        // Also we can use this ---> "list.remove((Object) 15);"
        System.out.format("----> List = %s\n", list);

        // Remove Elements Second Way
        list.remove(2);
        System.out.format("list = %s\n", list);

        // Set Value
        list.set(0, 60);   // First index then number we want to set.
        System.out.format("----> List = %s\n", list);
    }
}
