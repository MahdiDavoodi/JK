class Scrabble {

    private final String string;

    Scrabble(String word) {
        this.string = word.toUpperCase();
    }

    int getScore() {
        int score = 0;
        for (String s : string.split(""))
            score += score(s);
        return score;
    }

    private int score(String c) {
        return switch (c) {
            case "A", "E", "I", "O", "U", "L", "N", "R", "S", "T" -> 1;
            case "D", "G" -> 2;
            case "B", "C", "M", "P" -> 3;
            case "F", "H", "V", "W", "Y" -> 4;
            case "K" -> 5;
            case "J", "X" -> 8;
            case "Q", "Z" -> 10;
            default -> 0;
        };
    }
}
/*
 * This is a challenge on Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/scrabble-score
 * This is my first try, but also it's my second iteration - Iteration 2.
 * This solution works with JDK 13+.
 * */