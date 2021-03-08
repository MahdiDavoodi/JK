package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class IntegerHeapPriorityQueueSort {
    private final ArrayList<Integer> input;
    private int size;

    public IntegerHeapPriorityQueueSort(ArrayList<Integer> array) {
        input = array;
        size = array.size();
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            upHeap(i);
        }

        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            size--;
            downHeap(0);
        }
    }

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
        return getLeft(index) < size;
    }

    private boolean hasRight(int index) {
        return getRight(index) < size;
    }

    private void swap(int first, int second) {
        Integer temp = input.get(first);
        input.set(first, input.get(second));
        input.set(second, temp);
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parentIndex = getParent(index);
            if (input.get(parentIndex) <= input.get(index)) break;
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
                if (input.get(rightIndex) < input.get(leftIndex))
                    smallestChildIndex = rightIndex;
            }
            if (input.get(index) < input.get(smallestChildIndex)) break;
            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

}