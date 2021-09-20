class Matrix(matrixAsString: String) {

    private val rows = matrixAsString.split("\n+".toRegex())
    fun column(colNr: Int): List<Int> =
        rows.map { s: String -> s.trim().split("\\s+".toRegex())[colNr - 1].toInt() }.toList()

    fun row(rowNr: Int): List<Int> =
        rows[rowNr - 1].trim().split("\\s+".toRegex()).map { s: String -> s.toInt() }.toList()

}
/*
* This is a challenge from Exercism.
* Link ---> https://exercism.org/tracks/kotlin/exercises/matrix
* Note: Got a little help from Google for "\\s+" regex. Boy I should learn regex.
* This is my second try - Iteration 2 - Changes: I can define my functions without curly braces.
* */