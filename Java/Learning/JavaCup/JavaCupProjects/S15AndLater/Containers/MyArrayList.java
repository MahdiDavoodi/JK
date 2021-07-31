package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    public static void main(String[] args) {
        /*
         * A simple ArrayList object:
         * We can add any kind of objects to this container. Notice: its not a useful option.
         * */
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("Hello");
        arrayList1.add(3);
        arrayList1.remove(1);
        System.out.println(arrayList1.get(0));
        /*
         * A simple ArrayList object:
         * That contains specific type of objects. (For this example: String's objects)
         * Remember: We can not use primitive data types in containers. (Except Array)
         * */
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Hello Java!");
        arrayList2.add("Hello Google!");
        System.out.println(arrayList2.get(1));
        System.out.println(arrayList2.size());
        System.out.println(arrayList2.isEmpty());
        System.out.println(arrayList2.contains("Hello Java!"));
        arrayList2.remove("Hello Google!");
        arrayList1.indexOf("Hello Java!");
        arrayList2.clear();
        System.out.println(arrayList2.size());
        /*
         * And also, we can use List interface directly.
         * Because ArrayList implements List!
         * */
        List<String> list1 = new ArrayList<>();
        list1.add("Hey!");
    }
}
