package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        IntegerBinaryTree tree = new IntegerBinaryTree();

        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.add(15);
        tree.add(25);
        tree.add(5);
        tree.add(1);

        tree.printArray();
        tree.printAllSorted();
        tree.printAllLeftSide();

        System.out.println("---> Size should be 7: " + tree.numberOfElements());
        System.out.println("---> Depth should be 3: " + tree.depth());
        System.out.println("---> Number of Leaves should be 3: " + tree.numberOfLeaves());
        System.out.println("---> We have 1 in there: " + tree.contains(1));
        tree.remove(1);
        System.out.println("---> Now we do not have 1 in there: " + !tree.contains(1));
        System.out.println("---> Depth should be 2 right now: " + tree.depth());
        System.out.println("---> Root should be 20: " + tree.getRoot());
        tree.remove(20);
        System.out.println("---> We removed root, so the size should be 5: " + tree.numberOfElements());
        System.out.println("---> Depth should be 1: " + tree.depth());

        System.out.println("---> The highest number is 30: " + (tree.highestNumber() == 30));
        System.out.println("---> The lowest number is 5: " + (tree.lowestNumber() == 5));
        tree.printAll();
        tree.printAllSorted();
        tree.printAllReverse();


    }
}
