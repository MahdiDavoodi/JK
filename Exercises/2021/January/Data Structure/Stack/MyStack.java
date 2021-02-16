package ir.blog.mahdidavoodi;

/*
 * My Stack interface that show the main methods.
 */

public interface MyStack<T> {
    int size();

    boolean isEmpty();

    void push(T element);

    T top();

    T pop();

    T bottom();
}
