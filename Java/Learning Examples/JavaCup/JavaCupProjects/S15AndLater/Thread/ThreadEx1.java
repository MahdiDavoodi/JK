package ir.blog.mahdidavoodi;

/*
 * A simple way to create a new Thread and use it.(1)
 * We have to extends Thread.
 *  */
public class ThreadEx1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Goodbye Thread!");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Thread!");
    }
}
