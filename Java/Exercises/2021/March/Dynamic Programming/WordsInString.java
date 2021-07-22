package ir.blog.mahdidavoodi;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * How many ways we can use the words[] to create that sentence?
 * Print them!
 * */
public class WordsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] words = input.split(",");
        String sentence = scanner.nextLine().trim();
        scanner.close();
        LinkedList<String> temp = new LinkedList<>();
        meow(words, sentence, 0, temp);
    }

    static void meow(String[] words, String sentence, int sentenceIndex, LinkedList<String> used) {
        if (sentenceIndex >= sentence.length() - 1) {
            for (String string :
                    used) {
                System.out.print(string);
            }
            System.out.println();
        } else {
            for (String word :
                    words) {
                if (sentence.indexOf(word) == sentenceIndex) {
                    LinkedList<String> newList = new LinkedList<>(used);
                    newList.add(word);
                    meow(words, sentence, sentenceIndex + word.length(), newList);
                }
            }
        }
    }
}
