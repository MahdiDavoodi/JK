package ir.blog.mahdidavoodi;

/*
 * My Stack that woks with linked list base.
 * */
public class MyLinkedListStack<T> implements MyStack<T> {

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
    public void push(T element) {
        head = new Node(element, head);
        if (s == 0) tail = head;
        s++;
    }

    @Override
    public T top() {
        if (isEmpty()) return null;
        else return head.getElement();
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T reply = head.getElement();
            head = head.getNext();
            s--;
            if (s == 0) tail = null;
            return reply;
        } else return null;
    }

    @Override
    public T bottom() {
        if (isEmpty()) return null;
        else return tail.getElement();
    }
}
