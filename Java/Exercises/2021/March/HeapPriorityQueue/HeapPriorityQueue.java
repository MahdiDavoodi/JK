package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class HeapPriorityQueue<T> {

    private static class Entry<T> {
        private final Integer key;
        private final T value;

        public Entry(Integer key, T value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private final ArrayList<Entry<T>> heap = new ArrayList<>();

    // Private methods...
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeft(int index) {
        return getLeft(index) < heap.size();
    }

    private boolean hasRight(int index) {
        return getRight(index) < heap.size();
    }

    private void swap(int first, int second) {
        Entry<T> temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parentIndex = getParent(index);
            if (heap.get(parentIndex).getKey() <= heap.get(index).getKey()) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void downHeap(int index) {
        while (hasLeft(index)) {
            int leftIndex = getLeft(index);
            int smallestChildIndex = leftIndex;
            if (hasRight(index)) {
                int rightIndex = getRight(index);
                if (heap.get(rightIndex).getKey() < heap.get(leftIndex).getKey())
                    smallestChildIndex = rightIndex;
            }
            if (heap.get(index).getKey() < heap.get(smallestChildIndex).getKey()) break;
            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    // Public methods...
    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T min() {
        if (heap.isEmpty()) return null;
        return heap.get(0).getValue();
    }

    public void insert(int key, T value) {
        Entry<T> newEntry = new Entry<>(key, value);
        heap.add(newEntry);
        upHeap(heap.size() - 1);
    }

    public T removeMin() {
        if (heap.isEmpty()) return null;
        T reply = min();
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return reply;
    }

}
