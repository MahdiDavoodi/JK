public class Hamming {
    private final String left, right;

    public Hamming(String left, String right) {
        if (left.length() == right.length()) {
            this.left = left;
            this.right = right;
        } else if (left.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        else if (right.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        else
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    public int getHammingDistance() {
        int difference = 0;
        for (int i = 0; i < left.length(); i++)
            if (left.charAt(i) != right.charAt(i))
                difference++;
        return difference;
    }
}
/*
 * This is a challenge from Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/hamming
 * This is my first try - Iteration 1.
 * */