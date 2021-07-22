package ir.blog.mahdidavoodi;

import java.util.concurrent.CountDownLatch;

/*
 * About this example:
 * This is a simple example for using CountDownLatch class.
 * We have three classes. One of them (SendEmail) needs to wait for the others.
 * So we use CountDownLatch for it.
 * Tip: (err and out): err is not buffered, so it's so faster than out. Also it's so useful when you want to see the order of the threads.
 * */
public class SynchronizedEx3 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new SendEmail(countDownLatch)).start();
        new Thread(new VirusChecker(countDownLatch)).start();
        new Thread(new EmailIndex(countDownLatch)).start();
    }
}

class SendEmail implements Runnable {
    private final CountDownLatch countDownLatch;

    public SendEmail(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("---> Sending Email...");
        WorkSleep.sleep(1000);
        System.err.println("---> Email sent!");
    }
}

class VirusChecker implements Runnable {
    private final CountDownLatch countDownLatch;

    public VirusChecker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.err.println("---> Scanning the email...");
        WorkSleep.sleep(200);
        System.err.println("---> Email scanned!");
        countDownLatch.countDown();
        WorkSleep.sleep(100);
        System.err.println("---> Scan finalized.");
    }
}

class EmailIndex implements Runnable {
    private final CountDownLatch countDownLatch;

    public EmailIndex(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.err.println("---> Indexing the email...");
        WorkSleep.sleep(200);
        System.err.println("---> Email indexed!");
        countDownLatch.countDown();
    }
}

class WorkSleep {
    protected static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
