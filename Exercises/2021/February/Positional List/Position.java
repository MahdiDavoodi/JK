package ir.blog.mahdidavoodi;

public interface Position<T> {
    T getElement() throws IllegalStateException;
}
