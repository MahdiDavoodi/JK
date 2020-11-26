package ir.blog.mahdidavoodi;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
    public static void main(String[] args) {
        /*
         * Linked list is another kind of containers that implements List.
         * When we use LinkedList? when we have many add and remove objects (Because ArrayList do many copy for add and remove)
         * When we use ArrayList? When we need to work with Indexes a lot.
         * Notice: LinkedList doesn't work with an Array. It has node instead of array.(Each object point to their next and previous object)
         * */
        List<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(3);
        linkedList1.add(28);
        linkedList1.add(34);
        linkedList1.remove(3);
        System.out.println(linkedList1.indexOf(28));
        int number = linkedList1.get(1);
    }
}
