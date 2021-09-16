/*
* This is a challenge from Exercism.org
* Link ---> https://exercism.org/tracks/kotlin/exercises/scrabble-score
* This is my first try -> Iteration 1.
* */
object ScrabbleScore {
    fun scoreLetter(c: Char): Int {
        return when (c.toUpperCase()) {
            'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
            'D', 'G' -> 2
            'B', 'C', 'M', 'P' -> 3
            'F', 'H', 'V', 'W', 'Y' -> 4
            'K' -> 5
            'J', 'X' -> 8
            'Q', 'Z' -> 10
            else -> 0
        }
    }

    fun scoreWord(word: String): Int {
        var score = 0
        word.forEach { char -> score += scoreLetter(char) }
        return score
    }
}