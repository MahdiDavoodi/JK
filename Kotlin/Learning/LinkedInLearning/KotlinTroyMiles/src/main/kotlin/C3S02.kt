/*
* In this exercise I want to take a look to if expression.
* Usage and tips about it.
* */

fun main() {
    val bool = true
    //We can use if expression to assign value.
    val number = if (bool) 1 else 0

    //Normal usage of "if" to do an action.
    if (!bool) {
        println("---> Hey IOS!")
    } else {
        println("---> Hello Android!")
    }

    //usage of "if-else-if"
    //As IDE says it too, We can actually use when expression in cases like this!
    if (number == 1)
        println("---> Google!")
    else if (number == 0)
        println("---> Apple!")
    else
        println("---> HP!")

    //We can assign ANY type in each branch!
    val wow: Any = if (bool && number == 1)
        "Kotlin is cool!"
    else 2021

    println("---> $wow")

    // We can assign booleans without if expression
    val bool2 = number == 1
    println("---> $bool2")
}