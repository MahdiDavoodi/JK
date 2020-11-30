package ir.blog.mahdidavoodi;

import java.util.LinkedList;
import java.util.List;

/*
 * An example for "synchronized", "wait" and "notify.
 * Producer fill list and Consumer, use it!
 * "*/
public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<>();

        Thread[] threads = {new Producer(list),
                new Producer(list), new Consumer(list),
                new Consumer(list)};

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

    Producer(List<Integer> list1) {
        list = list1;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                Integer number = (int) (Math.random() * 1000);
                System.out.println("---> Added: " + number);
                list.add(number);
                list.notify();
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

    Consumer(List<Integer> list1) {
        list = list1;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                while (list.size() == 0)
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                Integer fetch = list.remove(0);
                System.out.println("---> Fetched: " + fetch);
            }
        }
    }
}
