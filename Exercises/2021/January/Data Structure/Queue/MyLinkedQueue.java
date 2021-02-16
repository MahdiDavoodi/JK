package ir.blog.mahdidavoodi;

public class MyLinkedQueue<T> implements MyQueue<T> {

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

    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int s = 0;


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
        else return head.getElement();
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T reply = head.getElement();
            head = head.getNext();
            s--;
            if (s == 0) tail = null;
            return reply;
        } else return null;
    }

    @Override
    public void enqueue(T element) {
        if (isEmpty()) {
            head = new Node(element, head);
            if (s == 0) tail = head;
            s++;
        } else {
            Node<T> newNode = new Node<>(element, null);
            s++;
            if (isEmpty()) head = newNode;
            else tail.setNext(newNode);
            tail = newNode;
        }
    }
}
