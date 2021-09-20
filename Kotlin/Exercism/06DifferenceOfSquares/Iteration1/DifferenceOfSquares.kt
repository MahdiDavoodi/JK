import kotlin.math.absoluteValue
import kotlin.math.pow

class Squares(private val n: Int) {

    fun sumOfSquares(): Long = generateSequence(1) { it + 1 }.take(n).map { it * it }.sum().toLong()

    fun squareOfSum(): Long = generateSequence(1) { it + 1 }.take(n).sum().toDouble().pow(2).toLong()

    fun difference(): Long = (sumOfSquares() - squareOfSum()).absoluteValue

}
/*
* This is an exercise from Exercism.
* Link -->  https://exercism.org/tracks/kotlin/exercises/difference-of-squares
* This is my first try - Iteration 1.
* */