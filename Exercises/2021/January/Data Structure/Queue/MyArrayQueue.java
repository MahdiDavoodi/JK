package ir.blog.mahdidavoodi;

public class MyArrayQueue<T> implements MyQueue<T> {
    private static final int capacity = 1000;
    private int s = 0;
    private int firstIndex = 0;
    private T[] array;

    public MyArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public MyArrayQueue() {
        this(capacity);   // Capacity should be static.
    }

    @Override
    public int size() {
        return s;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        else return array[firstIndex];
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T reply = array[firstIndex];
        array[firstIndex] = null; // remove that.
        firstIndex = (firstIndex + 1) % array.length;
        s--;
        return reply;
    }

    @Override
    public void enqueue(T element) {
        if (size() == array.length) throw new IllegalStateException("Queue is full!");
        int index = (firstIndex + s) % array.length;
        array[index] = element;
        s++;
    }
}
