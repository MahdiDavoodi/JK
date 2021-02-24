package ir.blog.mahdidavoodi;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {
    Position<T> root();

    Position<T> parent(Position<T> position) throws IllegalArgumentException;

    Iterable<Position<T>> children(Position<T> position) throws IllegalArgumentException;

    int numberOfChildren(Position<T> position) throws IllegalArgumentException;

    boolean isInternal(Position<T> position) throws IllegalArgumentException;

    boolean isExternal(Position<T> position) throws IllegalArgumentException;

    boolean isRoot(Position<T> position) throws IllegalArgumentException;

    boolean isEmpty();

    int size();

    Iterator<T> iterator();

    Iterable<Position<T>> positions();
}
