package ir.blog.mahdidavoodi;

/*
 * Reversing an array with stack
 * */
public class ReversingArrayStack {
    public static void main(String[] args) {
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        String[] strings = {"A", "B", "C", "D", "E", "F"};

        reversingWithArrayStack(array);
        reversingWithLinkedStack(strings);

        for (Integer integer :
                array) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        for (String string :
                strings) {
            System.out.print(string + ", ");
        }

    }

    protected static <T> void reversingWithArrayStack(T[] array) {
        MyStack<T> stack = new MyArrayStack<>();
        for (T type :
                array) {
            stack.push(type);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    protected static <T> void reversingWithLinkedStack(T[] array) {
        MyStack<T> stack = new MyLinkedListStack<>();
        for (T type :
                array) {
            stack.push(type);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
}
