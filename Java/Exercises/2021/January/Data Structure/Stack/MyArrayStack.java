package ir.blog.mahdidavoodi;

/*
 * My Stack that works with an array.
 * */
public class MyArrayStack<T> implements MyStack<T> {

    public static final int CAPACITY = 500;
    private T[] array;
    private int topIndex = -1;   // Index of the element in Stack.

    public MyArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public MyArrayStack() {
        this(CAPACITY);              // Calls another constructor.
    }

    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T element) {
        if (size() == array.length) throw new IllegalStateException("Stack is full!");
        array[++topIndex] = element;
    }

    @Override
    public T top() {
        if (isEmpty()) return null;
        return array[topIndex];
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T reply = array[topIndex];
        array[topIndex] = null;
        topIndex--;
        return reply;
    }

    @Override
    public T bottom() {
        if (isEmpty()) return null;
        return array[0];
    }
}
