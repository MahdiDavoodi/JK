/*
 * I will write a generic class later.
 * */
public class MyDoublyIntegerLinkedList {
    protected class Node {
        private final Integer element;
        private Node next;
        private Node prev;

        public Node(Integer element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public Integer getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public boolean isEqualElements(int element) {
            return this.element == element;
        }

    }

    private int size = 0;
    private Node head;
    private Node tail;

    public MyDoublyIntegerLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer getFirst() {
        if (isEmpty()) return null;
        else return head.getNext().getElement();
    }

    public Integer getLast() {
        if (isEmpty()) return null;
        else return tail.getPrev().getElement();
    }

    public void addFirst(int element) {
        add(element, 0);
    }

    public void addLast(int element) {
        add(element, size);
    }

    public void removeFirst() {
        if (!isEmpty()) remove(0);
    }

    public void removeLast() {
        if (!isEmpty()) remove(size - 1);
    }

    public boolean contains(int element) {
        Node node = head.getNext();
        for (int i = 0; i < size; i++) {
            if (node.isEqualElements(element)) return true;
            node = node.getNext();
        }
        return false;
    }

    public void add(int element) {
        addLast(element);
    }

    private void addBetween(Node newNode, Node prevNode, Node nextNode) {
        size++;
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
    }

    public void add(int element, int index) {

        Node newNode = new Node(element, null, null);

        if (index == 0) {
            addBetween(newNode, head, head.getNext());
        } else if (index == size) {
            addBetween(newNode, tail.getPrev(), tail);
        } else if (index > 0 && index < size) {

            Node current = head.getNext();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            addBetween(newNode, current, current.getNext());

        } else add(element);
    }

    public Node getNode(int index) {
        Node current = head.getNext();
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        return current;
    }

    public Integer get(int index) {
        if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else if (index > 0 && index < size - 1) {
            return getNode(index).getElement();
        }
        return null;
    }

    public Integer[] getAll() {
        Integer[] allElements = new Integer[size];
        for (int i = 0; i < size; i++) {
            allElements[i] = getNode(i).getElement();
        }
        return allElements;
    }

    public void printAll() {
        Integer[] all = getAll();
        for (Integer integer :
                all) {
            System.out.println(integer);
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size)
            removeBetween(getNode(index));
    }

    private void removeBetween(Node node) {
        size--;
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }
}
