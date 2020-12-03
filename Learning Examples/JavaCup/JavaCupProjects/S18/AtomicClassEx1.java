package ir.blog.mahdidavoodi;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * This is just an introduction to atomic classes for me.
 * Atomic classes are thread-safe and lock-free.
 * It means we don't need any synchronization. 😄
 * */
public class AtomicClassEx1 {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(3);
        System.out.println(integer.get());
        integer.set(20); // integer = 20
        System.out.println(integer.getAndIncrement()); // integer = 21, print = 20
        System.out.println(integer.addAndGet(5)); // integer = 26, print = 26
        System.out.println(integer.compareAndSet(26, 30)); // integer = 30, print = true
    }
}
