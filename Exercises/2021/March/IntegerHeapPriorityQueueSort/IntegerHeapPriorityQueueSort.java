package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class IntegerHeapPriorityQueueSort {
    private final ArrayList<Integer> input;


    public IntegerHeapPriorityQueueSort(ArrayList<Integer> array) {
        input = array;
    }

    public void sort() {
        for (int i = 0; i < input.size(); i++) {
            toHeap(i);
        }

        for (int i = input.size() - 1; i >= 0; i--) {
            swap(0, i);
            for (int j = 0; j < i; j++) {
                toHeap(j);
            }
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        Integer temp = input.get(first);
        input.set(first, input.get(second));
        input.set(second, temp);
    }

    private void toHeap(int index) {
        while (index > 0) {
            int parentIndex = getParent(index);
            if (input.get(parentIndex) <= input.get(index)) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

}
