package ir.blog.mahdidavoodi;

/*
 * A simple example for functional Interfaces.
 * */
public class FunctionalInterfaceEx {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.hello();
        myClass.goodbye();
    }
}

@FunctionalInterface
interface MyInterface {
    void hello();

    default void goodbye() {
        System.out.println("Goodbye Friend!");
    }
}

class MyClass implements MyInterface {
    @Override
    public void hello() {
        System.out.println("Hello Friend!");
    }
}