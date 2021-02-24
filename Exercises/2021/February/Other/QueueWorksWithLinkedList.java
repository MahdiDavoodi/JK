package ir.blog.mahdidavoodi;

import java.util.LinkedList;

public class QueueWorksWithLinkedList<T> extends LinkedList<T> {

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }


    public T first() {
        if (isEmpty()) return null;
        else return super.getFirst();
    }

    public T dequeue() {
        if (!isEmpty()) {
            return super.removeFirst();
        } else return null;
    }

    public void enqueue(T element) {
        super.addLast(element);
    }
}
