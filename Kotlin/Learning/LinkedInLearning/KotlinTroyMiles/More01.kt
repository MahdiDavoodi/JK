/*
* This is from another course by Troy for Kotlin.
* In this example I want to use some advanced loops.
* */
fun main() {
    val list = listOf(10, 20, 30, 40, 50, 60, 70, 80, 90)

    // 1
    for (x in 10.rangeTo(20))
        print("$x ")
    println()

    // 2
    for (x in 20.rangeTo(40).step(2))
        print("$x ")
    println()

    // 3
    for ((index, x) in list.withIndex())
        print("$index - $x / ")
    println()

    // 4
    for (x in list.indices)
        print("${list[x]} - ")
    println()
}