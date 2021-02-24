package ir.blog.mahdidavoodi;

public class IntegerSortedLinkedList {

    protected static class Node {
        private final int element;
        private Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public boolean isEqualElements(int element) {
            return this.element == element;
        }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public IntegerSortedLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) return current;
            else current = current.getNext();
        }
        return current;
    }

    public int get(int index) {
        if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else if (index > 0 && index < size - 1) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (i == index) return current.getElement();
                else current = current.getNext();
            }
        }

        return 0;
    }

    public int getFirst() {
        if (isEmpty()) return 0;
        else return head.getElement();
    }

    public int getLast() {
        if (isEmpty()) return 0;
        else return tail.getElement();
    }

    public int[] getAll() {
        int[] allElements = new int[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            allElements[i] = current.getElement();
            current = current.getNext();
        }
        return allElements;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            Node newNode = new Node(element, null);
            size++;
            if (isEmpty()) head = newNode;
            else tail.setNext(newNode);
            tail = newNode;
        }
    }

    private void addFirst(int element) {
        head = new Node(element, head);
        if (size == 0) tail = head;
        size++;
    }

    public void add(int element) {
        if (isEmpty()) {
            addFirst(element);
        } else {

            Node current = head;
            if (element < current.getElement()) {
                addFirst(element);
            } else {
                boolean added = false;
                for (int i = 0; i < size - 1; i++) {
                    if (element < current.getNext().getElement()) {
                        Node newNode = new Node(element, current.getNext());
                        current.setNext(newNode);
                        size++;
                        added = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!added) addLast(element);
            }
        }

    }

    private void removeFirst() {
        if (!isEmpty()) {
            head = head.getNext();
            size--;
            if (size == 0) tail = null;
        }
    }

    private void removeLast() {
        if (size > 1) {
            Node current = head;
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
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
        }
    }

    public boolean contains(int element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.isEqualElements(element)) return true;
            node = node.getNext();
        }
        return false;
    }

}
