import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.rangeClosed(1, input).sum(), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).map(number -> (int) Math.pow(number, 2)).sum();
    }

    int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
    }
}
/*
 * This is a challenge from Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/difference-of-squares
 * This is my first try - Iteration 1.
 * */