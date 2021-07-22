package ir.blog.mahdidavoodi;

/*
 * Array for my Integer Sorted Linked List.
 * */
public class MyLinkedArray<T> {

    private static class Node<T> {
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

        public T getElement() {
            return element;
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
    }

    private final Node<T> head;
    private final Node<T> tail;
    private final int size;

    public MyLinkedArray(int size) {
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, null, head);
        head.setNext(tail);
        this.size = size;

        for (int i = 0; i < size; i++) {
            add((T) new MyIntegerSortedLinkedList());
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return getSize() == 0;
    }

    private Node<T> first() {
        if (isEmpty()) return null;
        else return head.getNext();
    }

    public Node<T> last() {
        if (isEmpty()) return null;
        else return tail.getPrev();
    }

    public Node<T> addFirst(T element) {
        return addAfter(head, element);
    }

    public Node<T> addLast(T element) {
        return addBefore(tail, element);
    }

    public Node<T> addBefore(Node<T> node, T element) throws IllegalArgumentException {
        Node<T> newNode = new Node<T>(element, null, null);
        return addBetween(newNode, node.getPrev(), node);
    }

    public Node<T> addAfter(Node<T> node, T element) throws IllegalArgumentException {
        Node<T> newNode = new Node<T>(element, null, null);
        return addBetween(newNode, node, node.getNext());
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
        else if (index == size - 1) return getLast();
        else if (index > 0 && index < size - 1) {
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
        if (index >= 0 && index < size)
            removeBetween(getNode(index), index);
    }

    private void removeBetween(Node<T> node, int index) {
        node.setElement(null);
        Node<T> nextNode = node.getNext();
        for (int i = index; i < size; i++) {
            node.setNext(nextNode.getNext());
            nextNode.setPrev(node.getPrev());
            node.setPrev(nextNode);
            nextNode.setNext(node);
        }
    }

    public void add(T element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            addLast(element);
        }
    }

    private Node<T> addBetween(Node<T> newNode, Node<T> prevNode, Node<T> nextNode) {
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        return newNode;
    }
}
