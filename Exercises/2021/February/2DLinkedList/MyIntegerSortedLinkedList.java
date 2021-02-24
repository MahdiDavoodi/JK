package ir.blog.mahdidavoodi;

public class MyIntegerSortedLinkedList {

    private static class Node {
        private final Integer element;
        private Node prev, next;

        public Node(Integer element, Node next, Node prev) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private final Node head;
    private final Node tail;
    private int s = 0;

    public MyIntegerSortedLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }

    public int size() {
        return s;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Node first() {
        if (isEmpty()) return null;
        else return head.getNext();
    }

    public Node last() {
        if (isEmpty()) return null;
        else return tail.getPrev();
    }

    public Node addFirst(Integer element) {
        return addAfter(head, element);
    }

    public Node addLast(Integer element) {
        return addBefore(tail, element);
    }

    public Node addBefore(Node node, Integer element) throws IllegalArgumentException {
        Node newNode = new Node(element, null, null);
        return addBetween(newNode, node.getPrev(), node);
    }

    public Node addAfter(Node node, Integer element) throws IllegalArgumentException {
        Node newNode = new Node(element, null, null);
        return addBetween(newNode, node, node.getNext());
    }

    public Integer remove(Node node) throws IllegalArgumentException {
        Integer reply = node.getElement();
        removeBetween(node);
        return reply;
    }

    public Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getNext();
    }

    public Integer get(int index) {
        if (index == 0) return getFirst();
        else if (index == s - 1) return getLast();
        else if (index > 0 && index < s - 1) {
            return getNode(index).getElement();
        }
        return null;
    }

    public Integer getFirst() {
        if (isEmpty()) return null;
        else return head.getNext().getElement();
    }

    public Integer getLast() {
        if (isEmpty()) return null;
        else return tail.getPrev().getElement();
    }

    public void remove(int index) {
        if (index >= 0 && index < s)
            removeBetween(getNode(index));
    }

    private void removeBetween(Node node) {
        s--;
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }

    public void add(Integer element) {
        if (isEmpty()) {
            addFirst(element);
        } else {

            Node current = head;
            if (element < first().getElement()) {
                addFirst(element);
            } else {
                boolean added = false;
                for (int i = 0; i < s; i++) {
                    if (element < current.getNext().getElement()) {
                        Node newNode = new Node(element, null, null);
                        addBetween(newNode, current, current.getNext());
                        added = true;
                        break;
                    }
                    current = current.getNext();
                }
                if (!added) addLast(element);
            }
        }

    }

    private Node addBetween(Node newNode, Node prevNode, Node nextNode) {
        s++;
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        return newNode;
    }

}
