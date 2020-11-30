package ir.blog.mahdidavoodi;

/*
 * A simple way to create a new Thread and use it.(2)
 * At first, we created a new Runnable.
 * Then we got it to the new Thread.
 * Notice: This is a better way. cuz we can extends other classes for our class.
 * At first way, we had to extends Thread!
 * */
public class ThreadEx2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("Goodbye Google!");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Thread!");
        System.out.println("Hello Java!");
    }
}