package ir.blog.mahdidavoodi;

/*
 * A simple example too see how Thread works!
 * */
public class ThreadEx3 {
    public static void main(String[] args) {
        new Thread(new PrintThread()).start();
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        Thread thread = Thread.currentThread();
        System.out.println("Main ID:" + thread.getId());
        System.out.println("Main Name:" + thread.getName());
    }
}

class PrintThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        Thread thread = Thread.currentThread();
        System.out.println("My Thread ID:" + thread.getId());
        System.out.println("My Thread Name:" + thread.getName());

    }
}
