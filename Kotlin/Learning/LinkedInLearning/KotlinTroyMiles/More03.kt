import java.util.*

/*
* This is an example for Kotlin generics.
* */
fun main() {
    println("---> Please input the values with dash between them:")
    print("$ ")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().trim().split("-")
    scanner.close()
    if (isEqual(input[0], input[1]))
        println("---> They are equal!")
    else
        println("They are NOT equal!")
    val name: Long = 24546456
}

// This function gets T and returns T.
fun <T> isEqual(a: T, b: T): Boolean {
    return a == b
}