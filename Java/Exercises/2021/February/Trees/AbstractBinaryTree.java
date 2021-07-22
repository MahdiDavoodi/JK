package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
    @Override
    public Position<T> siblings(Position<T> position) throws IllegalArgumentException {
        Position<T> parent = parent(position);
        if (parent == null) return null;   // Root
        if (position == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    @Override
    public int numberOfChildren(Position<T> position) throws IllegalArgumentException {
        int counter = 0;
        if (left(position) != null) counter++;
        if (right(position) != null) counter++;
        return counter;
    }

    @Override
    public Iterable<Position<T>> children(Position<T> position) throws IllegalArgumentException {
        List<Position<T>> snapshot = new ArrayList<>(2);
        if (left(position) != null) snapshot.add(left(position));
        if (right(position) != null) snapshot.add(right(position));
        return snapshot;
    }
}
