object ScrabbleScore {
    fun scoreWord(word: String): Int {
        return word.sumBy { ch ->
            when (ch.toUpperCase()) {
                in "AEIOULNRST" -> 1
                in "DG" -> 2
                in "BCMP" -> 3
                in "FHVWY" -> 4
                'K' -> 5
                in "JX" -> 8
                in "QZ" -> 10
                else -> 0
            }
        }
    }
}
/*
* This is a challenge from Exercism.org
* Link ---> https://exercism.org/tracks/kotlin/exercises/scrabble-score
* This is my second try -> Iteration 2.
* Learned from community.
* */