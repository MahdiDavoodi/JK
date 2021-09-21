public class Twofer {
    public String twofer(String name) {
        return String.format("One for %s, one for me.", name == null ? "you" : name);
    }
}
/*
 * This is a challenge from Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/two-fer
 * This is my second try - Iteration 2.
 * Changes: Using "String.format" and if expression.
 * */