package ir.blog.mahdidavoodi;

public class IntegerArrayCollection {
    private final RowLinkedList[] dataBase;

    public IntegerArrayCollection() {
        dataBase = new RowLinkedList[10];
        for (int i = 0; i < 10; i++) {
            dataBase[i] = new RowLinkedList();
        }
    }

    public void add(int element) {
        dataBase[element % 10].add(element);
    }

    public int get(int i, int j) {
        return dataBase[i].get(j);
    }


    public boolean contains(int element) {
        return dataBase[element % 10].contains(element);
    }

    public void remove(int i, int j) {
        dataBase[i].remove(j);
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < dataBase[i].getSize(); j++) {
                System.out.format("%5d", dataBase[i].get(j));
            }
            System.out.println();
        }
    }
}
