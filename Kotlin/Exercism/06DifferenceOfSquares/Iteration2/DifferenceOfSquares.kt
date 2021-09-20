import kotlin.math.*

class Squares(private val n: Int) {

    fun sumOfSquares() = 1.rangeTo(n).sumBy { x -> x * x }

    fun squareOfSum() = 1.rangeTo(n).sum().toDouble().pow(2).toLong()

    fun difference() = (sumOfSquares() - squareOfSum()).absoluteValue

}
/*
* This is an exercise from Exercism.
* Link -->  https://exercism.org/tracks/kotlin/exercises/difference-of-squares
* This is my second try - Iteration 2 - A little better.
* Changes from Iteration 1: Replace sequences with rangeTo() method. + Using sumBy{} instead of map{}.
* */