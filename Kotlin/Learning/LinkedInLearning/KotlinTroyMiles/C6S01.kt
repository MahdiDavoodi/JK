/*
* In this one I want to take a look at regular functions on Kotlin.
* */
fun main() {
    // 3) Invoke a function.
    println(sayHello("Friends"))
    println(sayGoodbye("Friends"))

    println(printLevel("Mahdi", 20))
    println(printLevel("Nathan"))

    // 6) Default on the left.
    println(multiplyThree(two = 10, three = 3))
}

// 1) Function declaration.
fun sayHello(name: String): String {
    // 2) Return.
    return "---> Hello $name! Welcome to Kotlin 101."
}

// 4) Expression body.
fun sayGoodbye(name: String) = "Goodbye $name"

// 5) Default values.
fun printLevel(name: String, level: Int = 10) = "Dear $name, your level is $level"

fun multiplyThree(one: Int = 1, two: Int, three: Int) = one * two * three