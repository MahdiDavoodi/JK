package ir.blog.mahdidavoodi;

import java.util.ArrayList;

/*
 * My Integer Binary Tree.
 * */
public class IntegerBinaryTree {

    private static class Node {
        private Node left, right, parent;
        private Integer element;

        public Node(Node left, Node right, Node parent, Integer element) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }
    }

    private Node root;
    private int size = 0, depth = 0;

    // Constructor.
    public IntegerBinaryTree() {
        root = new Node(null, null, null, null);
    }

    // Other methods.
    public boolean isEmpty() {
        return size == 0;
    }

    public int numberOfElements() {
        return size;
    }

    // Root.
    public Integer getRoot() {
        return root.getElement();
    }

    private boolean isRoot(Node node) {
        return root == node;
    }

    // Add.
    public void add(Integer element) {
        Node newNode;
        if (isEmpty()) {
            root.setElement(element);
            newNode = root;
        } else {
            newNode = add(root, element);
        }
        size++;
        this.depth = Math.max(this.depth, depth(newNode));

    }

    private Node add(Node node, Integer element) {
        if (element >= node.getElement()) {
            // right
            if (node.getRight() == null) {
                Node newNode = new Node(null, null, node, element);
                node.setRight(newNode);
                return newNode;
            } else
                return add(node.getRight(), element);

        } else {
            // left
            if (node.getLeft() == null) {
                Node newNode = new Node(null, null, node, element);
                node.setLeft(newNode);
                return newNode;
            } else
                return add(node.getLeft(), element);
        }
    }

    // Print.
    public void printAll() {
        System.out.println("----> All:");
        printAll(root);
        System.out.println();
    }

    public void printAllSorted() {
        System.out.println("----> All Sorted:");
        printAllSorted(root);
        System.out.println();
    }

    public void printAllReverse() {
        System.out.println("----> All Sorted Reverse:");
        printAllReverse(root);
        System.out.println();
    }

    private void printAllReverse(Node node) {
        if (node.getRight() != null) printAllReverse(node.getRight());
        System.out.print(node.getElement() + ", ");
        if (node.getLeft() != null) printAllReverse(node.getLeft());
    }

    private void printAllSorted(Node node) {
        if (node.getLeft() != null) printAllSorted(node.getLeft());
        System.out.print(node.getElement() + ", ");
        if (node.getRight() != null) printAllSorted(node.getRight());
    }

    private void printAll(Node node) {
        System.out.print(node.getElement() + ", ");
        if (node.getLeft() != null) printAll(node.getLeft());
        if (node.getRight() != null) printAll(node.getRight());
    }

    public void printArray() {
        Integer[] array = toArray();
        int limit = 1, counter = 0;
        for (Integer integer : array) {
            counter++;
            if (integer != null) System.out.print(" ," + integer);
            if (counter == limit) {
                counter = 0;
                limit = limit * 2;
                System.out.println();
            }
        }
    }

    public void printAllLeftSide() {
        System.out.println("----> All left Sides: ");
        Node temp = root;
        while (true) {
            if (temp.getLeft() != null) {
                System.out.print(" ," + temp.getLeft().getElement());
                temp = temp.getLeft();

            } else break;
        }
        System.out.println();
    }

    // Contains.
    public boolean contains(Integer element) {
        if (isEmpty()) return false;
        return contains(root, element);
    }

    private boolean contains(Node node, int element) {
        if (node.getElement() == element) return true;
        else if (element > node.getElement() && node.getRight() != null)
            return contains(node.getRight(), element);
        else if (element < node.getElement() && node.getLeft() != null)
            return contains(node.getLeft(), element);

        return false;
    }

    // Remove.
    public void remove(Integer element) {
        while (contains(element)) {
            if (element == (int) root.getElement()) {

                if (root.getRight() != null) {
                    if (root.getLeft() != null) {
                        Node temp = root.getRight();
                        while (true) {
                            if (temp.getLeft() != null) temp = temp.getLeft();
                            else break;
                        }
                        temp.setLeft(root.getLeft());
                        root.getLeft().setParent(temp);
                    }
                    root = root.getRight();
                } else if (root.getLeft() != null) {
                    root = root.getLeft();
                } else root.setElement(null);


                size--;
                if (depth != 0) depth--;

            } else {
                Node removedNode;
                removedNode = remove(root, element);
                size--;
                if (depth == depth(removedNode)) {
                    assert removedNode != null;
                    depth = depth(removedNode.getParent());
                }

            }
        }
    }

    private Node remove(Node node, int element) {
        if (node.getElement() == element) {

            Node parent = node.getParent();
            Node rightChild = node.getRight();
            Node leftChild = node.getLeft();
            if (rightChild != null) {

                if (node == parent.getLeft())
                    parent.setLeft(rightChild);
                else if (node == parent.getRight())
                    parent.setRight(rightChild);

                rightChild.setParent(parent);

                if (leftChild != null) {

                    Node temp = rightChild;
                    while (true) {
                        if (temp.getLeft() != null) temp = temp.getLeft();
                        else break;
                    }
                    temp.setLeft(leftChild);
                    leftChild.setParent(temp);

                }

            } else if (leftChild != null) {
                if (node == parent.getLeft())
                    parent.setLeft(leftChild);
                else if (node == parent.getRight())
                    parent.setRight(leftChild);

                leftChild.setParent(parent);

            } else {
                if (node == parent.getLeft())
                    parent.setLeft(null);
                else if (node == parent.getRight())
                    parent.setRight(null);

            }

            return node;

        } else if (element > node.getElement() && node.getRight() != null) {
            return remove(node.getRight(), element);
        } else if (element < node.getElement() && node.getLeft() != null) {
            return remove(node.getLeft(), element);
        } else return null;

    }

    // Depth.
    public int depth() {
        return depth;
    }

    private int depth(Node node) {
        if (isRoot(node)) return 0;
        else return 1 + depth(node.getParent());
    }

    // Lowest and highest.
    public int lowestNumber() {
        if (isEmpty()) return 0;
        Node temp = root;
        while (true) {
            if (temp.getLeft() != null) temp = temp.getLeft();
            else break;
        }
        return temp.getElement();
    }

    public int highestNumber() {
        if (isEmpty()) return 0;
        Node temp = root;
        while (true) {
            if (temp.getRight() != null) temp = temp.getRight();
            else break;
        }
        return temp.getElement();
    }

    // Number of leaves.
    public int numberOfLeaves() {
        if (isEmpty()) return 0;
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node node) {
        int counter = 0;
        if (node.getLeft() == null && node.getRight() == null) return 1;
        else {
            if (node.getLeft() != null) counter = counter + numberOfLeaves(node.getLeft());
            if (node.getRight() != null) counter = counter + numberOfLeaves(node.getRight());
            return counter;
        }
    }

    // To list.
    public Integer[] toArray() {
        Integer[] array = new Integer[(int) Math.pow(depth, 3)];
        array[0] = root.getElement();
        toArray(root, array, 0);
        return array;
    }

    private void toArray(Node node, Integer[] array, int lastIndex) {
        if (node.getLeft() != null) {
            int newIndex = (lastIndex * 2) + 1;
            array[newIndex] = node.getLeft().getElement();
            toArray(node.getLeft(), array, newIndex);
        }
        if (node.getRight() != null) {
            int newIndex = (lastIndex * 2) + 2;
            array[newIndex] = node.getRight().getElement();
            toArray(node.getRight(), array, newIndex);
        }
    }
}
