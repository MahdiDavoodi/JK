package ir.blog.mahdidavoodi;

public class PriorityQueue<T> {

    private static class Node<T> {
        private final Integer key;
        private final T value;
        private Node<T> next, prev;

        public Node(Integer key, T value, Node<T> next, Node<T> prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Integer getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private int size = 0;
    private final Node<T> head;
    private final Node<T> tail;

    public PriorityQueue() {
        head = new Node<>(null, null, null, null);
        tail = new Node<>(null, null, null, head);
        head.setNext(tail);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int key, T value) {
        Node<T> temp = head, newNode = new Node<>(key, value, null, null);
        if (isEmpty())
            add(newNode, head, tail);
        else {
            boolean added = false;
            for (int i = 0; i < size; i++) {
                temp = temp.getNext();
                if (temp.getKey() > key) {
                    add(newNode, temp.getPrev(), temp);
                    added = true;
                    break;
                }
            }
            if (!added) add(newNode, temp, tail);
        }
    }

    public T min() {
        if (isEmpty()) return null;
        else return head.getNext().getValue();
    }

    public T removeMin() {
        if (isEmpty()) return null;
        T reply = min();
        Node<T> temp = head.getNext().getNext();
        head.setNext(temp);
        temp.setPrev(head);
        size--;
        return reply;
    }

    private void add(Node<T> newNode, Node<T> prevNode, Node<T> nextNode) {
        size++;
        newNode.setNext(nextNode);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
    }

}
