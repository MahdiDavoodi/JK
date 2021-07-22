package ir.blog.mahdidavoodi;

public class MyTwoSideStack<T> implements MyStack<T> {

    public static final int CAPACITY = 500;
    private T[] array;
    private int topIndexA = -1;
    private int topIndexB;

    public MyTwoSideStack(int capacity) {
        array = (T[]) new Object[capacity];
        topIndexB = capacity;
    }

    public MyTwoSideStack() {
        this(CAPACITY);
    }

    @Override
    public int size() {
        return (topIndexA + 1) + (array.length - topIndexB);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T element) {
        if (size() == array.length) throw new IllegalStateException("Stack is full!");
        array[++topIndexA] = element;
    }

    @Override
    public T top() {
        if (isEmpty()) return null;
        return array[topIndexA];
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T reply = array[topIndexA];
        array[topIndexA] = null;
        topIndexA--;
        return reply;
    }

    @Override
    public T bottom() {
        if (isEmpty()) return null;
        return array[0];
    }

    public void pushB(T element) {
        if (size() == array.length) throw new IllegalStateException("Stack is full!");
        array[--topIndexB] = element;
    }


    public T topB() {
        if (isEmpty()) return null;
        return array[topIndexB];
    }


    public T popB() {
        if (isEmpty()) return null;
        T reply = array[topIndexB];
        array[topIndexB] = null;
        topIndexB++;
        return reply;
    }


    public T bottomB() {
        if (isEmpty()) return null;
        return array[array.length - 1];
    }
}
