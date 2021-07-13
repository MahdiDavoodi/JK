package davoodi.mahdi.java;

public interface MyThreeArgsFunction<T, X, V, R> {
    R apply(T t, X x, V v);
}
