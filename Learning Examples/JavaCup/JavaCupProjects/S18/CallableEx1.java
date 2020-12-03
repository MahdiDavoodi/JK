package ir.blog.mahdidavoodi;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/*
 * An example for callable class.
 * In fact, it's like a runnable that can return anything.
 * We also use future in this example.
 * With "future", we can get the result without any start.
 * */
public class CallableEx1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Set<Future<Integer>> set = new HashSet<>();
        String[] words = {"Google", "Kotlin", "Java", "Android"};
        for (String word :
                words) {
            Callable<Integer> callable = new WordLength(word);
            Future<Integer> future = executorService.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future :
                set) {
            try {
                sum = sum + future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---> The sum of the words length: " + sum);
    }
}

class WordLength implements Callable<Integer> {
    private final String word;

    WordLength(String word) {
        this.word = word;
    }

    @Override
    public Integer call() {
        return word.length();
    }
}
