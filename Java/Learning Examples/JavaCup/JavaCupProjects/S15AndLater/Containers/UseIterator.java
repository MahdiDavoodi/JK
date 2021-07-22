package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseIterator {
    public static void main(String[] args) {
        /*
         * We use Iterator like foreach.
         * It's a useful thing for work with Collections and arrays.
         * In fact, every foreach, use an Iterator!
         * */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer % 2 == 0)
                iterator.remove();
        }
        System.out.println(list.size());
    }
}
