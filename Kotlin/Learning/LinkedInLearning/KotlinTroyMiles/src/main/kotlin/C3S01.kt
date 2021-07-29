/*
* In this example we want to:
* See some things about Kotlin's expression nature,
* When expression(Like switch statement in Java),
* See the return type of function that returns nothing!,
* And if expression!(if statement in Java)*/
fun returnNothing() {

}

fun main() {
    val a = 100
    val b = 200
    //In Java, if statement can be: (a < b)? print a: print b.
    if (a < b) println(a) else println(b)

    //When in Kotlin is something like switch case in Java.
    val you = when (18) {
        in 0..20 -> "Young"
        in 20..35 -> "Adult"
        in 1000..2000 -> "Old"
        else -> "Beautiful"
    }

    println("---> You are $you")

    val result = returnNothing()
    println("---> The result of the void function in Kotlin: $result")
}