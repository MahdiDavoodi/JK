package ir.blog.mahdidavoodi;

public class MyLinkedListIteratorTest {
    public static void main(String[] args) {

        MyLinkedList<String> myList = new MyLinkedList<>();

        myList.add("Mahdi");
        myList.add("Kotlin");
        myList.add("Java");
        myList.add("Taha");

        for (String string : myList)
            System.out.println(string);
    }
}

