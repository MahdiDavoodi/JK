package ir.blog.mahdidavoodi;

import java.util.concurrent.Semaphore;

/*
 * An example to show how exactly semaphore works.
 * In this example, until a thread ends, the other one won't be started.
 * And that's because the semaphore we created!
 * We put 1 for it's constructor.
 * Actually, it works like a synchronized method.
 * */
public class SynchronizerEx2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Class(semaphore)).start();
        }
    }
}

class Class implements Runnable {
    private final Semaphore semaphore;

    public Class(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long ID = Thread.currentThread().getId();
        System.err.println("Thread ID " + ID + " ----> Stared");
        method();
        System.err.println("Thread ID " + ID + " ----> Finished");
        semaphore.release();
    }

    private void method() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
