package ir.blog.mahdidavoodi;

public interface BinaryTree<T> extends Tree<T> {
    Position<T> left(Position<T> position) throws IllegalArgumentException;

    Position<T> right(Position<T> position) throws IllegalArgumentException;

    Position<T> siblings(Position<T> position) throws IllegalArgumentException;
}
