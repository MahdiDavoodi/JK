/*
* Fizz buzz challenge by Troy Miles in Kotlin course.
* */
fun main() {
    for (n in 1..105) {
        println("$n ${fizzBuzz(n)}")
    }
}

fun fizzBuzz(number: Int): String {
    var result = " "
    if (number % 3 == 0)
        result += "Fizz "
    if (number % 5 == 0)
        result += "Buzz"
    return result
}