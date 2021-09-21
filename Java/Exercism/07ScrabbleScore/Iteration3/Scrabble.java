import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private final String string;
    private static final Map<Integer, Integer> scores = new HashMap<>();

    static {
        "AEIOULNRST".chars().forEach(c -> scores.put(c, 1));
        "DG".chars().forEach(c -> scores.put(c, 2));
        "BCMP".chars().forEach(c -> scores.put(c, 3));
        "FHVWY".chars().forEach(c -> scores.put(c, 4));
        "K".chars().forEach(c -> scores.put(c, 5));
        "JX".chars().forEach(c -> scores.put(c, 8));
        "QZ".chars().forEach(c -> scores.put(c, 10));
    }

    Scrabble(String word) {
        this.string = word.toUpperCase();
    }

    int getScore() {
        return string.chars().reduce(0, (sum, character) -> sum += scores.get(character));
    }
}
/*
 * This is a challenge on Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/scrabble-score
 * This is my second try - Iteration 3. Community help: Static block - HashMap.
 * */