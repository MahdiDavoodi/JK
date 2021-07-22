package ir.blog.mahdidavoodi;

public interface Entry<K, V> {
    K getKey();

    V getValue();
}
