package ir.blog.mahdidavoodi;

public class Test {

    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList();
        list.add("hello");
        list.add("Goodbye");
        list.add("Java");
        list.add("Android");
        System.out.println("Size is 4 = " + list.size()); // 4
        System.out.println("List is empty = " + list.isEmpty()); // false

        System.out.println(list.remove(list.getNode(2))); // Java
        System.out.println("Size is 3 = " + list.size()); // 3

        System.out.println(list.get(2)); // Android
        System.out.println(list.set(list.getNode(0), "Google")); // hello
        System.out.println(list.get(0)); // Google

        System.out.println(list.size()); // 3
        list.addBefore(list.getNode(0), "Apple");
        System.out.println(list.size()); // 4
        System.out.println(list.get(0)); // Apple
        System.out.println("////////////////////");
        for (String s :
                list) {
            System.out.println(s);
        } // print all list.

        System.out.println("////////////////////");

        for (Position<String> position :
                list.positions()) {
            System.out.println(position.getElement());
        } // Also prints all list but works with positions.
    }
}
