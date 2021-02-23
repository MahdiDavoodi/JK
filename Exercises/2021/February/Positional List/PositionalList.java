package ir.blog.mahdidavoodi;

public interface PositionalList<T> {
    int size();

    boolean isEmpty();

    Position<T> first();

    Position<T> last();

    Position<T> before(Position<T> position) throws IllegalArgumentException;

    Position<T> after(Position<T> position) throws IllegalArgumentException;

    Position<T> addFirst(T element);

    Position<T> addLast(T element);

    Position<T> addBefore(Position<T> position, T element) throws IllegalArgumentException;

    Position<T> addAfter(Position<T> position, T element) throws IllegalArgumentException;

    T set(Position<T> position, T element) throws IllegalArgumentException;

    T remove(Position<T> position) throws IllegalArgumentException;
}
