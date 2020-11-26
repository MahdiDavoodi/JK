package ir.blog.mahdidavoodi;

/*
 * Java Limits for generics:
 * 1. We can not create an object from the type parameter.
 * 2. We can not create an array from the type parameter.
 * 3. We can not work with new, instanceOf and static for type parameter.
 * 4. Generic classes can not extends from Exception class! But it type parameters can.
 * because of Erasure!
 * */
public class MyGenericExample<E> {
    private E value;

    public MyGenericExample(E value) {
        this.value = value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public static void main(String[] args) {
        MyGenericExample<Integer> example = new MyGenericExample<>(2020);
        MyGenericExample<String> google = new MyGenericExample<>("Google ");
        System.out.println(google.getValue() + example.getValue());
    }
}
