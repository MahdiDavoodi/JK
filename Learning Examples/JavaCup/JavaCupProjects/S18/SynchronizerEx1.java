package ir.blog.mahdidavoodi;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/*
 * Overloading the Producer/Consumer example with a synchronizer.
 * */
public class SynchronizerEx1 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        Semaphore semaphore = new Semaphore(0);
        Thread[] threads = {new Producer(list, semaphore),
                new Producer(list, semaphore), new Consumer(list, semaphore),
                new Consumer(list, semaphore)};

        for (Thread thread :
                threads) {
            thread.start();
        }
        for (Thread thread :
                threads) {
            thread.join();
        }
        System.out.println("---> Finished: " + list.size());
    }
}

class Producer extends Thread {
    List<Integer> list;
    Semaphore semaphore;

    Producer(List<Integer> list1, Semaphore semaphore) {
        list = list1;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                Integer number = (int) (Math.random() * 1000);
                System.out.println("---> Added: " + number);
                list.add(number);
                semaphore.release();
            }
            try {
                Thread.sleep((long) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    List<Integer> list;
    Semaphore semaphore;

    Consumer(List<Integer> list1, Semaphore semaphore) {
        list = list1;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (list) {
                Integer fetch = list.remove(0);
                System.out.println("---> Fetched: " + fetch);
            }
        }
    }
}
