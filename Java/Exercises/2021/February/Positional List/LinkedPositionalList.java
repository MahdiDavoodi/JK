package ir.blog.mahdidavoodi;

import java.util.Iterator;

public class LinkedPositionalList<T> implements PositionalList<T>, Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new LinkedPositionalListIterator<T>(this);
    }

    private static class LinkedPositionalListIterator<T> implements Iterator<T> {
        private Node<T> node;
        private final Node<T> tail;

        public LinkedPositionalListIterator(LinkedPositionalList<T> list) {
            node = list.head.getNext();
            tail = list.tail;
        }

        @Override
        public boolean hasNext() {
            return node != null && node != tail;
        }

        @Override
        public T next() {
            T reply = node.getElement();
            node = node.getNext();
            return reply;
        }
    }

    private class PositionalIterator implements Iterator<Position<T>> {

        private Position<T> current = first();
        private Position<T> last = null;

        @Override
        public boolean hasNext() {
            Node<T> n = (Node<T>) current;
            return current != null && current != tail && n.getNext() != null;
        }

        @Override
        public Position<T> next() {
            last = current;
            current = after(current);
            return last;
        }
    }

    private class PositionalIterable implements Iterable<Position<T>> {

        @Override
        public Iterator<Position<T>> iterator() {
            return new PositionalIterator();
        }
    }

    public Iterable<Position<T>> positions() {
        return new PositionalIterable();
    }

    private static class Node<T> implements Position<T> {
        private T element;
        private Node<T> prev, next;

        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public T getElement() throws IllegalStateException {
            if (next == null) throw new IllegalStateException("Position no longer valid.");
            return element;
        }
    }

    private final Node<T> head;
    private final Node<T> tail;
    private int s = 0;

    public LinkedPositionalList() {
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, null, head);
        head.setNext(tail);
    }

    private Node<T> validate(Position<T> position) {
        if (isEmpty()) return null;
        Node<T> current = head;
        for (int i = 0; i <= s; i++) {
            if (current == position) return current;
            else current = current.getNext();
        }
        return null;
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
    public Position<T> first() {
        if (isEmpty()) return null;
        else return head.getNext();
    }

    @Override
    public Position<T> last() {
        if (isEmpty()) return null;
        else return tail.getPrev();
    }

    @Override
    public Position<T> before(Position<T> position) throws IllegalArgumentException {
        Node<T> node = validate(position);
        assert node != null;
        return node.getPrev();
    }

    @Override
    public Position<T> after(Position<T> position) throws IllegalArgumentException {
        Node<T> node = validate(position);
        assert node != null;
        return node.getNext();
    }

    @Override
    public Position<T> addFirst(T element) {
        return addAfter(head, element);
    }

    @Override
    public Position<T> addLast(T element) {
        return addBefore(tail, element);
    }

    @Override
    public Position<T> addBefore(Position<T> position, T element) throws IllegalArgumentException {
        Node<T> node = validate(position);
        Node<T> newNode = new Node<T>(element, null, null);
        assert node != null;
        return addBetween(newNode, node.getPrev(), node);
    }

    @Override
    public Position<T> addAfter(Position<T> position, T element) throws IllegalArgumentException {
        Node<T> node = validate(position);
        Node<T> newNode = new Node<T>(element, null, null);
        assert node != null;
        return addBetween(newNode, node, node.getNext());
    }

    @Override
    public T set(Position<T> position, T element) throws IllegalArgumentException {
        Node<T> node = validate(position);
        T reply = node.getElement();
        node.setElement(element);
        return reply;
    }

    @Override
    public T remove(Position<T> position) throws IllegalArgumentException {
        Node<T> node = validate(position);
        assert node != null;
        T reply = node.getElement();
        removeBetween(node);
        return reply;
    }

    public Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getNext();
    }

    public T get(int index) {
        if (index == 0) return getFirst();
        else if (index == s - 1) return getLast();
        else if (index > 0 && index < s - 1) {
            return getNode(index).getElement();
        }
        return null;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        else return head.getNext().getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        else return tail.getPrev().getElement();
    }

    public void remove(int index) {
        if (index >= 0 && index < s)
            removeBetween(getNode(index));
    }

    private void removeBetween(Node<T> node) {
        s--;
        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }

    public void add(T element) {
        add(element, s);
    }

    private Position<T> addBetween(Node<T> newNode, Node<T> prevNode, Node<T> nextNode) {
        s++;
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        return newNode;
    }

    public void add(T element, int index) {

        Node<T> newNode = new Node<T>(element, null, null);

        if (index == 0) {
            addBetween(newNode, head, head.getNext());
        } else if (index == s) {
            addBetween(newNode, tail.getPrev(), tail);
        } else if (index > 0 && index < s) {

            Node<T> current = head.getNext();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            addBetween(newNode, current, current.getNext());

        } else add(element);
    }

}
