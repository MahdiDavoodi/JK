package ir.blog.mahdidavoodi;

public class TwoDLinkedList {
    private final MyLinkedArray<MyIntegerSortedLinkedList> dataBase;

    public TwoDLinkedList() {
        dataBase = new MyLinkedArray<>(10);
    }

    public void add(int element) {
        dataBase.get(element % 10).add(element);
    }

    public int get(int i, int j) {
        return dataBase.get(i).get(j);
    }

    public void remove(int i, int j) {
        dataBase.get(i).remove(j);
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < dataBase.get(i).size(); j++) {
                System.out.format("%5d", dataBase.get(i).get(j));
            }
            System.out.println();
        }
    }
}
