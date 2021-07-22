package ir.blog.mahdidavoodi;

public interface MyQueue<T> {
    int size();

    boolean isEmpty();

    T first();

    T dequeue();

    void enqueue(T element);
}
