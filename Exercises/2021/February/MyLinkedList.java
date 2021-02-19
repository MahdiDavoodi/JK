package ir.blog.mahdidavoodi;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    protected static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public boolean isEqualElements(T element) {
            return this.element == element;
        }

    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) return current;
            else current = current.getNext();
        }
        return null;
    }

    public T get(int index) {
        if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else if (index > 0 && index < size - 1) {
            Node<T> current = head;
            for (int i = 0; i < size; i++) {
                if (i == index) return current.getElement();
                else current = current.getNext();
            }
        }

        return null;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        else return head.getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        else return tail.getElement();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T element) {
        head = new Node<T>(element, head);
        if (size == 0) tail = head;
        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node<T> newNode = new Node<>(element, null);
            size++;
            if (isEmpty()) head = newNode;
            else tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void add(T element) {
        addLast(element);
    }

    public void add(T element, int index) {
        if (isEmpty() || index == 0) {
            addFirst(element);
        } else {
            if (index > 0 && index < size - 1) {

                Node<T> current = head;
                for (int i = 1; i < index; i++) {
                    current = current.getNext();
                }
                Node<T> newNode = new Node<T>(element, current.getNext());
                current.setNext(newNode);
                size++;

            } else add(element);
        }

    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.getNext();
            size--;
            if (size == 0) tail = null;
        }
    }

    public void removeLast() {
        if (size > 1) {
            Node<T> current = head;
            int tailIndex = size - 1;
            for (int i = 1; i < tailIndex; i++) {
                current = current.getNext();
            }
            tail = current;
            current.setNext(null);
            size--;
        }
    }

    public void remove(int index) {
        if (index == 0) removeFirst();
        else if (index == size - 1) removeLast();
        else if (index > 0 && index < size - 1) {
            Node<T> current = head;
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
        }
    }


    private class LinkedListIterator<T> implements Iterator<T> {
        Node<T> current;

        public LinkedListIterator(MyLinkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getElement();
            current = current.getNext();
            return data;
        }
    }

}

